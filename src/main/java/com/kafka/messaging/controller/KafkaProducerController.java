package com.kafka.messaging.controller;


import com.kafka.messaging.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    private final KafkaProducerService producerService;

    public KafkaProducerController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/publish")
    public String publishMessage(@RequestParam String key, @RequestParam String message) {
        producerService.sendMessage(key, message);
        return "Message published successfully";
    }
}

