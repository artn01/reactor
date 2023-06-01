package project1.handler;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import project1.Greeting;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new Greeting("Hello, Spring!")));
    }

    public Mono<ServerResponse> flux(ServerRequest request) {
        Long start = request.queryParam("start")
                .map(Long::valueOf)
                .orElse(0L);

        Long count = request.queryParam("count")
                .map(Long::valueOf)
                .orElse(3L);


        Flux<Greeting> data = Flux
                .just(
                        "Hello, reactive!",
                        "More than one",
                        "Third post",
                        "Fourth post",
                        "Fifth post"
                )
                .skip(start)  // where we begin
                .take(count) // how much elements we take
                .map(Greeting::new);

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(data, Greeting.class);
    }

    public Mono<ServerResponse> secret(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("You found me!"));
    }

    public Mono<ServerResponse> index (ServerRequest request) {
        String user = request.queryParam("user").orElse("Nobody");
        return ServerResponse
                .ok()
                .render("index", Map.of("user", user));
    }
}