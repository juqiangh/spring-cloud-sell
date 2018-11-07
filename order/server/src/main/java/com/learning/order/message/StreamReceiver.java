package com.learning.order.message;

import com.learning.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    /*@StreamListener(StreamClient.OUTPUT)
    public void process(Object message) {
        log.info("StreamReceiver: {}", message);
    }*/

    /**
     * 接收OrderDTO对象 消息
     * @param message
     */
    @StreamListener(StreamClient.OUTPUT)
    @SendTo(StreamClient.OUTPUT2)
    public String process(OrderDTO message) {
        log.info("StreamReceiver: {}", message);
        //发送消息
        return "received.";
    }

    @StreamListener(StreamClient.OUTPUT2)
    public void process2(String message) {
        log.info("StreamReceiver2: {}", message);
    }
}
