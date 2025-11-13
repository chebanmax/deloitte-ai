package com.deloitte.ai.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
	@Id
	private String id;

	@Column(name = "user_id")
	private String userId;

	private String text;

	public UserRequest(String userId, String text) {
		this.id = UUID.randomUUID().toString();
		this.userId = userId;
		this.text = text;
	}
}

