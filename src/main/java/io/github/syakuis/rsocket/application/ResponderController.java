package io.github.syakuis.rsocket.application;

import lombok.Synchronized;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.annotation.ConnectMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author Seok Kyun. Choi.
 * @since 2021-10-26
 *
 * https://spring.io/blog/2020/05/12/getting-started-with-rsocket-servers-calling-clients
 */
@Controller
public class ResponderController {
    private Map<String, RSocketRequester> requester = Map.of();

    @Synchronized
    private Map<String, RSocketRequester> getRequester() {
        return this.requester;
    }

    @Synchronized
    private void addRequester(String clientId, RSocketRequester requester) {
        this.requester.put(clientId, requester);
    }

    @Synchronized
    private void removeRequester(String clientId) {
        this.requester.remove(clientId);
    }

    @ConnectMapping("client-id")
    Mono<Void> connect(RSocketRequester requester, String clientId) {
        requester.rsocket().onClose().subscribe(null, null, () -> {
            this.removeRequester(clientId);
        });

        this.addRequester(clientId, requester);
    }


    @MessageMapping("graph-random")
    Mono<Long> graphStatic() {
        return Mono.just((long) Math.floor(Math.random()*100000+1));
    }
}
