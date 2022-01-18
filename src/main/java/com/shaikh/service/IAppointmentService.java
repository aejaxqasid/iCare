package com.shaikh.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shaikh.model.Appointment;

public interface IAppointmentService {
	
	//1. create apmt
	public String createApmt(Appointment apmt);
	
	//2. get one apmt
	public Appointment fetchApmt(Long id);
	
	//3. get all apmt
	public List<Appointment> fetchAllApmts();
	
	//4. update apmt
	public String updateApmt(Appointment apmt);
	
	//5. delete apmt
	public String deleteApmt(Long id);
	
	public void setSlotCountPlus(Long id);
	
	public void setSlotCountMinus(Long id);
}
