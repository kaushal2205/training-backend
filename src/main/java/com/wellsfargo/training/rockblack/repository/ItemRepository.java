package com.wellsfargo.training.rockblack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.rockblack.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
	

}