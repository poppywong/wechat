/**
 * 
 */
package com.eightspace.weixin.app.pojo;

import java.io.Serializable;

/**
 * 接受普通消息之地理位置消息
 * 
 * @author wangz
 * @date 2014-5-4
 * @since 1.0
 */
public class ReqLocationMsgBean extends ReqBaseMsgBean implements Serializable {

    /** 序列化版本号 */
    private static final long serialVersionUID = 6989890280449645350L;

    // 地理位置维度
    private double Location_X;

    // 地理位置经度
    private double Location_Y;

    // 地图缩放大小
    private int Scale;

    // 地理位置信息
    private String Label;



    /**
     * @return the location_X
     */
    public double getLocation_X() {
        return Location_X;
    }



    /**
     * @param location_X
     *            the location_X to set
     */
    public void setLocation_X(double location_X) {
        Location_X = location_X;
    }



    /**
     * @return the location_Y
     */
    public double getLocation_Y() {
        return Location_Y;
    }



    /**
     * @param location_Y
     *            the location_Y to set
     */
    public void setLocation_Y(double location_Y) {
        Location_Y = location_Y;
    }



    /**
     * @return the scale
     */
    public int getScale() {
        return Scale;
    }



    /**
     * @param scale
     *            the scale to set
     */
    public void setScale(int scale) {
        Scale = scale;
    }



    /**
     * @return the label
     */
    public String getLabel() {
        return Label;
    }



    /**
     * @param label
     *            the label to set
     */
    public void setLabel(String label) {
        Label = label;
    }

}
