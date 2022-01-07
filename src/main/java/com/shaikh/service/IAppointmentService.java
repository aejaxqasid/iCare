package com.shaikh.service;

import java.util.List;

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

}
