package com.shaikh.service;

import java.util.List;

import com.shaikh.model.Patient;

public interface IPatientService {

	
	public String createPatient(Patient patient);
	
	public Patient fetchPatient(Long id);
	
	public List<Patient> fetchAll();
	
	public String updatePatient(Patient patient);
	
	public String deletePatient(Long id);
	
	public Patient fetchPatientByEmail(String email);
}
