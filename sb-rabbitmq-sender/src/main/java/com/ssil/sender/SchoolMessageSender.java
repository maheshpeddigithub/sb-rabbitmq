package com.ssil.sender;

import com.ssil.SchoolMessageMain;
import com.ssil.model.SchoolMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SchoolMessageSender {

    private static final Logger log = LoggerFactory.getLogger(SchoolMessageSender.class);

    private final RabbitTemplate rabbitTemplate;

    public SchoolMessageSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 3000L)
    public void sendMessage() {
        final SchoolMessage message = new SchoolMessage("Hello there!", new Random().nextInt(50), false);
        log.info("Sending message...");
        rabbitTemplate.convertAndSend(SchoolMessageMain.EXCHANGE_NAME, SchoolMessageMain.ROUTING_KEY, message);
    }

}
