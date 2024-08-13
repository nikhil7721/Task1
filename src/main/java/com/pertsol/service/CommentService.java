package com.pertsol.service;

import java.time.LocalDate;
import java.util.List;

import com.pertsol.model.Comment;

public interface CommentService {
	
	public Comment addComment(Comment comment);
	
	public List<Comment>getAllComments();
	
	public Comment getCommentById(long commentId);
	
	public List<Comment> findByUsername(String username);
	
	public List<Comment> findByDateOfComment(LocalDate date);
	
	public String deleteById(long commentId);

}
