package com.shaikh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shaikh.model.Specialization;

public interface ISpecializationRepo extends JpaRepository<Specialization, Long> {

	@Query("SELECT id,name FROM Specialization")
	public List<Object[]> findSpecsIdAndName();

}
