/**
 * 
 */
package com.eightspace.weixin.app.pojo;

import java.io.Serializable;

/**
 * 图文消息类
 * 
 * @author wangz
 * @date 2014-5-4
 * @since 1.0
 */
public class RespArticleMsgBean implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = -562398240595092065L;

    // 图文消息标题
    private String Title;

    // 图文消息描述
    private String Description;

    // 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
    private String PicUrl;

    // 点击图文消息跳转链接
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
     * @return the picUrl
     */
    public String getPicUrl() {
        return PicUrl;
    }



    /**
     * @param picUrl
     *            the picUrl to set
     */
    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
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
