package com.shaikh.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity
@Table(name = "patient_tab")
public class Patient {

	@Id
	@GeneratedValue
	@Column(name = "patient_id_col")
	private Long id;

	@Column(name = "patient_name_col")
	private String name;

	@Column(name = "patient_email_col")
	private String email;

	@Column(name = "patient_mobile_col")
	private String mobile;

	@Column(name = "patient_gen_col")
	private String gender;

	@Column(name = "patient_addr_col")
	private String addr;

	@Column(name = "patient_dis_col")
	@ElementCollection
	@CollectionTable(name = "patient_disease_tab", joinColumns = @JoinColumn(name = "patient_id_fk_col"))
	private Set<String> disease;

}
