package com.shaikh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaikh.exception.PatientNotFoundException;
import com.shaikh.model.Patient;
import com.shaikh.repo.IPatientRepo;
import com.shaikh.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientRepo repo;

	@Override
	public String createPatient(Patient patient) {
		Long id = repo.save(patient).getId();
		return "Patient " + id + " Created";
	}

	@Override
	public Patient fetchPatient(Long id) {
		Optional<Patient> patient = repo.findById(id);
		if (patient.isPresent())
			return patient.get();
		else
			throw new PatientNotFoundException("Patient with id : " + id + " not Found!");

	}

	@Override
	public List<Patient> fetchAll() {
		return repo.findAll();
	}

	@Override
	public String updatePatient(Patient patient) {
		Long id = repo.save(patient).getId();
		return "Patient " + id + " Updated";
	}

	@Override
	public String deletePatient(Long id) {
		Patient patient = repo.findById(id).get();
		repo.delete(patient);
		return "Patient " + id + " Deleted";
	}

}
