/**
 * 
 */
package com.eightspace.weixin.app.pojo;

import java.io.Serializable;

/**
 * 接受普通消息之图片消息
 * 
 * @author wangz
 * @date 2014-5-4
 * @since 1.0
 */
public class ReqImageMsgBean extends ReqBaseMsgBean implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = 6980840914390385818L;

    // 图片链接
    private String PicUrl;

    // 图片消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;



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

}
