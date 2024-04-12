package com.microtask.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * KafkaController
 *
 * @author DucLN
 * @version 01-00
 * @since 4/12/2024
 */
@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/send")
    public String send(@RequestBody Map<String, String> message) {
        String msgForSend;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            msgForSend = objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        kafkaTemplate.send("test-topic","2", msgForSend);
        return "success";
    }

    @RequestMapping("/producer")
    public String producer() {
        return "producer";
    }

    @RequestMapping("/consumer")
    public String consumer() {
        return "consumer";
    }
}
