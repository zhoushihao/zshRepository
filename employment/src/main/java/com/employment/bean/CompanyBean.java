package com.employment.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.employment.bean.common.BaseModel;

import java.io.Serializable;

/**
 * Created by apple on 2017-2-17.
 */
@TableName("t_company")
public class CompanyBean extends BaseModel implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String company_id;
    private String company_name;
    private String comapny_address;
    private String manager;//公司负责人

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getComapny_address() {
        return comapny_address;
    }

    public void setComapny_address(String comapny_address) {
        this.comapny_address = comapny_address;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
