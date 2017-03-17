package com.employment.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.employment.bean.UniversityBean;
import com.employment.bean.common.QueryParam;
import com.employment.dao.UniversityDao;
import com.employment.service.Interface.IUniversityService;
import com.employment.service.support.BaseServiceImpl;
import com.employment.utils.BeanUtil;
import com.employment.utils.QueryUtil;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;


/**
 * Created by apple on 2017-2-9.
 */
@Service
public class UniversityServiceImpl extends BaseServiceImpl<UniversityDao,UniversityBean> implements IUniversityService {

    public List<UniversityBean> selectUniversities(QueryParam queryParam) {
        UniversityBean bean = (UniversityBean) BeanUtil.newBean(queryParam,new UniversityBean());
        EntityWrapper<UniversityBean> ew = new EntityWrapper<UniversityBean>(bean);
        ew.setSqlSelect("*");
        ew.orderBy("university_number");
        QueryUtil.initEntityWrapper(ew,queryParam);
        List<UniversityBean> list = selectList(ew);
        return list;
    }

    public HashMap<String, UniversityBean> selectUniversityMap(QueryParam queryParam) {
        List<UniversityBean> list = selectUniversities(queryParam);
        HashMap<String,UniversityBean> universityMap = new HashMap<String, UniversityBean>();
        for(UniversityBean entity:list){
            universityMap.put(entity.getUniversity_id(),entity);
        }
        return universityMap;
    }
}
