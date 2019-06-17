package edu.mum.cs544.MumRegistrationApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")

public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/login")
    public void login(String Username , String Password)
    {

    }

}
