/**
 * 
 */
package com.eightspace.weixin.app.pojo;

import java.io.Serializable;

/**
 * 被动响应消息之回复文本消息
 * 
 * @author wangz
 * @date 2014-5-4
 * @since 1.0
 */
public class RespTextMsgBean extends RespBaseMsgBean implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = 3913818572877509394L;

    // 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
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
