/**
 * 
 */
package com.eightspace.weixin.app.pojo;

import java.io.Serializable;

/**
 * 被动响应消息之回复音乐消息
 * 
 * @author wangz
 * @date 2014-5-4
 * @since 1.0
 */
public class RespMusicMsgBean extends RespBaseMsgBean implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = -1523107399702505673L;

    // 音乐标题
    private String Title;

    // 音乐描述
    private String Description;

    // 音乐链接
    private String MusicURL;

    // 高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String HQMusicUrl;

    // 缩略图的媒体id，通过上传多媒体文件，得到的id
    private String ThumbMediaId;



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
     * @return the musicURL
     */
    public String getMusicURL() {
        return MusicURL;
    }



    /**
     * @param musicURL
     *            the musicURL to set
     */
    public void setMusicURL(String musicURL) {
        MusicURL = musicURL;
    }



    /**
     * @return the hQMusicUrl
     */
    public String getHQMusicUrl() {
        return HQMusicUrl;
    }



    /**
     * @param hQMusicUrl
     *            the hQMusicUrl to set
     */
    public void setHQMusicUrl(String hQMusicUrl) {
        HQMusicUrl = hQMusicUrl;
    }



    /**
     * @return the thumbMediaId
     */
    public String getThumbMediaId() {
        return ThumbMediaId;
    }



    /**
     * @param thumbMediaId
     *            the thumbMediaId to set
     */
    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

}
