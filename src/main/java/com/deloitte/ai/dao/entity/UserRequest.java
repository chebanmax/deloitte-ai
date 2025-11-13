package com.deloitte.ai.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

	private String text;
}

