package com.sachith.address.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("sachith-demo1", message);

        future.whenComplete((result,ex) ->{
            if(ex == null){
                System.out.println("Send message=[ "+ message+
                        " ] with offset=[ "+result.getRecordMetadata().offset()+"]");
            } else {
                System.out.println("Unable to send message=[ "+
                        message + "] due to : "+ex.getMessage());
            }
        });
    }
}
