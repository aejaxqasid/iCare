package com.shaikh.service;

import java.util.List;

import com.shaikh.model.Doctor;

public interface IDoctorService {

	// 1. create doc
	public String createDoc(Doctor doc);

	// 2. fetch doc
	public Doctor fetchDoc(Long id);

	// 3. fetch all docs
	public List<Doctor> fetchAll();

	// 4. update doc
	public String updateDoc(Doctor doc);

	// 5. delete doc
	public String deleteDoc(Long id);

}
