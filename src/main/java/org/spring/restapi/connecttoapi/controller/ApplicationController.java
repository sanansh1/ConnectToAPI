package org.spring.restapi.connecttoapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApplicationController {

    RestTemplate restTemplate;
    @Value("${restapi.url}")
    private String url;
    ApplicationController(){
        restTemplate =new RestTemplate();
    }
    @GetMapping("/list")
    public String getRandomData()
    {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
}
