package com.shaikh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shaikh.model.SlotRequest;

public interface ISlotRequestRepo extends JpaRepository<SlotRequest, Long> {

}
