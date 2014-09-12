/*****************************************************************************
 * 金徽订单系统
 *****************************************************************************
 * CreatMenu.java
 *----------------------------------------------------------------------------
 * (C) 沈阳八维时空科技发展
 *     SHENYANG EIGHTSPACE TECHNOLOGY DEVELOPMENT CO.,LTD.  2014
 *----------------------------------------------------------------------------
 * Version    Date       By            Comment
 * 1.0        2014-8-28    Poppy       新建
 *****************************************************************************/
package com.eightspace.weixin.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.eightspace.server.common.log.LogManagment;

/**
 * 创建菜单
 * 
 * @author Poppy
 * @date 2014-8-28
 * @since 1.0
 */
public class CreatMenu {

    // https请求方式
    private static final String METHOD = "POST";// "GET";

    // 编码
    private static final String DEFAULT_CHARSET = "utf-8";

    /**
     * log
     */
    private static LogManagment log = LogManagment.getLogger(HttpsUtil.class);



    /**
     * 创建菜单方法
     * 
     * @author Poppy
     * @date 2014-8-28
     * @param args
     * @since 1.0
     */
    public static void main(String[] args) {
        try {
            // 创建菜单
            String accessToken = "cWRskEj5RRDeJQxNgOA5pCVMV6EaZZCTPkpy1D-opBkeBfIpgL4nweG2co8rnWOswHn1tzmks0N9sEZYLsPJjA";
            // https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
            String createUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken;
            Map<String, Object> buttonMap = new HashMap<String, Object>();
            List<Map<String, Object>> buttons = new ArrayList<Map<String, Object>>();
            List<Map<String, Object>> subButtons1 = new ArrayList<Map<String, Object>>();
            Map<String, Object> map11 = new HashMap<String, Object>();
            map11.put("type", "click");
            map11.put("name", "其他星座");
            map11.put("key", "qitazuo");
            subButtons1.add(map11);
            Map<String, Object> map12 = new HashMap<String, Object>();
            map12.put("type", "click");
            map12.put("name", "处女座");
            map12.put("key", "chunvzuo");
            subButtons1.add(map12);
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("name", "星座");
            map1.put("sub_button", subButtons1);
            buttons.add(map1);

            List<Map<String, Object>> subButtons2 = new ArrayList<Map<String, Object>>();
            Map<String, Object> map21 = new HashMap<String, Object>();
            map21.put("type", "click");
            map21.put("name", "金木水火土");
            map21.put("key", "wuxing");
            subButtons2.add(map21);
            Map<String, Object> map22 = new HashMap<String, Object>();
            map22.put("type", "view");
            map22.put("name", "太极八卦");
            map22
                .put("url",
                    "http://mp.weixin.qq.com/s?__biz=MzA3MDQxMzgzNw==&mid=200627754&idx=1&sn=3c87ea9d09fa49393774710ddae3a670#rd");
            subButtons2.add(map22);
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("name", "五行八卦");
            map2.put("sub_button", subButtons2);
            buttons.add(map2);

            Map<String, Object> map3 = new HashMap<String, Object>();
            map3.put("type", "view");
            map3.put("name", "友情链接");
            map3.put("url",
                "http://mp.weixin.qq.com/s?__biz=MzA3MDQxMzgzNw==&mid=200117435&idx=1&sn=81a7bc82905d029a073dac01f159ee71#rd");
            buttons.add(map3);
            buttonMap.put("button", buttons);
            System.out.println(JSON.toJSONString(buttonMap));
            String result = HttpsUtil.doPost(createUrl, METHOD, JSON.toJSONString(buttonMap), DEFAULT_CHARSET, 1200,
                1200);
            log.error(result);
        } catch (Exception e) {
            log.error("HttpsUtil-main:创建菜单方法异常", e);
        }
    }
}
