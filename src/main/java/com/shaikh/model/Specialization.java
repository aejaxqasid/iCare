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
@Table(name = "specialization_tab")
public class Specialization {
	
	@SequenceGenerator(
			name = "specialization_seq_gen", 
			initialValue = 14000, 
			allocationSize = 1, 
			sequenceName = "specialization_seq")

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specialization_seq_gen")
	@Column(name = "spec_id_col")
	private Long id;
	
	@Column(name = "spec_code_col")
	private String code;
	
	@Column(name = "spec_name_col")
	private String name;
	
	@Column(name = "spec_desc_col")
	private String desc;

}
