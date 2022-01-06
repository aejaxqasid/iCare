package com.shaikh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaikh.exception.SpecializationNotFoundException;
import com.shaikh.model.Specialization;
import com.shaikh.repo.ISpecializationRepo;
import com.shaikh.service.ISpecializationService;
import com.shaikh.utils.CustomCollectionUtils;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

	@Autowired
	private ISpecializationRepo repo;

	@Override
	public String createSpec(Specialization spec) {
		Long id = repo.save(spec).getId();
		return "Specialization " + id + " created";
	}

	@Override
	public Specialization fetchSpec(Long id) {
		Optional<Specialization> spec = repo.findById(id);
		if (spec.isPresent())
			return spec.get();
		else
			throw new SpecializationNotFoundException("Specialization " + id + "Not Available");
	}

	@Override
	public List<Specialization> fetchAllSpecs() {
		return repo.findAll();
	}

	@Override
	public String updateSpec(Specialization spec) {
		Long id = repo.save(spec).getId();
		return "Specialization " + id + " Updated!";
	}

	@Override
	public String deleteSpec(Long id) {
		Specialization spec = fetchSpec(id);
		repo.delete(spec);
		return "Specialization " + id + " Deleted";
	}

	@Override
	public Map<Long, String> fetchSpecsIdAndName() {
		List<Object[]> list = repo.findSpecsIdAndName();
		return CustomCollectionUtils.convertToMap(list);
	}

}
