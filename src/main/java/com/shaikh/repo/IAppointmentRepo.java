package com.shaikh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shaikh.model.Appointment;

public interface IAppointmentRepo extends JpaRepository<Appointment, Long>{
	
	@Query("UPDATE Appointment SET slots = slots - 1 WHERE id = :id")
	@Modifying
	public void updateSlotCountMinus(Long id);
	
	@Query("UPDATE Appointment SET slots = slots + 1 WHERE id = :id")
	@Modifying
	public void updateSlotCountPlus(Long id);

}
