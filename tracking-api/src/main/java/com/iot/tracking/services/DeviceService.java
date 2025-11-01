package com.iot.tracking.services;

import com.iot.tracking.entities.Device;
import com.iot.tracking.repositories.DeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class DeviceService {
    private final static Logger log = LoggerFactory.getLogger(DeviceService.class);
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Flux<Device> getAllDevices() {
        return this.deviceRepository.findAll();
    }
}