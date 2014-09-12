/**
 * 
 */
package com.eightspace.weixin.app.pojo;

import java.io.Serializable;

/**
 * 接受普通消息之视频消息
 * 
 * @author wangz
 * @date 2014-5-4
 * @since 1.0
 */
public class ReqVideoMsgBean extends ReqBaseMsgBean implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = -4431654920875995172L;

    // 视频消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;

    // 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
    private String ThumbMediaId;



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
