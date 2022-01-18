package com.shaikh.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaikh.model.Patient;

public interface IPatientRepo extends JpaRepository<Patient, Long>{
	
	Optional<Patient> findByEmail(String email);

}
