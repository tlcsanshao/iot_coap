package org.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.Device;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 设备信息表 服务类
 * </p>
 *
 * @author sanshao
 * @since 2025-06-04
 */
public interface IDeviceService extends IService<Device> {

    public Page<Device> getDeviceList(int current, int size, String keyword);

}
