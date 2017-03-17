package com.employment.bean.common;

import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
public class QueryParam extends BaseModel implements Serializable {

    @TableField(
            exist = false
    )
    private static final long serialVersionUID = 1L;
    private List<WhereParam> wheres = new ArrayList();

    public QueryParam() {
    }

    public List<WhereParam> getWheres() {
        return this.wheres;
    }

    public void setWheres(List<WhereParam> wheres) {
        this.wheres = wheres;
    }

    public static long getSerialVersionUID() {
        return 1L;
    }

}
