package io.github.syakuis.rsocket.application;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

/**
 * @author Seok Kyun. Choi.
 * @since 2021-10-26
 */
@Controller
public class GraphController {

    @GetMapping("/")
    String index() {
        return "index";
    }

    @MessageMapping("graph-random")
    Mono<Long> graphStatic() {
        return Mono.just((long) Math.floor(Math.random()*100000+1));
    }
}
