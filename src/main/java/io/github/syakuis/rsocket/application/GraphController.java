package io.github.syakuis.rsocket.application;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author Seok Kyun. Choi.
 * @since 2021-10-26
 *
 * https://spring.io/blog/2020/05/12/getting-started-with-rsocket-servers-calling-clients
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

    @MessageMapping("graph-refresh")
    Flux<Long> graphRefresh() {
        return Flux.interval(Duration.ofMillis(500)).map(index -> (long) Math.floor(Math.random() * 100000 + 1));
    }
}
