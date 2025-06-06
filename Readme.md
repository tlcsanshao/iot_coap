```sql
CREATE TABLE device
(
    id               BIGINT AUTO_INCREMENT COMMENT '主键ID' PRIMARY KEY,
    sn               VARCHAR(64)          NOT NULL COMMENT '系列号，做为表索引',
    fw_version       VARCHAR(32)          NOT NULL COMMENT '固件版本号',
    proto_version    VARCHAR(32)          NOT NULL COMMENT '协议版本号',
    vendor           VARCHAR(64)          NOT NULL COMMENT '厂商',
    model            VARCHAR(64)          NOT NULL COMMENT '设备型号',
    longitude        FLOAT COMMENT '经度',
    latitude         FLOAT COMMENT '纬度',
    power            INT COMMENT '电量百分比',
    voltage          FLOAT COMMENT '电压',
    num_sensors      INT                  NOT NULL COMMENT '传感器数量',
    collect_interval INT                  NOT NULL COMMENT '采集间隔(单位：秒)',
    report_interval  INT                  NOT NULL COMMENT '上报间隔(单位：秒)',
    isp              ENUM ('1', '2', '3') NOT NULL COMMENT '运营商：1-电信，2-移动，3-联通',
    signals          ENUM ('3', '2', '1', '0') COMMENT '信号强度：3最强，0表示没有信号或者没有模块',
    imei             VARCHAR(20)          NOT NULL COMMENT '模组号',
    imsi             VARCHAR(20) COMMENT '移动用户标识',
    iccid            VARCHAR(20) COMMENT 'SIM卡标识',
    name             VARCHAR(64) COMMENT '设备名称',
    description      TEXT COMMENT '设备描述',
    device_time      TIMESTAMP            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '设备时间',
    added_time       TIMESTAMP            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '第一次添加时间',
    UNIQUE KEY (sn)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='设备信息表';
```


```sql
INSERT INTO device (sn, fw_version, proto_version, vendor, model, longitude, latitude, power, voltage, num_sensors, collect_interval, report_interval, isp, signals, imei, imsi, iccid, name, description)
VALUES
    ('SN202506001', 'V2.1.8', 'P1.3', '华为', 'HW-3000', 116.407526, 39.904030, 85, 4.2, 8, 30, 600, '2', '3', '490154203237518', '460001357924680', '89860121800987654321', '北京监测点1', '电信网络-高信号强度'),
    ('SN202506002', 'V1.9.3', 'P1.2', '中兴', 'ZX-550', 121.473701, 31.230416, 42, 3.8, 5, 60, 900, '1', '2', '357805069831247', '460110987654321', '89860220111234567890', '上海终端A', '低电量预警设备'),
    ('SN202506003', 'V3.0.1', 'P2.0', '大华', 'DH-8800', 113.264385, 23.129112, 100, 5.0, 10, 10, 300, '3', '3', '861503045672198', '460026543217890', '89860118880000000001', '广州采集站', '满电状态-多传感器'),
    ('SN202506004', 'V2.5.7', 'P1.8', '海康', 'HK-760', 120.153576, 30.287459, 23, 3.3, 3, 120, 1800, '2', '1', '352099108765432', '460015555566666', '89860321987654321098', '杭州节点', '弱信号环境设备'),
    ('SN202506005', 'V1.6.2', 'P1.1', '小米', 'MI-S1', 104.065735, 30.659462, 67, 4.0, 6, 45, 1200, '3', '2', '490154203237519', '460003219876543', '89860200001111222233', '成都监测仪', '中电量常规设备'),
    ('SN202506006', 'V3.2.0', 'P2.1', '华为', 'HW-4100', 114.085947, 22.547000, 91, 4.5, 9, 15, 450, '1', '3', '357805069831248', '460119876543210', '89860123456789012345', '深圳终端', '高精度传感器阵列'),
    ('SN202506007', 'V2.0.4', 'P1.5', '中兴', 'ZX-720', 117.000923, 36.675807, 10, 3.1, 2, 180, 3600, '2', '0', '861503045672199', '460027777788888', '89860000000000000001', '济南设备', '急需充电设备'),
    ('SN202506008', 'V1.8.9', 'P1.4', '大华', 'DH-3500', 108.948024, 34.263161, 78, 4.1, 7, 20, 800, '3', '2', '352099108765433', '460013333344444', '89860321000000000099', '西安采集器', '正常运作设备'),
    ('SN202506009', 'V3.1.5', 'P2.2', '海康', 'HK-980', 118.767413, 32.041544, 55, 3.9, 4, 90, 1500, '1', '1', '490154203237520', '460008888899999', '89860219999999999999', '南京监测点', '中等信号设备'),
    ('SN202506010', 'V2.3.6', 'P1.9', '华为', 'HW-2100', 106.504962, 29.533155, 95, 4.8, 12, 5, 240, '2', '3', '357805069831249', '460022222211111', '89860121111111111111', '重庆终端', '高频采集设备');

```
