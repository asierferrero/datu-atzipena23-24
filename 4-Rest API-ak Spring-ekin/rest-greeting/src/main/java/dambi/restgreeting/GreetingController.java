package dambi.restgreeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private String template = "Hello, %s!"; // Default value
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "hizkuntza", defaultValue = "Hello") String hizkuntza) {
        if (hizkuntza.equals("eus")) {
            template = "Kaixo, %s!";
            if (name.equals("World")) {
                name = "Mundua";
            }
        } else if (hizkuntza.equals("es")) {
            template = "Hola, %s!";
            if (name.equals("World")) {
                name = "Mundo";
            }
        } else if (hizkuntza.equals("eng")) {
            if (name.equals("World")) {
                name = "World";
            }
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}