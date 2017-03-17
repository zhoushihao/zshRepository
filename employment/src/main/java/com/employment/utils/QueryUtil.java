package com.employment.utils;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.employment.bean.common.QueryParam;
import com.employment.bean.common.WhereParam;

import java.lang.reflect.Type;
import java.util.Iterator;

/**
 * Created by apple on 2017-2-9.
 */
public class QueryUtil {

    public QueryUtil() {
    }

    public  String getQueryParamWhere(EntityWrapper ew, QueryParam queryParam) {
        StringBuffer sb = new StringBuffer();
        if(queryParam != null && queryParam.getWheres() != null) {
            Iterator var3 = queryParam.getWheres().iterator();

            while(var3.hasNext()) {
                WhereParam where = (WhereParam)var3.next();
                if(where.getValue() != null && where.getValue().length() != 0) {
                    if(sb.toString().length() > 0) {
                        sb.append(" and ");
                    }

                    if("like".equals(where.getOperate())) {
                        sb.append(where.getField()).append(" like \'%").append(where.getValue()).append("%\' ");
                    } else if("equal".equals(where.getOperate())) {
                        appendSqlConditionBit(sb, " = ", ew.getEntity(), where.getField(), where.getValue());
                    } else if("gt".equals(where.getOperate())) {
                        appendSqlConditionBit(sb, " > ", ew.getEntity(), where.getField(), where.getValue());
                    } else if("lt".equals(where.getOperate())) {
                        appendSqlConditionBit(sb, " < ", ew.getEntity(), where.getField(), where.getValue());
                    } else if("gtq".equals(where.getOperate())) {
                        appendSqlConditionBit(sb, " >= ", ew.getEntity(), where.getField(), where.getValue());
                    } else if("ltq".equals(where.getOperate())) {
                        appendSqlConditionBit(sb, " <= ", ew.getEntity(), where.getField(), where.getValue());
                    } else if("in".equals(where.getOperate())) {
                        sb.append(where.getField()).append(" in (").append(where.getValue()).append(") ");
                    }
                }
            }
        }

        return sb.toString();
    }

    public static  EntityWrapper initEntityWrapper(EntityWrapper ew, QueryParam queryParam) {
        if(queryParam != null && queryParam.getWheres() != null) {
            StringBuffer sb = new StringBuffer();
            Iterator order = queryParam.getWheres().iterator();

            while(order.hasNext()) {
                WhereParam where = (WhereParam)order.next();
                if(where.getValue() != null && where.getValue().length() != 0) {
                    if(sb.toString().length() > 0) {
                        sb.append(" and ");
                    }

                    if("like".equals(where.getOperate())) {
                        sb.append(where.getField()).append(" like \'%").append(where.getValue()).append("%\' ");
                    } else if("equal".equals(where.getOperate())) {
                        appendSqlConditionBit(sb, " = ", ew.getEntity(), where.getField(), where.getValue());
                    } else if("gt".equals(where.getOperate())) {
                        appendSqlConditionBit(sb, " > ", ew.getEntity(), where.getField(), where.getValue());
                    } else if("lt".equals(where.getOperate())) {
                        appendSqlConditionBit(sb, " < ", ew.getEntity(), where.getField(), where.getValue());
                    } else if("gtq".equals(where.getOperate())) {
                        appendSqlConditionBit(sb, " >= ", ew.getEntity(), where.getField(), where.getValue());
                    } else if("ltq".equals(where.getOperate())) {
                        appendSqlConditionBit(sb, " <= ", ew.getEntity(), where.getField(), where.getValue());
                    } else if("in".equals(where.getOperate())) {
                        sb.append(where.getField()).append(" in (").append(where.getValue()).append(") ");
                    }
                }
            }

            ew.where(sb.toString(), new Object[0]);
        }
        return ew;
    }

    public static void appendSqlConditionBit(StringBuffer sb, String operate, Object obj, String field, String fieldValue) {
        String sqlType = getEntityWapperType(BeanUtil.getFieldType(obj.getClass(), field));
        String fieldValPrepare = fieldValue;
        if(!sqlType.equals("Number")) {
            fieldValPrepare = "\'" + fieldValue + "\' ";
        }
        sb.append(field).append(operate).append(fieldValPrepare);
    }

    public static String getEntityWapperType(Type type) {
        String sqlType = "String";
        if(type.toString().equals("class java.lang.Integer") || type.toString().equals("class java.lang.Double") || type.toString().equals("class java.lang.Long")) {
            sqlType = "Number";
        }
        return sqlType;
    }
}
