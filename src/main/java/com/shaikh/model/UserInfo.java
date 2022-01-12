package com.shaikh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity
@Table(name = "user_info_tab")
public class UserInfo {
	
	
	@SequenceGenerator(
			name = "user_info_seq_gen", 
			initialValue = 4000, 
			allocationSize = 1, 
			sequenceName = "user_info_seq")

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_seq_gen")
	@Column(name = "user_id_col")
	private Long id;

	@Column(name = "user_display_name_col")
	private String displayName;

	@Column(name = "user_name_col")
	private String username;

	@Column(name = "user_password_col")
	private String password;

	@Column(name = "user_role_col")
	private String role;

}
