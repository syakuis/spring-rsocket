package io.github.syakuis.rsocket.application;

import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Seok Kyun. Choi.
 * @since 2021-10-26
 */
@RequiredArgsConstructor
@RestController
public class GraphRestController {
    private final RSocketRequester rSocketRequester;

    @RequestMapping("/graph/update")
    Publisher<Long> update() {
        return rSocketRequester
            .route("graph-update")
            .data((long) Math.floor(Math.random() * 100000 + 1))
            .retrieveMono(Long.class);
    }
}
