package com.tst.heo.slack;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestMainController {
    
    @GetMapping("/send")
    public void send(){
        RestTemplate restTemplate = new RestTemplate();

        Map<String,Object> request = new HashMap<String,Object>();
        request.put("username", "slackbot");
        request.put("text", "custom-slack-msg");

        HttpEntity<Map<String,Object>> entity = new HttpEntity<Map<String,Object>>(request);
                    
        String url = "https://hooks.slack.com/services/~~~~~~~~~"; // 사용할 슬랙의 Webhook URL 넣기

        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

    }
}
