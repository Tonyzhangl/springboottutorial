package com.kirago.chapter19.database;

import java.util.HashMap;
import java.util.Map;

/**
* @Description:    java类作用描述
* @Author:         kirago
* @CreateDate:     2019/3/29 2:56 PM
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class DataSource {
    private static Map<String, Map<String, String>> data = new HashMap<>();

    static {
        Map<String, String> data1 = new HashMap<>();
        data1.put("password", "user");
        data1.put("role", "user");
        data1.put("permission", "view");

        Map<String, String> data2 = new HashMap<>();
        data2.put("password", "admin");
        data2.put("role", "admin");
        data2.put("permission", "edie,view");

        data.put("user", data1);
        data.put("admin", data2);
    }

    public static Map<String, Map<String, String>> getData(){
        return data;
    }
}
