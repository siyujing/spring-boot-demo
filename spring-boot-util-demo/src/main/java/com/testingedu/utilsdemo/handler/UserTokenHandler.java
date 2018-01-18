package com.testingedu.utilsdemo.handler;


import com.testingedu.utilsdemo.App.conf.BepropertiesDemo2;
import com.testingedu.utilsdemo.App.utils.FormatUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class UserTokenHandler {
    @Autowired
    BepropertiesDemo2 bepropertiesDemo2;

    RestTemplate restTemplate;

    public UserTokenHandler (RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder
                .setConnectTimeout(30_000)
                .setReadTimeout(30_000)
                .build();
    }

    public void requestUrl(String text, String token) {
        try {
            // url
            String url = bepropertiesDemo2.getUrl1();

            // body
            String body = FormatUtils.toJsonNoException(new EvaluationComponentBody(text, true));

            // heads
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            headers.set("token", token);

            // request
            HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

            // 处理response结果
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

            String responseBody = response.getBody();
            System.out.println(responseBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Data
    @NoArgsConstructor
    public static class EvaluationComponentBody {
        private String text;
        private Boolean separate_revisions;

        public EvaluationComponentBody(String text, Boolean separate_revisions) {
            this.text = text;
            this.separate_revisions = separate_revisions;
        }
    }
}
