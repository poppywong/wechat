/**
 * 
 */
package com.eightspace.weixin.app.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eightspace.server.common.log.LogManagment;
import com.eightspace.weixin.app.pojo.CheckBean;
import com.eightspace.weixin.app.service.WeixinService;
import com.eightspace.weixin.util.EncryptUtil;

/**
 * 微信公众平台Controller层
 * 
 * @author wangz
 * @date 2014-5-5
 * @since 1.0
 */
@Controller("weixinController")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class WeixinController {

    /**
     * 日志对象
     */
    private static LogManagment log = LogManagment.getLogger(WeixinController.class);

    /**
     * service
     */
    @Resource(name = "weixinServiceImpl")
    private WeixinService weixinService;



    /**
     * 微信校验接口
     * 
     * @author Frank
     * @throws IOException
     * @date 2014-3-8
     * @since 1.0
     */
    @RequestMapping("/weixin")
    @ResponseBody
    public void check(CheckBean checkBean, HttpServletResponse response) throws IOException {
        String result = "";
        // 自定义token
        String token = "poppy";
        String[] str = new String[] { checkBean.getNonce(), checkBean.getTimestamp(), token };
        // 将token、timestamp、nonce三个参数进行字典序排序。
        Arrays.sort(str);
        // 排序后的字符串
        String tmpStr = "";
        for (String s : str) {
            tmpStr += s;
        }
        // sha1加密(sha1跟MD5一样，都是不可逆的加密算法)
        tmpStr = EncryptUtil.encode("sha1", tmpStr);
        // 将加密算法获得的字符串跟签名作比较，如果相同，正确，校验成功
        if (tmpStr != null && tmpStr.equals(checkBean.getSignature())) {
            // 将生成的随机字符串返回
            result = checkBean.getEchostr();
        }
        response.getWriter().write(result);
    }



    /**
     * 消息处理
     * 
     * @author wangz
     * @date 2014-5-5
     * @param request
     * @param response
     *            void
     */
    @RequestMapping("/weixin5")
    @ResponseBody
    public void dealMsg(HttpServletRequest request, HttpServletResponse response) {
        String result = "";
        try {
            // 编码
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            // 调用消息处理接口
            result = weixinService.dealMsg(request);
            log.error(result);
            response.getWriter().write(result);
        } catch (Exception e) {
            // 异常log
            log.error("WeixinController-dealMsg:消息处理方法异常", e);
        }
    }
}
