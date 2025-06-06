package org.example.config;

import org.eclipse.californium.core.CoapServer;
import org.example.coap_controller.CoapController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CoapServerRunner implements CommandLineRunner {

    @Autowired
    private CoapController coapController;

    @Override
    public void run(String... args) {
        CoapServer server = new CoapServer();
        server.add(coapController);
        server.start();
        System.out.println("CoAP server started on port 5683");
    }
}