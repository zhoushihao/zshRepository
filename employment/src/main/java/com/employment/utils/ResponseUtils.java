package com.employment.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by apple on 2017-2-17.
 */
public class ResponseUtils {

    public ResponseUtils() {
    }

    public static void render(HttpServletResponse response, String contentType, String text) {
        response.setContentType(contentType);

        try {
            response.getWriter().write(text);
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public static void renderJson(HttpServletResponse response, String text) {
        render(response, "application/json;charset=UTF-8", text);
    }

    public static void renderJson(HttpServletResponse response, Object result) {
        render(response, "application/json;charset=UTF-8", JSON.toJSONString(result));
    }

    public static void renderXml(HttpServletResponse response, String text) {
        render(response, "text/xml;charset=UTF-8", text);
    }

    public static void renderText(HttpServletResponse response, String text) {
        render(response, "text/plain;charset=UTF-8", text);
    }

}
