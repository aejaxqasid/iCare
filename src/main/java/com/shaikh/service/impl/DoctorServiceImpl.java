package com.shaikh.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaikh.exception.DoctorNotFoundException;
import com.shaikh.model.Doctor;
import com.shaikh.repo.IDoctorRepo;
import com.shaikh.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo repo;

	@Override
	public String createDoc(Doctor doc) {
		Long id = repo.save(doc).getId();
		return "Doctor " + id + " Created";
	}

	@Override
	public Doctor fetchDoc(Long id) {
		Optional<Doctor> doc = repo.findById(id);
		if (doc.isPresent())
			return doc.get();
		else
			throw new DoctorNotFoundException("Doctor with id : " + id + " not Found!");

	}

	@Override
	public List<Doctor> fetchAll() {
		return repo.findAll();
	}

	@Override
	public String updateDoc(Doctor doc) {
		Long id = repo.save(doc).getId();
		return "Doctor " + id + " Updated";
	}

	@Override
	public String deleteDoc(Long id) {
		Doctor doc = repo.findById(id).get();
		repo.delete(doc);
		return "Doctor " + id + " Deleted";
	}

}
