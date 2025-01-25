package com.sachith.employee.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "sachith-demo1",groupId = "sachith-consumer-group")
    public void consume(String message){
        logger.info("consume {}", message);
    }

}
