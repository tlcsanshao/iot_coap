package org.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.coap_service.DeviceService;
import org.example.entity.Device;
import org.example.service.impl.DeviceServiceImpl;
import org.example.utils.ApiResult;
import org.example.utils.PageResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 设备信息表 前端控制器
 * </p>
 *
 * @author sanshao
 * @since 2025-06-04
 */
@RestController
@RequestMapping("/device")
public class DeviceController {

    @Resource
    DeviceServiceImpl service;

    @GetMapping("/devicelist")
    public ApiResult<PageResult<Device>> getDeviceList(@RequestParam(value = "current", defaultValue = "1") int current,
                                                       @RequestParam(value = "size", defaultValue = "10") int size,
                                                       @RequestParam(value = "keyword", required = false) String keyword) {

        Page<Device> page = service.getDeviceList(current, size, keyword);
        return ApiResult.ok(PageResult.of(page));
    }


}
