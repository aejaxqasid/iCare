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

import com.shaikh.constants.SlotStatus;

import lombok.Data;

@Entity
@Table(name = "slot_request_tab")

@Data
public class SlotRequest {
	
	@SequenceGenerator(
			name = "slot_request_seq_gen", 
			initialValue = 12000, 
			allocationSize = 1, 
			sequenceName = "slot_request_seq")

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slot_request_seq_gen")
	@Column(name = "slot_id_col")
	private Long id;
	
	
	@OneToOne
	@JoinColumn(name = "paitent_id_fk_col")
	private Patient patient;
	
	
	@OneToOne
	@JoinColumn(name = "apointment_id_fk_col")
	private Appointment apointment;
	
	@Column(name = "slot_status_col")
	private String status = SlotStatus.PENDING.name();
}
