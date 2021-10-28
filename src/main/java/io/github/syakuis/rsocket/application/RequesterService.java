package io.github.syakuis.rsocket.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.annotation.ConnectMapping;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author Seok Kyun. Choi.
 * @since 2021-10-28
 */
@Controller
public class RequesterService {
    @ConnectMapping
    public Mono<Void> send(RSocketRequester requester) {
        Flux.interval(Duration.ofMillis(500)).map(index -> {
            return requester.route("graph-refresh").data((long) Math.floor(Math.random() * 100000 + 1)).retrieveFlux(String.class).subscribe();
        });

        return Mono.empty();
    }
}
