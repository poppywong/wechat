/**
 * 
 */
package com.eightspace.weixin.app.pojo;

import java.io.Serializable;

/**
 * 被动响应消息之回复视频消息
 * 
 * @author wangz
 * @date 2014-5-4
 * @since 1.0
 */
public class RespVideoMsgBean extends RespBaseMsgBean implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = -1892892005140614060L;

    // 通过上传多媒体文件，得到的id
    private String MediaId;

    // 视频消息的标题
    private String Title;

    // 视频消息的描述
    private String Description;



    /**
     * @return the mediaId
     */
    public String getMediaId() {
        return MediaId;
    }



    /**
     * @param mediaId
     *            the mediaId to set
     */
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }



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

}
