package com.pertsol.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class Comment{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commentId;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String commentText;
	
	@Column(nullable = false)
	private LocalDateTime dateOfComment;
	
	
	@PrePersist
	protected void onCreate() {
		dateOfComment=LocalDateTime.now();
	}

}
