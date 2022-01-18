package com.shaikh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shaikh.model.SlotRequest;

public interface ISlotRequestRepo extends JpaRepository<SlotRequest, Long> {
	
	@Query("SELECT sr FROM SlotRequest sr INNER JOIN sr.patient as patient WHERE patient.email = :email")
	public List<SlotRequest> findAllPatientSlot(String email);
	
	@Query("SELECT sr FROM SlotRequest sr INNER JOIN sr.appointment as appointment INNER JOIN appointment.doctor as doctor WHERE doctor.email = :email")
	public List<SlotRequest> findAllDoctorSlot(String email);
	
	@Query("UPDATE SlotRequest SET status = :status WHERE id = :id")
	@Modifying
	public void updateSlotStatus(String status, Long id);


}
