package io.github.syakuis.rsocket.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * @author Seok Kyun. Choi.
 * @since 2021-10-26
 */
@Slf4j
@Controller
public class SampleController {
    @MessageMapping("sample")
    Message message(Message message) {
        log.debug("request: {}", message.getMessage());

        return Message.builder()
            .message("ok!!!")
            .build();
    }
}
