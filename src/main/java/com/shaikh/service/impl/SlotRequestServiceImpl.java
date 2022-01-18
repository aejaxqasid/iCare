package com.shaikh.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaikh.constants.SlotStatus;
import com.shaikh.exception.SlotRequestNotFoundException;
import com.shaikh.model.Appointment;
import com.shaikh.model.SlotRequest;
import com.shaikh.repo.ISlotRequestRepo;
import com.shaikh.service.IAppointmentService;
import com.shaikh.service.ISlotRequestService;

@Service
public class SlotRequestServiceImpl implements ISlotRequestService {

	@Autowired
	private ISlotRequestRepo repo;
	
	@Autowired
	private IAppointmentService apmtService;

	@Override
	public String createSlotRequest(SlotRequest slotRequest) {
		Long id = repo.save(slotRequest).getId();
		// TODO : update number of slots in appointment
		return "Slot Request " + id + " Created";
	}

	@Override
	public SlotRequest fetchSlotRequest(Long id) {
		Optional<SlotRequest> slotRequest = repo.findById(id);
		if (slotRequest.isPresent())
			return slotRequest.get();
		else
			throw new SlotRequestNotFoundException("Slot with id : " + id + " not Found!");

	}

	@Override
	public List<SlotRequest> fetchAll() {
		return repo.findAll();
	}

	@Override
	public String updateSlotRequest(SlotRequest slotRequest) {
		Long id = repo.save(slotRequest).getId();
		return "Slot " + id + " Updated";
	}

	@Override
	public String deleteSlotRequest(Long id) {
		SlotRequest slotRequest = repo.findById(id).get();
		repo.delete(slotRequest);
		return "Slot" + id + " Deleted";
	}

	@Override
	public List<SlotRequest> fetchAllPatientSlot(String email) {
		return repo.findAllPatientSlot(email);
	}

	@Override
	public List<SlotRequest> fetchAllDoctorSlot(String email) {
		return repo.findAllDoctorSlot(email);
	}
	
	@Override
	@Transactional
	public void updateSlotStatus(String status, Long id) {
		repo.updateSlotStatus(status, id);
		Long appId = repo.findById(id).get().getAppointment().getId();
		
		if(status.equalsIgnoreCase(SlotStatus.ACCEPTED.name()))
			apmtService.setSlotCountMinus(appId);
		
		if(status.equalsIgnoreCase(SlotStatus.CANCELLED.name()))
			apmtService.setSlotCountPlus(appId);
	
	}

}
