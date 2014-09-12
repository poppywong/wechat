/**
 * 
 */
package com.eightspace.weixin.app.pojo;

import java.io.Serializable;

/**
 * 被动响应消息基类
 * 
 * @author wangz
 * @date 2014-5-4
 * @since 1.0
 */
public class RespBaseMsgBean implements Serializable {

    /** 序列化版本好 */
    private static final long serialVersionUID = 8441270353679036220L;

    // 接收方帐号（收到的OpenID）
    private String ToUserName;

    // 开发者微信号
    private String FromUserName;

    // 消息创建时间 （整型）
    private long CreateTime;

    // 消息类型
    private String MsgType;



    /**
     * @return the toUserName
     */
    public String getToUserName() {
        return ToUserName;
    }



    /**
     * @param toUserName
     *            the toUserName to set
     */
    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }



    /**
     * @return the fromUserName
     */
    public String getFromUserName() {
        return FromUserName;
    }



    /**
     * @param fromUserName
     *            the fromUserName to set
     */
    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }



    /**
     * @return the createTime
     */
    public long getCreateTime() {
        return CreateTime;
    }



    /**
     * @param createTime
     *            the createTime to set
     */
    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }



    /**
     * @return the msgType
     */
    public String getMsgType() {
        return MsgType;
    }



    /**
     * @param msgType
     *            the msgType to set
     */
    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

}
