package com.employment.service.common;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.employment.bean.common.BaseModel;

import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
public interface IBaseService <T extends BaseModel> {

    boolean insert(T var1);

    boolean insertBatch(List<T> var1);

    boolean updateSelective(T var1, T var2);

    T selectOne(T var1);

    int selectCount(T var1);

    List<T> selectList(EntityWrapper<T> var1);

    Page<T> selectPage(Page<T> var1, EntityWrapper<T> var2);
}
