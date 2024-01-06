package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("parent")
public class RestExample {
	
	@GetMapping("/read")
    public String readReadings() {
        return "Im Done";
    }

}
