package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Values {
    static Map<Integer, String> hashmap = new HashMap<Integer, String>();

    public static String getValue(int id) {
        return hashmap.get(id);
    }

    public Values(JSONObject jo) {
        JSONArray ja = jo.getJSONArray("values");
        for (int i = 0; i < ja.length(); i++) {

            this.hashmap.put(ja.getJSONObject(i).getInt("id"), ja.getJSONObject(i).getString("value"));

        }
    }

}
