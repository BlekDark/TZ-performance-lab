package com.company;

import org.json.JSONArray;
import org.json.JSONObject;

public class Test {
    int id;
    String title;
    String value;
    Test[] values;


    public Test(JSONObject jo) {
        this.id = jo.getInt("id");
        this.title = jo.getString("title");
        if (jo.has("value")) {
            this.value = Values.getValue(id);
        } else {
            this.value = "";
        }
        if (jo.has("values") == true) {
            this.values = new Test[jo.getJSONArray("values").length()];
            for (int i = 0; i < values.length; i++) {
                values[i] = new Test(jo.getJSONArray("values").getJSONObject(i));
            }
        } else {
            this.values = new Test[0];
        }
    }

    public JSONObject getJo() {
        JSONObject newJo = new JSONObject();
        newJo.put("id", id);
        newJo.put("title", title);
        if (value.length() != 0) {
            newJo.put("value", value);
        }
        if (values.length != 0) {
            JSONArray valuesArray = new JSONArray();
            for (Test t : values) {
                valuesArray.put(t.getJo());
            }
            newJo.put("values", valuesArray);

        }
        return newJo;
    }


}
