package com.employment.utils;

import com.employment.bean.common.BaseModel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Created by apple on 2017-2-9.
 */
public class BeanUtil {
    public BeanUtil() {
    }

    public static Type getFieldType(Class<?> clz, String fieldName) {
        Type type = null;
        Field[] fields = clz.getDeclaredFields();
        Field[] clzSuper = fields;
        int var5 = fields.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Field field = clzSuper[var6];
            if(field.getName().equals(fieldName)) {
                type = field.getGenericType();
                break;
            }
        }

        if(type == null) {
            Class var8 = clz.getSuperclass();
            if(var8 != null) {
                type = getFieldType(var8, fieldName);
            }
        }

        return type;
    }

    public static Object newBean(Object from,Object to) {
        BaseModel fromBase = (BaseModel)from;
        BaseModel toBase = (BaseModel)to;
        toBase.setIs_del("N");
        toBase.setUser_id(fromBase.getUser_id());
        return toBase;
    }


    public static Object copyProperties(Object from, Object to, String[] includsArray) {
        String[] var3 = includsArray;
        int var4 = includsArray.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String field = var3[var5];
            Object value = getFieldValue(from, field);
            Method toMethod = getFieldMethod(to, field, true);

            try {
                toMethod.invoke(to, new Object[]{value});
            } catch (Exception var10) {
                System.out.print(var10);
            }
        }

        return to;
    }

    public static Object getFieldValue(Object from, String field) {
        Object value = null;

        try {
            Method e = getFieldMethod(from, field, false);
            if(null != e) {
                value = e.invoke(from, new Object[0]);
            }
        } catch (Exception var4) {
            System.out.print(var4);
        }

        return value;
    }

    public static Method getFieldMethod(Object from, String field, boolean is_set) {
        Method[] methods = from.getClass().getDeclaredMethods();
        Method methodField = null;
        Method[] e = methods;
        int var6 = methods.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Method method = e[var7];
            String methodName = method.getName();
            if(methodName.toLowerCase().equals((is_set?"set":"get") + field.toLowerCase())) {
                methodField = method;
                break;
            }
        }

        try {
            if(null == methodField) {
                Class var11 = from.getClass().getSuperclass();
                if(var11 != null) {
                    methodField = getFieldMethod(var11.newInstance(), field, is_set);
                }
            }
        } catch (Exception var10) {
            System.out.print(var10);
        }

        return methodField;
    }

    public static Method findMethodByName(Method[] methods, String name) {
        for(int j = 0; j < methods.length; ++j) {
            if(methods[j].getName().equals(name)) {
                return methods[j];
            }
        }
        return null;
    }
}
