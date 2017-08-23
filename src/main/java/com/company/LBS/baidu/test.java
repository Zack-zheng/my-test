package com.company.LBS.baidu;

import org.apache.commons.httpclient.NameValuePair;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Jack on 04/05/2016.
 */
public class test {
    /**
     * 创建geotable
     */
    @Test
    public void testGeotableCreate() {
        Date time = new Date();
        NameValuePair[] data = {
                new NameValuePair("name", "testByJack1"),
                new NameValuePair("geotype", "1"),
                new NameValuePair("is_published", "1"),
                new NameValuePair("timestamp", time.toString()),
                new NameValuePair("ak", "kDU6MyRNfqt4TziAHmH4rDdcozrKy6to"),
//                new NameValuePair("sn", ""),
        };
        try {
            Util.doPOST(data, "http://api.map.baidu.com/geodata/v3/geotable/create");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * geotable列
     */
    @Test
    public void testGeotableList() {
        Util.doGET("http://api.map.baidu.com/geodata/v3/geotable/list?name=testByJack&ak=K5rQQ7CF4vqUMQGThGROcVfBIy83huUd&sn=abcdefg");
//        {
//            "status": 0,
//                "geotables": [{
//            "name": "testByJack",
//                    "geotype": 1,
//                    "is_published": 0,
//                    "_version": 1,
//                    "create_time": 1462330458,
//                    "modify_time": 1462330458,
//                    "id": 139760
//        }],
//            "size": 1,
//                "message": "成功"
//        }
    }

    /**
     * geotable明细
     */
    @Test
    public void testGeotableDetail() {
        Util.doGET("http://api.map.baidu.com/geodata/v3/geotable/detail?id=139760&ak=K5rQQ7CF4vqUMQGThGROcVfBIy83huUd&sn=abcdefg");
//        {
//            "status": 0,
//                "geotable": {
//            "name": "testByJack",
//                    "geotype": 1,
//                    "is_published": 1,
//                    "_version": 2,
//                    "create_time": 1462330458,
//                    "modify_time": 1462337612,
//                    "id": 139760
//        },
//            "message": "成功"
//        }
    }

    @Test
    public void testPoiCreate() {
        Date time = new Date();
        NameValuePair[] data = {
                new NameValuePair("title", "大朗营销服务部"),
                new NameValuePair("address", "大朗镇水口村银朗大道398号外东113、115号地铺"),
                new NameValuePair("tags", "营销服务部"),
                new NameValuePair("latitude", "22.943502"),
                new NameValuePair("longitude", "113.960117"),
                new NameValuePair("coord_type", "3"),
                new NameValuePair("geotable_id", "139895"),
                new NameValuePair("ak", "kDU6MyRNfqt4TziAHmH4rDdcozrKy6to"),
                new NameValuePair("officeHours", "周一至周五:08:30-12:00,14:00-17:30，周六：09:00-17:00"),
                new NameValuePair("dMainImg", "DLYXBFWB.jpg"),
                new NameValuePair("midImage", "DLYXBFWB.jpg"),
                new NameValuePair("serviceDesc", "太平洋保险，在你身边！"),
                new NameValuePair("serviceArea", "车险及非车险承保，车险理赔,粤通卡充值"),
                new NameValuePair("poiUid", "1a403c0bd63a4a35f8dc858e"),
                new NameValuePair("routeImage", "dgDaLangS.png"),
                new NameValuePair("uidName", "中国太平洋保险(集团)股份有限公司(大朗营销部)"),
                new NameValuePair("mainimage", "1a403c0bd63a4a35f8dc858e"),
                new NameValuePair("url", "shopDetail.jsp"),
                new NameValuePair("telephone", "0769-83127922"),
                new NameValuePair("gradeName", "营销服务部"),
                new NameValuePair("icon_style_id", "sid1"),
        };
        try {
            Util.doPOST(data, "http://api.map.baidu.com/geodata/v3/poi/create");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPoiDelete() {
        Date time = new Date();
        NameValuePair[] data = {
                new NameValuePair("geotable_id", "139895"),
                new NameValuePair("ak", "kDU6MyRNfqt4TziAHmH4rDdcozrKy6to"),
                new NameValuePair("id", "1695347390"),
        };
        try {
            Util.doPOST(data, "http://api.map.baidu.com/geodata/v3/poi/delete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPoiUpdate() {
        Date time = new Date();
        NameValuePair[] data = {
                new NameValuePair("title", "大朗营销服务部1"),
                new NameValuePair("geotable_id", "139895"),
                new NameValuePair("ak", "kDU6MyRNfqt4TziAHmH4rDdcozrKy6to"),
                new NameValuePair("id", "1695347022"),
        };
        try {
            Util.doPOST(data, "http://api.map.baidu.com/geodata/v3/poi/update");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetPoiUid() {
        try {
            Util.doGET("http://api.map.baidu.com/place/v2/search?query=%E5%A4%AA%E5%B9%B3%E6%B4%8B&location=22.783667,113.781654&radius=200&output=json&ak=kDU6MyRNfqt4TziAHmH4rDdcozrKy6to");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

