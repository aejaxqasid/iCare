package com.shaikh.service;

import java.util.List;
import java.util.Map;

import com.shaikh.model.Specialization;

public interface ISpecializationService {

	// 1. create spec
	public String createSpec(Specialization spec);

	// 2. fetch spec
	public Specialization fetchSpec(Long id);

	// 3. fetch all spec
	public List<Specialization> fetchAllSpecs();

	// 4. update spec
	public String updateSpec(Specialization spec);

	// 5. delete spec
	public String deleteSpec(Long id);

	public Map<Long, String> fetchSpecsIdAndName();

}
