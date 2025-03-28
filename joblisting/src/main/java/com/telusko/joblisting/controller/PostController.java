package com.telusko.joblisting.controller;

import java.io.IOException;
import java.util.List;

//import javax.servlet.http.HttpServleResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.joblisting.model.Post;
import com.telusko.joblisting.repository.PostRepository;
import com.telusko.joblisting.repository.SearchRepository;

import springfox.documentation.annotations.ApiIgnore;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
	
	@Autowired
	PostRepository repo;
	@Autowired
	SearchRepository srepo;
	
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("swagger-ui.html");
	}
	
	@GetMapping("/allPosts")
	@CrossOrigin
	public List<Post> getAllPosts(){
		
		
		return repo.findAll();
		
	}
	@GetMapping("/posts/{text}")
	public List<Post> search(@PathVariable String text)
	{
		return srepo.findByText(text);
	}
	
	@PostMapping("/post")
	public Post addPost(@RequestBody Post post) {
		return repo.save(post);
	}

}
