package com.deloitte.ai.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_response")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	@Id
	private String id;

	@Column(name = "request_id")
	private String requestId;

	private String response;
}
