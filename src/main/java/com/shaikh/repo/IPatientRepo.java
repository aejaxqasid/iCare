package com.shaikh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaikh.model.Patient;

public interface IPatientRepo extends JpaRepository<Patient, Long>{

}
