/**
 * 
 */
package com.eightspace.weixin.app.pojo;

import java.io.Serializable;

/**
 * 接受普通消息之语音消息
 * 
 * @author wangz
 * @date 2014-5-4
 * @since 1.0
 */
public class ReqVoiceMsgBean extends ReqBaseMsgBean implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = 3066977974297510112L;

    // 语音消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;

    // 语音格式，如amr，speex等
    private String Format;



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
     * @return the format
     */
    public String getFormat() {
        return Format;
    }



    /**
     * @param format
     *            the format to set
     */
    public void setFormat(String format) {
        Format = format;
    }

}
