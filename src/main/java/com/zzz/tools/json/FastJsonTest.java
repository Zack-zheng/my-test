package com.zzz.tools.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * Created by Jack on 19/05/2016.
 */
public class FastJsonTest {
    @Test
    public void testAnalyzeJsonString() throws Exception {

        JSONObject jsonResult = JSONObject.parseObject(message1);
        JSONArray results = jsonResult.getJSONArray("results");

        if (results.size() == 1) {
            JSONObject poiDetail = JSONObject.parseObject(results.getString(0));
            System.out.println(poiDetail.get("address"));
            System.out.println(poiDetail.get("uid"));
            System.out.println(poiDetail.get("name"));
            System.out.println(poiDetail.get("telephone"));
        } else {
            throw new Exception("返回数据异常");
        }
    }

    @Test
    public void testCreateJsonString() {
        String a = "#Latitude和#Longitude";
        String b= a.replace("#Latitude","22.783667").replace("#Longitude","113.781654");
        System.out.println(b);
    }


    String message1 = "{\n" +
            "    \"status\":0,\n" +
            "    \"message\":\"ok\",\n" +
            "    \"results\":[\n" +
            "        {\n" +
            "            \"name\":\"中国太平洋财产保险股份有限公司(长安支公司)\",\n" +
            "            \"location\":{\n" +
            "                \"lat\":22.783913,\n" +
            "                \"lng\":113.780628\n" +
            "            },\n" +
            "            \"address\":\"长安镇振安中路富安大厦1-2层01号\",\n" +
            "            \"telephone\":\"(0769)85072231\",\n" +
            "            \"detail\":1,\n" +
            "            \"uid\":\"63d46a4ecde0ded1f4eafc5c\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

}
