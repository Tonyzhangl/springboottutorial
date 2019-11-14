package com.chinamobile.epic.tinker.common.util;

import java.util.Map;

/**
 * @Author: zhangLe
 * @Date: 2019/11/4
 * @Descrption:
 */
public class ResponseMapUtil {

    public static void makeResultMap(Map<String, Object> map, String result, String message, String tag, Object data) {

        map.put("result", result);

        if(!isNullOrEmpty(message)) {
            map.put("message", message);
        }

        if( !isNullOrEmpty(tag)) {
            map.put(tag, data);
        }
    }

    private static boolean isNullOrEmpty(String str) {
        return (null == str || "".equals(str));
    }

}
