package com.shaikh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaikh.model.Appointment;

public interface IAppointmentRepo extends JpaRepository<Appointment, Long>{

}
