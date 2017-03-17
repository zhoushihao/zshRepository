package com.employment.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.employment.bean.ClassroomBean;
import com.employment.bean.CollegeBean;
import com.employment.bean.MajorBean;
import com.employment.bean.UniversityBean;
import com.employment.bean.common.QueryParam;
import com.employment.bean.common.WhereParam;
import com.employment.service.Interface.*;
import com.employment.utils.BeanUtil;
import com.employment.utils.QueryUtil;
import com.employment.utils.UUIDGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by apple on 2017-3-9.
 */
@Service
public class ConfigCenterServiceImpl implements IConfigCenterService {

    @Autowired
    IUniversityService universityService;
    @Autowired
    ICollegeService collegeService;
    @Autowired
    IMajorService majorService;
    @Autowired
    IClassroomService classroomService;

    public List<UniversityBean> queryUniversity(QueryParam queryParam) {
        return universityService.selectUniversities(queryParam);
    }

    public List<CollegeBean> queryCollege(UniversityBean o) {
        CollegeBean bean = (CollegeBean) BeanUtil.newBean(o, new CollegeBean());
        bean.setUniversity_id(o.getUniversity_id());
        EntityWrapper<CollegeBean> ew = new EntityWrapper<CollegeBean>(bean);
        ew.orderBy("college_number");
        return collegeService.selectList(ew);
    }

    public List<MajorBean> queryMajor(CollegeBean o) {
        MajorBean bean = (MajorBean) BeanUtil.newBean(o, new MajorBean());
        bean.setCollege_id(o.getCollege_id());
        EntityWrapper<MajorBean> ew = new EntityWrapper<MajorBean>(bean);
        ew.orderBy("major_number");
        return majorService.selectList(ew);
    }


    public List<ClassroomBean> queryClassroom(MajorBean o) {
        ClassroomBean bean = (ClassroomBean) BeanUtil.newBean(o, new ClassroomBean());
        bean.setMajor_id(o.getMajor_id());
        EntityWrapper<ClassroomBean> ew = new EntityWrapper<ClassroomBean>(bean);
        ew.orderBy("classroom_number");
        return classroomService.selectList(ew);
    }

    //更新操作
    public boolean update(UniversityBean universityBean) {
        /*
        查找学校的所有从属信息
         */
        Dictionary<String, CollegeBean> collegeMap = new Hashtable<String, CollegeBean>();
        Dictionary<String, MajorBean> majorMap = new Hashtable<String, MajorBean>();
        Dictionary<String, ClassroomBean> classroomMap = new Hashtable<String, ClassroomBean>();

        //查找对应学校下面的所有学院
        CollegeBean college = (CollegeBean) BeanUtil.newBean(universityBean, new CollegeBean());
        college.setUniversity_id(universityBean.getUniversity_id());
        EntityWrapper<CollegeBean> collegeEW = new EntityWrapper<CollegeBean>(college);
        List<CollegeBean> collegeList = collegeService.selectList(collegeEW);

        //查找学院下面的所有专业
        for (CollegeBean entity1 : collegeList) {
            collegeMap.put(entity1.getCollege_id(), entity1);
            MajorBean major = (MajorBean) BeanUtil.newBean(entity1, new MajorBean());
            major.setCollege_id(entity1.getCollege_id());
            EntityWrapper<MajorBean> majorEW = new EntityWrapper<MajorBean>(major);
            List<MajorBean> majorList = majorService.selectList(majorEW);

            //查找专业下面的所有班级
            for (MajorBean entity2 : majorList) {
                majorMap.put(entity2.getMajor_id(), entity2);
                ClassroomBean classroom = (ClassroomBean) BeanUtil.newBean(entity2, new ClassroomBean());
                classroom.setMajor_id(entity2.getMajor_id());
                EntityWrapper<ClassroomBean> classEW = new EntityWrapper<ClassroomBean>(classroom);
                List<ClassroomBean> classroomList = classroomService.selectList(classEW);

                for (ClassroomBean entity3 : classroomList) {
                    classroomMap.put(entity3.getClassroom_id(), entity3);
                }
            }
        }

        /*
        更新操作
         */
        for (CollegeBean entity1 : universityBean.getColleges()) {
            //更新学院
            String college_id = entity1.getCollege_id();
            CollegeBean result1 = collegeMap.get(college_id);
            if (null == college_id || null == result1) {
                entity1.setIs_del("N");
                entity1.setInsert_date(new Date());
                collegeService.insert(entity1);
            } else {
                String[] include = {"college_number", "college_name", "remark"};
                CollegeBean update = (CollegeBean) BeanUtil.copyProperties(entity1, new CollegeBean(), include);
                CollegeBean where = (CollegeBean) BeanUtil.newBean(universityBean, new CollegeBean());
                where.setCollege_id(college_id);
                collegeService.updateSelective(update, where);
                classroomMap.remove(college_id);
            }
            for (MajorBean entity2 : entity1.getMajors()) {
                //更新专业
                String major_id = entity2.getMajor_id();
                MajorBean result2 = majorMap.get(major_id);
                if (null == major_id || null == result2) {
                    entity2.setInsert_date(new Date());
                    entity2.setIs_del("N");
                    majorService.insert(entity2);
                } else {
                    String[] include = {"major_number", "major_name", "remark"};
                    MajorBean update = (MajorBean) BeanUtil.copyProperties(entity2, new MajorBean(), include);
                    MajorBean where = (MajorBean) BeanUtil.newBean(entity2, new MajorBean());
                    where.setMajor_id(major_id);
                    majorService.updateSelective(update, where);
                    majorMap.remove(major_id);
                }

                for (ClassroomBean entity3 : entity2.getClassroomList()) {
                    //更新班级
                    String classroom_id = entity3.getClassroom_id();
                    ClassroomBean result3 = classroomMap.get(classroom_id);
                    if (classroom_id == null || result3 == null) {
                        entity3.setInsert_date(new Date());
                        entity3.setIs_del("N");
                        classroomService.insert(entity3);
                    } else {
                        String[] include = {"classroom_number"};
                        ClassroomBean update = (ClassroomBean) BeanUtil.copyProperties(entity3, new ClassroomBean(), include);
                        ClassroomBean where = (ClassroomBean) BeanUtil.newBean(entity3, new ClassroomBean());
                        where.setClassroom_id(classroom_id);
                        classroomService.updateSelective(update, where);
                        classroomMap.remove(classroom_id);
                    }
                }

                Enumeration<CollegeBean> eCollege = collegeMap.elements();
                Enumeration<MajorBean> eMajor = majorMap.elements();
                Enumeration<ClassroomBean> eClassroom = classroomMap.elements();
//                List<CollegeBean> delColleges = new ArrayList<CollegeBean>();
//                List<MajorBean> delMajors = new ArrayList<MajorBean>();
//                List<ClassroomBean> delClassrooms = new ArrayList<ClassroomBean>();
                while (eCollege.hasMoreElements()) {
                    CollegeBean where = eCollege.nextElement();
                    CollegeBean update = new CollegeBean();
                    update.setDelete_date(new Date());
                    update.setIs_del("Y");
                    collegeService.updateSelective(update, where);
                }
                while (eMajor.hasMoreElements()) {
                    MajorBean where = eMajor.nextElement();
                    MajorBean update = new MajorBean();
                    update.setIs_del("Y");
                    update.setDelete_date(new Date());
                    majorService.updateSelective(update, where);
                }
                while (eClassroom.hasMoreElements()) {
                    ClassroomBean where = eClassroom.nextElement();
                    ClassroomBean update = new ClassroomBean();
                    update.setIs_del("Y");
                    update.setDelete_date(new Date());
                    classroomService.updateSelective(update, where);
                }
            }
        }


        return true;
    }

    //插入操作
    public boolean insert(UniversityBean universityBean) {
        universityBean.setUniversity_id(UUIDGeneratorUtil.getUUID());
        universityService.insert(universityBean);
        List<CollegeBean> collegeList = universityBean.getColleges();
        for (CollegeBean entity : collegeList) {
            BeanUtil.newBean(universityBean, entity);
            entity.setCollege_id(UUIDGeneratorUtil.getUUID());
            entity.setInsert_date(new Date());
        }
        collegeService.insertBatch(collegeList);

        for (CollegeBean entity1 : collegeList) {
            List<MajorBean> majorList = entity1.getMajors();
            for (MajorBean entity : majorList) {
                BeanUtil.newBean(entity1, entity);
                entity.setMajor_id(UUIDGeneratorUtil.getUUID());
                entity.setInsert_date(new Date());
            }
            majorService.insertBatch(entity1.getMajors());

            for (MajorBean entity2 : majorList) {
                List<ClassroomBean> classroomList = entity2.getClassroomList();
                for (ClassroomBean entity : classroomList) {
                    BeanUtil.newBean(entity2, entity);
                    entity.setInsert_date(new Date());
                }
                classroomService.insertBatch(entity2.getClassroomList());
            }
        }
        return true;
    }

    //删除操作
    public boolean deleteUniversity(List<UniversityBean> list) {
        for (UniversityBean entity1 : list) {
            UniversityBean update1 = new UniversityBean();
            update1.setIs_del("Y");
            update1.setDelete_date(new Date());
            UniversityBean where1 = (UniversityBean) BeanUtil.newBean(entity1, new UniversityBean());
            where1.setUniversity_id(entity1.getUniversity_id());

            CollegeBean update2 = new CollegeBean();
            update2.setIs_del("Y");
            update2.setDelete_date(new Date());
            CollegeBean where2 = (CollegeBean) BeanUtil.newBean(entity1, new CollegeBean());
            where2.setUniversity_id(entity1.getUniversity_id());

            List<CollegeBean> collegeList = queryCollege(entity1);
            for(CollegeBean entity2:collegeList){
                MajorBean update3 = new MajorBean();
                update3.setIs_del("Y");
                update3.setDelete_date(new Date());
                MajorBean where3 = (MajorBean)BeanUtil.newBean(entity2,new MajorBean());
                where3.setCollege_id(entity2.getCollege_id());

                List<MajorBean> majorList = queryMajor(entity2);
                for(MajorBean entity3:majorList){
                    ClassroomBean update4 = new ClassroomBean();
                    update4.setIs_del("Y");
                    update4.setDelete_date(new Date());
                    ClassroomBean where4 = (ClassroomBean)BeanUtil.newBean(entity3,new ClassroomBean());
                    where4.setMajor_id(entity3.getMajor_id());
                    classroomService.updateSelective(update4,where4);
                }
                majorService.updateSelective(update3,where3);
            }
            collegeService.updateSelective(update2, where2);
            universityService.updateSelective(update1, where1);
        }
        return true;
    }
}
