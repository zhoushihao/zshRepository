package com.employment.utils;

import java.util.UUID;

/**
 * Created by apple on 2017-3-14.
 */
public class UUIDGeneratorUtil {
    public UUIDGeneratorUtil() {
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
