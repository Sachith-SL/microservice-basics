package com.sachith.address.controller;

import com.sachith.address.model.Address;
import com.sachith.address.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/producer")
public class EventController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message){
        try {
            publisher.sendMessageToTopic(message);
            return ResponseEntity.ok("success");
        } catch (Exception ex){
            return ResponseEntity.internalServerError().body("error");
        }
    }
}
