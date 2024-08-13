package com.pertsol.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pertsol.exception.CommentIdNotFoundException;
import com.pertsol.model.Comment;
import com.pertsol.repository.CommentRepository;
import com.pertsol.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	private final CommentRepository commentRepository;
	

	public CommentServiceImpl(CommentRepository commentRepository) {
		super();
		this.commentRepository = commentRepository;
	}

	@Override
	public Comment addComment(Comment comment) {
		Comment newComment=commentRepository.save(comment);
		return newComment;
	}

	@Override
	public List<Comment> getAllComments() {
		List<Comment>allComments=commentRepository.findAll();
		return allComments;
	}

	@Override
	public Comment getCommentById(long commentId) {
		Comment comment=commentRepository.findById(commentId).orElseThrow(()->new CommentIdNotFoundException("Comment is not found Using this Id"));
		return comment;
	}

	@Override
	public List<Comment> findByUsername(String username) {
		List<Comment> comment=commentRepository.findByUsername(username);
		if(comment.isEmpty()) {
			throw new IllegalArgumentException("Comments not found using this username");
		}
		return comment;
	}

	@Override
	public String deleteById(long commentId) {
		commentRepository.findById(commentId).orElseThrow(()->new CommentIdNotFoundException("Comment is not found Using this Id"));
		commentRepository.deleteById(commentId);
		return "Comment is Deleted Successfully with this Id  "+commentId;
	}

	@Override
	public List<Comment> findByDateOfComment(LocalDate date) {
		 LocalDateTime startDateTime = date.atStartOfDay();
	        LocalDateTime endDateTime = date.atTime(LocalTime.MAX);
		List<Comment>allComments=commentRepository.findByDateOfCommentBetween(startDateTime,endDateTime);
		if(allComments.isEmpty()) {
			throw new IllegalArgumentException("Comments not found On This Date");
		}
		return allComments;
	}
	
	

}
