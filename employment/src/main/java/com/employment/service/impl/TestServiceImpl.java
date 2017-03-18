//package com.employment.service.impl;
//
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.baomidou.mybatisplus.plugins.Page;
//import com.employment.bean.TestBean;
//import com.employment.bean.common.QueryParam;
//import com.employment.dao.TestDao;
//import com.employment.service.Interface.ITestService;
//import com.employment.service.support.BaseServiceImpl;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
///**
// * Created by apple on 2017-2-9.
// */
//@Service
//public class TestServiceImpl extends BaseServiceImpl<TestDao,TestBean> implements ITestService{
//
//
//    public List<TestBean> queryOrders(QueryParam queryParam) {
//
//        return baseMapper.selectPage(new Page<TestBean>(),new EntityWrapper<TestBean>());
//    }
//}
