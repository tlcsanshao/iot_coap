package org.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.entity.Device;
import org.example.mapper.DeviceMapper;
import org.example.service.IDeviceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 设备信息表 服务实现类
 * </p>
 *
 * @author sanshao
 * @since 2025-06-04
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {

    @Resource
    DeviceMapper mapper;

    public Page<Device> getDeviceList(int current, int size, String keyword) {
        Page<Device> page = new Page<>(current, size);
        return mapper.selectDeviceList(page, keyword);
    }
}
