package project1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import project1.handler.GreetingHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

    @Bean // Beans - objects that form the backbone of your application and that are managed by the Spring IoC container
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions
                .route(GET("/secret").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::secret)
                .andRoute(
                        GET("/"),
                        greetingHandler::hello);
    }


}
