package com.shaikh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaikh.exception.AppointmentNotFoundException;
import com.shaikh.model.Appointment;
import com.shaikh.repo.IAppointmentRepo;
import com.shaikh.service.IAppointmentService;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private IAppointmentRepo repo;

	@Override
	public String createApmt(Appointment apmt) {
		Long id = repo.save(apmt).getId();
		return "Appintment " + id + " Created";
	}

	@Override
	public Appointment fetchApmt(Long id) {
		Optional<Appointment> apmt = repo.findById(id);
		if (apmt.isPresent())
			return apmt.get();
		else
			throw new AppointmentNotFoundException("Appointment " + id + " Not found");
	}

	@Override
	public List<Appointment> fetchAllApmts() {
		return repo.findAll();
	}

	@Override
	public String updateApmt(Appointment apmt) {
		Long id = repo.save(apmt).getId();
		return "Appointment " + id + " Updated";
	}

	@Override
	public String deleteApmt(Long id) {
		Appointment apmt = fetchApmt(id);
		repo.delete(apmt);
		return "Appointment " + id + " Deleted";
	}

}
