package com.shaikh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "doctor_tab")

@Data
public class Doctor {
	
	
	@SequenceGenerator(
			name = "doctor_seq_gen", 
			initialValue = 8000, 
			allocationSize = 1, 
			sequenceName = "doctor_seq")

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_seq_gen")
	@Column(name = "doc_id_col")
	private Long id;

	@Column(name = "doc_first_name_col")
	private String firstName;

	@Column(name = "doc_last_name_col")
	private String lastName;

	@Column(name = "doc_email_col")
	private String email;

	@Column(name = "doc_gender_col")
	private String gender;

	@Column(name = "doc_mobile_col")
	private String mobile;

	@Column(name = "doc_address_col")
	private String addr;
	
	//TODO : add avatar image for doctor (Google Avataar)

	@OneToOne
	@JoinColumn(name = "spec_id_fk_col")
	private Specialization spec;
	
	//TODO : add doctors qualifications Set<String>  [MBBS, MD, ETC]
	//private Set<String> degrees;

}
