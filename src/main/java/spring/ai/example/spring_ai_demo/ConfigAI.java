package spring.ai.example.spring_ai_demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigAI {
    @Bean
    public ChatClient chatClient(DeepSeekChatModel model) {
       return ChatClient.builder(model).defaultSystem("你是一个可爱的小魔女").build();
    }
}
