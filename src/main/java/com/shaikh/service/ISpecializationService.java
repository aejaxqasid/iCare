package com.shaikh.service;

import java.util.List;

import com.shaikh.model.Specialization;

public interface ISpecializationService {

	// 1. create spec
	public String createSpec(Specialization spec);

	// 2. fech spec
	public Specialization fetchSpec(Long id);

	// 3. fetch all spec
	public List<Specialization> fetchAllSpecs();

	// 4. update spec
	public String updateSpec(Specialization spec);

	// 5. delete spec
	public String deleteSpec(Long id);

}
