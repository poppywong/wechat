/**
 * 
 */
package com.eightspace.weixin.app.pojo;

import java.io.Serializable;

/**
 * 接受普通消息之文本消息
 * 
 * @author wangz
 * @date 2014-5-4
 * @since 1.0
 */
public class ReqTextMsgBean extends ReqBaseMsgBean implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = -4093900509975967482L;

    // 消息内容
    private String Content;



    /**
     * @return the content
     */
    public String getContent() {
        return Content;
    }



    /**
     * @param content
     *            the content to set
     */
    public void setContent(String content) {
        Content = content;
    }

}
