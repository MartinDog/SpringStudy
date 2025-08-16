package SpringStudy.controller;

import SpringStudy.service.OpenApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AiController {
    private final OpenApi chatGpt;

    @GetMapping("/ai/ask")
    public String askApi(@RequestParam("question") String question){
        return chatGpt.askQuestion(question);

    }
}
