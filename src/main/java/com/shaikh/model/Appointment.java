package com.shaikh.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	@Id
	@GeneratedValue
	@Column(name = "apmt_id_col")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "apmt_doc_id_fk_col")
	private Doctor doctor;
	
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
	
	@Column(name = "apmt_shift_col")
	private String shift;
	
	
}
