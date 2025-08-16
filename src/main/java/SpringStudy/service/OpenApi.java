package SpringStudy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OpenApi {

    private final ChatClient chatClient;

    public String askQuestion(String message){
        return chatClient.prompt().user(message).call().content();
    }
}
