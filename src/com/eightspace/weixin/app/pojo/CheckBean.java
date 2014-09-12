/**
 * 
 */
package com.eightspace.weixin.app.pojo;

import java.io.Serializable;

/**
 * 校验实体类
 * 
 * @author Frank
 * @date 2014-3-8
 * @since 1.0
 */
public class CheckBean implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = 2138164751298028604L;

    /**
     * 随机数
     */
    private String nonce;

    /**
     * 时间戳
     */
    private String timestamp;

    /**
     * 随机字符串
     */
    private String echostr;

    /**
     * 微信加密签名
     */
    private String signature;



    /**
     * @return the nonce
     */
    public String getNonce() {
        return nonce;
    }



    /**
     * @param nonce
     *            the nonce to set
     */
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }



    /**
     * @return the timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }



    /**
     * @param timestamp
     *            the timestamp to set
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }



    /**
     * @return the echostr
     */
    public String getEchostr() {
        return echostr;
    }



    /**
     * @param echostr
     *            the echostr to set
     */
    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }



    /**
     * @return the signature
     */
    public String getSignature() {
        return signature;
    }



    /**
     * @param signature
     *            the signature to set
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

}
