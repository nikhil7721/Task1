package com.pertsol.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pertsol.model.Comment;
import com.pertsol.serviceimpl.CommentServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2")
public class CommentController {
	
	private final CommentServiceImpl commentServiceImpl;
	
	
	public CommentController(CommentServiceImpl commentServiceImpl) {
		super();
		this.commentServiceImpl = commentServiceImpl;
	}


    @PostMapping("/addcomment")
	public ResponseEntity<Comment> addComment(@Valid @RequestBody  Comment comment) {
		Comment newcomment=commentServiceImpl.addComment(comment);
		return new ResponseEntity<>(newcomment,HttpStatus.CREATED);
	}
    
    @GetMapping("/comments")
    public List<Comment> allComments(){
    	List<Comment>allComments=commentServiceImpl.getAllComments();
    	return allComments;
    }
    
    @GetMapping("/comments/searchbyname")
    public List<Comment>getCommentsByUsername(@RequestParam String username){
    	List<Comment>allComments=commentServiceImpl.findByUsername(username);
    	return allComments;
    }
    
    @GetMapping("/comments/searchbydate")
    public List<Comment>getCommentsByDate(@RequestParam LocalDate date){
    	List<Comment>allComments=commentServiceImpl.findByDateOfComment(date);
    	return allComments;
    }

}
