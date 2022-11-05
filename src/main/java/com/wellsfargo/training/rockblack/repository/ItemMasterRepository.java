package com.wellsfargo.training.rockblack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.rockblack.model.ItemMaster;

public interface ItemMasterRepository extends JpaRepository<ItemMaster, Long> {
	
	

}