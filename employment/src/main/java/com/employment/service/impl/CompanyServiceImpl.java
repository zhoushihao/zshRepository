package com.employment.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.employment.bean.CompanyBean;
import com.employment.bean.common.QueryParam;
import com.employment.dao.CompanyDao;
import com.employment.service.Interface.ICompanyService;
import com.employment.service.support.BaseServiceImpl;
import com.employment.utils.BeanUtil;
import com.employment.utils.QueryUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by apple on 2017-2-9.
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl<CompanyDao,CompanyBean> implements ICompanyService {

    public List<CompanyBean> selectCompanies(QueryParam queryParam) {
        CompanyBean bean = (CompanyBean) BeanUtil.newBean(queryParam,new CompanyBean());
        EntityWrapper<CompanyBean> ew = new EntityWrapper<CompanyBean>(bean);
        ew.setSqlSelect("*");
        ew.orderBy("college_number");
        QueryUtil.initEntityWrapper(ew,queryParam);
        List<CompanyBean> list = selectList(ew);
        return list;
    }

    public List<CompanyBean> queryCompanies(QueryParam queryParam) {
        return null;
    }

    public boolean insertCompany(CompanyBean bean) {
        bean.setInsert_date(new Date());
        insert(bean);
        return true;
    }

    public boolean updateCompany(CompanyBean bean) {
        String[] include = {"company_name","comapny_address","manager"};
        CompanyBean update = (CompanyBean)BeanUtil.copyProperties(bean,new CompanyBean(),include);
        CompanyBean where = (CompanyBean)BeanUtil.newBean(bean,new CompanyBean());
        where.setCompany_id(bean.getCompany_id());
        updateSelective(update,where);
        return true;
    }

    public boolean deleteCompanies(List<CompanyBean> list) {
        for(CompanyBean entity:list){
            CompanyBean update = new CompanyBean();
            update.setInsert_date(new Date());
            update.setIs_del("Y");
            CompanyBean where = (CompanyBean)BeanUtil.newBean(entity,new CompanyBean());
            where.setCompany_id(entity.getCompany_id());
            updateSelective(update,where);
        }
        return true;
    }

}
