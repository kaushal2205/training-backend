package com.wellsfargo.training.rockblack.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.rockblack.repository.ItemMasterRepository;
import com.wellsfargo.training.rockblack.model.ItemMaster;


@Service
@Transactional
public class ItemMasterService {
	
	@Autowired
	private ItemMasterRepository itemMasterRepository;
	
	public ItemMaster itemMasterDetail(ItemMaster item) {
		return itemMasterRepository.save(item);
	}
	
	public List<ItemMaster> getAllItemMaster(){
		return itemMasterRepository.findAll();
	}

}
