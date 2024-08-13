package com.pertsol.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pertsol.model.Comment;

@Repository
public interface CommentRepository  extends JpaRepository<Comment, Long>{

	public List<Comment> findByUsername(String username);
	
	public List<Comment> findByDateOfCommentBetween(LocalDateTime startDateTime,LocalDateTime endDateTime);

}
