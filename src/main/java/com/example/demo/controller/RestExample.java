package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Post;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/start")
public class RestExample {
	
	@GetMapping("/sam")
	public List<Post> callRestAPI(RestTemplate restTemplate) {
		String url = "https://jsonplaceholder.typicode.com/posts/";
		String response = restTemplate.getForObject(url, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		Post[] posts = null;
		List<Post> leads = new ArrayList<>();;
		try {
		 posts = objectMapper.readValue(response, Post[].class);
		 
		 for(Post pos: posts) {
			 if(pos.getUserId().equals("1") || pos.getUserId().equals("4")) {
				leads.add(pos); 
			 }
		 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leads;
	}
}
