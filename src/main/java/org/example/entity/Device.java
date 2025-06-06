package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 设备信息表
 * </p>
 *
 * @author sanshao
 * @since 2025-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 系列号，做为表索引
     */
    private String sn;

    /**
     * 固件版本号
     */
    private String fwVersion;

    /**
     * 协议版本号
     */
    private String protoVersion;

    /**
     * 厂商
     */
    private String vendor;

    /**
     * 设备型号
     */
    private String model;

    /**
     * 经度
     */
    private Float longitude;

    /**
     * 纬度
     */
    private Float latitude;

    /**
     * 电量百分比
     */
    private Integer power;

    /**
     * 电压
     */
    private Float voltage;

    /**
     * 传感器数量
     */
    private Integer numSensors;

    /**
     * 采集间隔(单位：秒)
     */
    private Integer collectInterval;

    /**
     * 上报间隔(单位：秒)
     */
    private Integer reportInterval;

    /**
     * 运营商：1-电信，2-移动，3-联通
     */
    private String isp;

    /**
     * 信号强度：3最强，0表示没有信号或者没有模块
     */
    private String signals;

    /**
     * 模组号
     */
    private String imei;

    /**
     * 移动用户标识
     */
    private String imsi;

    /**
     * SIM卡标识
     */
    private String iccid;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备描述
     */
    private String description;

    /**
     * 设备时间
     */
    private LocalDateTime deviceTime;

    /**
     * 第一次添加时间
     */
    private LocalDateTime addedTime;


}
