/**
 * 
 */
package com.eightspace.weixin.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.eightspace.weixin.app.pojo.RespArticleMsgBean;
import com.eightspace.weixin.app.pojo.RespNewMsgBean;
import com.eightspace.weixin.app.pojo.RespTextMsgBean;
import com.eightspace.weixin.app.service.WeixinService;
import com.eightspace.weixin.util.CommonUtil;

/**
 * 微信公众平台接口实现层
 * 
 * @author wangz
 * @date 2014-5-5
 * @since 1.0
 */
@Service("weixinServiceImpl")
public class WeixinServiceImpl implements WeixinService {

    /**
     * 消息处理方法实现类
     * 
     * @author wangz
     * @throws Exception
     * @date 2014-5-5
     * @see com.eightspace.weixin.app.service.WeixinService#dealMsg(javax.servlet.http.HttpServletRequest)
     */
    @Override
    public String dealMsg(HttpServletRequest request) throws Exception {
        // 定义返回值
        String respStr = "";
        // xml请求解析
        Map<String, String> requestMap = CommonUtil.analysisXml(request);
        // 消息类型
        String msgType = requestMap.get("MsgType");
        // 被动返回消息Bean
        RespTextMsgBean respTextMsgBean = new RespTextMsgBean();
        // 设置发送者账号
        respTextMsgBean.setToUserName(requestMap.get("FromUserName"));
        // 设置接收者账号
        respTextMsgBean.setFromUserName(requestMap.get("ToUserName"));
        // 设置创建时间
        respTextMsgBean.setCreateTime(System.currentTimeMillis());
        // 设置消息类型
        respTextMsgBean.setMsgType("text");
        // 根据消息类型回复不同的消息内容
        if ("text".equals(msgType)) {
            // 获取用户发送文字消息内容
            String requestContent = requestMap.get("Content");
            // 设置回复消息内容
            if (requestContent.contains("丁哥")) {
                respTextMsgBean.setContent("丁哥叫我来巡山！！！");
            } else {
                respTextMsgBean.setContent("你发送了一条文本消息");
            }
        } else if ("image".equals(msgType)) {
            // 设置回复消息内容
            respTextMsgBean.setContent("这是你的靓照咩？");
        } else if ("voice".equals(msgType)) {
            // 设置回复消息内容
            respTextMsgBean.setContent("说啥呢？");
        } else if ("video".equals(msgType)) {
            // 设置回复消息内容
            respTextMsgBean.setContent("你发送了一个视频消息");
        } else if ("event".equals(msgType)) {
            // 获取事件类型
            String event = requestMap.get("Event");
            if ("subscribe".equals(event)) {
                // 设置回复消息内容
                respTextMsgBean.setContent("欢迎关注烟宝宝~");
            } else if ("CLICK".equals(event)) {
                // 获取菜单点击之间中的key
                String eventKey = requestMap.get("EventKey");
                // 爱上金徽，金徽介绍菜单
                if ("qitazuo".equals(eventKey)) {
                    List<RespArticleMsgBean> articles = new ArrayList<RespArticleMsgBean>();
                    RespArticleMsgBean article1 = new RespArticleMsgBean();
                    article1.setTitle("萌萌哒~");
                    article1
                        .setDescription("吃葡萄吐葡萄皮不吃葡萄不吐葡萄皮~吃葡萄吐葡萄皮不吃葡萄不吐葡萄皮~吃葡萄吐葡萄皮不吃葡萄不吐葡萄皮~吃葡萄吐葡萄皮不吃葡萄不吐葡萄皮~吃葡萄吐葡萄皮不吃葡萄不吐葡萄皮~吃葡萄吐葡萄皮不吃葡萄不吐葡萄皮~吃葡萄吐葡萄皮不吃葡萄不吐葡萄皮~");
                    article1.setPicUrl("http://www.poppywong.com/weixin/image/boy.jpg");
                    article1
                        .setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQxMzgzNw==&mid=200627730&idx=1&sn=d046019611809bb111f13e40012e34e0#rd");
                    articles.add(article1);
                    RespNewMsgBean news = new RespNewMsgBean();
                    news.setArticleCount(articles.size());
                    news.setArticles(articles);
                    news.setCreateTime(new Date().getTime());
                    news.setMsgType("news");
                    news.setFromUserName(requestMap.get("ToUserName"));
                    news.setToUserName(requestMap.get("FromUserName"));
                    // 将图文news转成xml
                    respStr = CommonUtil.newsMessageToXml(news);
                    // 用json串返回结果
                    return respStr;
                }
                // 爱上金徽，产品介绍菜单
                if ("chunvzuo".equals(eventKey)) {
                    List<RespArticleMsgBean> articles = new ArrayList<RespArticleMsgBean>();
                    RespArticleMsgBean article1 = new RespArticleMsgBean();
                    RespArticleMsgBean article2 = new RespArticleMsgBean();
                    article2.setTitle("第二受欢迎的星座");
                    article2.setDescription("处女座受欢迎指数排在第二,排在第一的是其他星座。不服来辩，yeah~");
                    article2.setPicUrl("http://www.poppywong.com/weixin/image/virgo.jpg");
                    article2
                        .setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQxMzgzNw==&mid=200627732&idx=1&sn=dba348bb1166560a0f1d57d05cf1584f#rd");
                    articles.add(article2);
                    article1.setTitle("完美主义");
                    article1.setDescription("我是处女座~");
                    article1.setPicUrl("http://www.poppywong.com/weixin/image/chunv.png");
                    article1
                        .setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQxMzgzNw==&mid=200627737&idx=1&sn=e1f30e2d59419f113042933d53b40835#rd");
                    articles.add(article1);
                    RespArticleMsgBean article3 = new RespArticleMsgBean();
                    article3.setTitle("处女座头像");
                    article3.setDescription("处女座头像，yeah~");
                    article3.setPicUrl("http://www.poppywong.com/weixin/image/touxiang.png");
                    article3
                        .setUrl("http://mp.weixin.qq.com/s?__biz=MzA3MDQxMzgzNw==&mid=200627739&idx=1&sn=268ed73b9cc23aa248c1f4df7f34c4f4#rd");
                    articles.add(article3);
                    RespNewMsgBean news = new RespNewMsgBean();
                    news.setArticleCount(articles.size());
                    news.setArticles(articles);
                    news.setCreateTime(new Date().getTime());
                    news.setMsgType("news");
                    news.setFromUserName(requestMap.get("ToUserName"));
                    news.setToUserName(requestMap.get("FromUserName"));
                    // 将图文news转成xml
                    respStr = CommonUtil.newsMessageToXml(news);
                    // 用json串返回结果
                    return respStr;
                }
                if ("wuxing".equals(eventKey)) {
                    // 设置回复消息内容
                    respTextMsgBean.setContent("╮(╯▽╰)╭");
                }
            }
        }
        // 将bean转成xml
        respStr = CommonUtil.textMessageToXml(respTextMsgBean);
        // 用json串返回结果
        return respStr;
    }

}
