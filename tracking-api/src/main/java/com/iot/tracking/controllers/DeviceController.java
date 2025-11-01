package com.iot.tracking.controllers;

import com.iot.tracking.entities.Device;
import com.iot.tracking.services.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class DeviceController {
    private final static Logger log = LoggerFactory.getLogger(DeviceController.class);
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("devices")
    public Flux<Device> getAllDevices() {
        log.info("Getting all devices");
        return this.deviceService.getAllDevices();
//        log.info("Number of devices: {}", devices.log());
    }
}