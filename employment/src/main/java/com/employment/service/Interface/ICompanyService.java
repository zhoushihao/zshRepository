package com.employment.service.Interface;

import com.baomidou.framework.service.ISuperService;
import com.employment.bean.CompanyBean;
import com.employment.bean.common.QueryParam;

import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
public interface ICompanyService extends ISuperService<CompanyBean>{

    List<CompanyBean> selectCompanies(QueryParam queryParam);

//    List<CompanyBean> queryCompanies(QueryParam queryParam);

    boolean insertCompany(CompanyBean bean);

    boolean updateCompany(CompanyBean bean);

    boolean deleteCompanies(List<CompanyBean> list);
}
