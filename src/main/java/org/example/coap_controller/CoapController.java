package org.example.coap_controller;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.example.coap_service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoapController extends CoapResource {

    @Autowired
    private DeviceService deviceService;

    public CoapController() {
        super("heartbeat");
    }

    @Override
    public void handlePOST(CoapExchange exchange) {
        String deviceId = exchange.getRequestText();
        deviceService.registerOrUpdateHeartbeat(deviceId);
        exchange.respond("Heartbeat received for device: " + deviceId);
        System.out.println("aaaa");
    }
}
