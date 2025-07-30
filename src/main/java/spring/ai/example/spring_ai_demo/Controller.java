package spring.ai.example.spring_ai_demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController()
public class Controller {

    @Autowired
    private ChatClient chatClient;

    @GetMapping("/chat")
    public String chat(String input) {
        return chatClient.prompt()
                .user(input)
                .call()
                .content();
    }
    @GetMapping(value = "/chat/stream" ,produces = "text/html;charset=UTF-8")
    public Flux<String> chatStream(String input) {
        return chatClient.prompt()
                .user(input)
                .stream()
                .content();
    }
}
