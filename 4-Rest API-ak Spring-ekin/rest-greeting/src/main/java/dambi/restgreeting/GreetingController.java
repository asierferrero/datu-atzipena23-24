package dambi.restgreeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/hello")
    public String greeting2(@RequestParam(value = "name", defaultValue = "World") String name) throws JsonProcessingException {
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));

        // Jackson erabiliz JSON dokumentu bihurtu
        String json = objectMapper.writeValueAsString(greeting);

        // Json dokumentua itzuli
        return json;
    }
}
