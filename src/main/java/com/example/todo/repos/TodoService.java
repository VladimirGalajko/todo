package com.example.todo.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TodoService {

    private final RestTemplate restTemplate;

    @Autowired
    public TodoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//    public void sendPostRequest() {
//        // ваш код отправки POST-запроса
//    }
}
