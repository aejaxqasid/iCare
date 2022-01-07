package com.shaikh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaikh.model.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor, Long> {

}
