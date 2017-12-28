package com.oyg.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by qufan on 2017/6/21 0021.
 */
public class JsonUtils {




    /**
     * 将json对象串转换成map对象
     * @param jsonObjStr
     * @return
     */
    public static Map getMapFromJsonObjectStr(String jsonObjStr){
        JSONObject jsonObject = JSONObject.parseObject(jsonObjStr);
        Map map = new HashMap();
        for (Iterator iter = jsonObject.keySet().iterator(); iter.hasNext();){
            String key = (String)iter.next();
            map.put(key, jsonObject.get(key));
        }
        return map;
    }
    public static String obj2Json(Object obj) {
        Gson gson = createGsonBuilder().create();
        return gson.toJson(obj);
    }

    public static GsonBuilder createGsonBuilder() {
        return new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static String getJsonFromObject(HashMap<String, Object> map){
        return JSONObject.toJSONString(map);
    }

    /**
     * json字符串转换成对象
     * @param str  json字符串
     * @param type 对象类型
     * @param <T>
     * @return
     */
    public static <T> T json2Obj(String str,Type type){
        Gson gson = createGsonBuilder().create();
        return gson.fromJson(str,type);
    }

}
