package com.ssil.listener;

import com.ssil.SchoolMessageGenericMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SchoolMessageGenericListener {

    private static final Logger log = LoggerFactory.getLogger(SchoolMessageGenericListener.class);

    @RabbitListener(queues = SchoolMessageGenericMain.QUEUE_GENERIC_NAME)
    public void receiveMessage(final Message message) {
        log.info("Received message as generic: {}", message.toString());
    }

}
