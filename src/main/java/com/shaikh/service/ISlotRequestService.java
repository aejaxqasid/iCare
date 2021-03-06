package com.shaikh.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.shaikh.model.SlotRequest;

public interface ISlotRequestService {

	// 1. create SlotRequest
	public String createSlotRequest(SlotRequest slotRequest);

	// 2. fetch SlotRequest
	public SlotRequest fetchSlotRequest(Long id);

	// 3. fetch all SlotRequests
	public List<SlotRequest> fetchAll();

	// 4. update SlotRequest
	public String updateSlotRequest(SlotRequest slotRequest);

	// 5. delete SlotRequest
	public String deleteSlotRequest(Long id);
	
	public List<SlotRequest> fetchAllPatientSlot(String email);
	
	public List<SlotRequest> fetchAllDoctorSlot(String email);
	
	public void updateSlotStatus(String status, Long id);

}
