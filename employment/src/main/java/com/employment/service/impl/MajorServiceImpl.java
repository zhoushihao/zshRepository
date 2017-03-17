package com.employment.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.employment.bean.MajorBean;
import com.employment.bean.common.QueryParam;
import com.employment.dao.MajorDao;
import com.employment.service.Interface.IMajorService;
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
public class MajorServiceImpl extends BaseServiceImpl<MajorDao,MajorBean> implements IMajorService {

    public List<MajorBean> selectMajors(QueryParam queryParam) {
        MajorBean bean = (MajorBean) BeanUtil.newBean(queryParam,new MajorBean());
        EntityWrapper<MajorBean> ew = new EntityWrapper<MajorBean>(bean);
        ew.setSqlSelect("*");
        ew.orderBy("college_number");
        QueryUtil.initEntityWrapper(ew,queryParam);
        List<MajorBean> list = selectList(ew);
        return list;
    }

    public Dictionary<String, MajorBean> selectMajorMap(QueryParam queryParam) {
        List<MajorBean> list = selectMajors(queryParam);
        Dictionary<String,MajorBean> majorMap = new Hashtable<String, MajorBean>();
        for(MajorBean entity:list){
            majorMap.put(entity.getCollege_id(),entity);
        }
        return majorMap;
    }

}
