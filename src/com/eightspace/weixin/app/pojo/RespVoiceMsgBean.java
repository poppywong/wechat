/**
 * 
 */
package com.eightspace.weixin.app.pojo;

import java.io.Serializable;

/**
 * 被动响应消息之回复语音消息
 * 
 * @author wangz
 * @date 2014-5-4
 * @since 1.0
 */
public class RespVoiceMsgBean extends RespBaseMsgBean implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = -4507759721690885197L;

    // 通过上传多媒体文件，得到的id
    private String MediaId;



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
