package com.ssil.listener;

import com.ssil.SchoolMessageSpecificMain;
import com.ssil.model.SchoolMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SchoolMessageSpecificListener {

    private static final Logger log = LoggerFactory.getLogger(SchoolMessageSpecificListener.class);

    @RabbitListener(queues = SchoolMessageSpecificMain.QUEUE_SPECIFIC_NAME)
    public void receiveMessage(final SchoolMessage customMessage) {
        log.info("Received message as specific class: {}", customMessage.toString());
    }

}
