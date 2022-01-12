package com.shaikh.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Entity
@Table(name = "appointment_tab")

@Data
public class Appointment {
	
	@SequenceGenerator(
			name = "appointment_seq_gen", 
			initialValue = 7000, 
			allocationSize = 1, 
			sequenceName = "appointment_seq")

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq_gen")
	@Column(name = "apmt_id_col")
	
	private Long id;

	@Column(name = "apmt_slot_col")
	private Integer slots;

	@Column(name = "ampt_date_col")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date date;

	@Column(name = "apmt_details_col")
	private String details;

	@Column(name = "apmt_fee_col")
	private Double fee;

	// TODO: add shift [MORNING,EVENING,AFTERNOON]
	@Column(name = "apmt_shift_col")
	private String shift;

	@OneToOne
	@JoinColumn(name = "apmt_doc_id_fk_col")
	private Doctor doctor;

}
