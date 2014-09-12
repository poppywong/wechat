/**
 * 
 */
package com.eightspace.weixin.app.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信公众平台接口层
 * 
 * @author wangz
 * @date 2014-5-5
 * @since 1.0
 */
public interface WeixinService {

    /**
     * 消息处理(被动推送消息)
     * 
     * @author Poppy
     * @date 2014-3-19
     * @param request
     * @return
     * @throws Exception
     * @since 1.0
     */
    public String dealMsg(HttpServletRequest request) throws Exception;
}
