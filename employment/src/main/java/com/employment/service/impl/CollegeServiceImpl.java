package com.employment.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.employment.bean.CollegeBean;
import com.employment.bean.common.QueryParam;
import com.employment.dao.CollegeDao;
import com.employment.service.Interface.ICollegeService;
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
public class CollegeServiceImpl extends BaseServiceImpl<CollegeDao,CollegeBean> implements ICollegeService {


    public List<CollegeBean> selectAllColleges(QueryParam queryParam) {
        CollegeBean bean = (CollegeBean) BeanUtil.newBean(queryParam,new CollegeBean());
        EntityWrapper<CollegeBean> ew = new EntityWrapper<CollegeBean>(bean);
        ew.setSqlSelect("*");
        ew.orderBy("college_number");
        QueryUtil.initEntityWrapper(ew,queryParam);
        List<CollegeBean> list = selectList(ew);
        return list;
    }

    public Dictionary<String, CollegeBean> selectCollegeMap(QueryParam queryParam) {
        List<CollegeBean> list = selectAllColleges(queryParam);
        Dictionary<String,CollegeBean> collegeMap = new Hashtable<String, CollegeBean>();
        for(CollegeBean entity:list){
            collegeMap.put(entity.getCollege_id(),entity);
        }
        return collegeMap;
    }
}
