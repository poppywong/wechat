/**
 * 
 */
package com.eightspace.weixin.app.pojo;

import java.io.Serializable;

/**
 * 接受普通消息之链接消息
 * 
 * @author wangz
 * @date 2014-5-4
 * @since 1.0
 */
public class ReqLinkMsgBean extends ReqBaseMsgBean implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = 8406471666291898687L;

    // 消息标题
    private String Title;

    // 消息描述
    private String Description;

    // 消息链接
    private String Url;



    /**
     * @return the title
     */
    public String getTitle() {
        return Title;
    }



    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        Title = title;
    }



    /**
     * @return the description
     */
    public String getDescription() {
        return Description;
    }



    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        Description = description;
    }



    /**
     * @return the url
     */
    public String getUrl() {
        return Url;
    }



    /**
     * @param url
     *            the url to set
     */
    public void setUrl(String url) {
        Url = url;
    }

}
