package com.employment.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.employment.bean.ClassroomBean;
import com.employment.bean.common.QueryParam;
import com.employment.dao.ClassroomDao;
import com.employment.service.Interface.IClassroomService;
import com.employment.service.support.BaseServiceImpl;
import com.employment.utils.BeanUtil;
import com.employment.utils.QueryUtil;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;


/**
 * Created by apple on 2017-2-9.
 */
@Service
public class ClassroomServiceImpl extends BaseServiceImpl<ClassroomDao,ClassroomBean> implements IClassroomService {


    public List<ClassroomBean> selectAllClassrooms(QueryParam queryParam) {
        ClassroomBean bean = (ClassroomBean) BeanUtil.newBean(queryParam,new ClassroomBean());
        EntityWrapper<ClassroomBean> ew = new EntityWrapper<ClassroomBean>(bean);
        ew.setSqlSelect("*");
        ew.orderBy("classroom_serial",true);
        QueryUtil.initEntityWrapper(ew,queryParam);
        List<ClassroomBean> list = selectList(ew);
        return list;
    }

    public Dictionary<String, ClassroomBean> selectClassroomMap(QueryParam queryParam) {
        List<ClassroomBean> list = selectAllClassrooms(queryParam);
        Dictionary<String,ClassroomBean> classroomMap = new Hashtable<String, ClassroomBean>();
        for(ClassroomBean entity:list){
            classroomMap.put(entity.getClassroom_id(),entity);
        }
        return classroomMap;
    }


}
