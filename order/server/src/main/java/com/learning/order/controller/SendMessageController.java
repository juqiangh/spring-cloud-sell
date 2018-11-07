package com.learning.order.controller;

import com.learning.order.dto.OrderDTO;
import com.learning.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    /*@GetMapping("/sendMessage")
    public void process () {
        streamClient.input().send(MessageBuilder.withPayload("now "+new Date()).build());
    }*/

    /**
     * 发送OrderDTO对象
     */
    @GetMapping("/sendMessage")
    public void process () {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
