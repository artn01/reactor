package project1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project1.Greeting;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/controller")
public class MainController {
    @GetMapping
    public Flux<Greeting> list(@RequestParam(defaultValue = "0") Long start,
                               @RequestParam(defaultValue = "3") Long count) {
        return Flux
                .just(
                        "Hello, reactive!",
                        "More than one",
                        "Third post",
                        "Fourth post",
                        "Fifth post"
                )
                .skip(start)  // where we begin
                .take(count) // how many elements we take
                .map(Greeting::new);
    }

}
