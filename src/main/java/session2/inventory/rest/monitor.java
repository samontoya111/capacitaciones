package session2.inventory.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class monitor {
    @GetMapping("/monitor")
    public String sayHello() {
        return "Hello, World!";
    }

}
