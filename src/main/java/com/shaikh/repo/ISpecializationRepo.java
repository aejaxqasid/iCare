package com.shaikh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaikh.model.Specialization;

public interface ISpecializationRepo extends JpaRepository<Specialization, Long> {

}
