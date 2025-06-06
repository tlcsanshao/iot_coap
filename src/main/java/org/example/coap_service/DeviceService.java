package org.example.coap_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

//    @Autowired
//    private DeviceMapper deviceMapper;

    public void registerOrUpdateHeartbeat(String deviceId) {
        System.out.println("注册Device Id = ====" + deviceId);
        //        Device existingDevice = deviceMapper.selectByDeviceId(deviceId);
        //        if (existingDevice != null) {
        //            deviceMapper.updateHeartbeatTime(deviceId, LocalDateTime.now());
        //        } else {
        //            Device newDevice = new Device();
        //            newDevice.setDeviceId(deviceId);
        //            newDevice.setStatus("ONLINE");
        //            newDevice.setLastHeartbeatTime(LocalDateTime.now());
        //            deviceMapper.insertDevice(newDevice);
        //        }
    }
}
