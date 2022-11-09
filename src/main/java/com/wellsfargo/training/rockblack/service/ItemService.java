package com.wellsfargo.training.rockblack.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.rockblack.repository.ItemRepository;
import com.wellsfargo.training.rockblack.model.Item;


@Service
@Transactional
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public Item itemRegister(Item item) {
		return itemRepository.save(item);
	}
	
	public List<Item> getAllItem(){
		return itemRepository.findAll();
	}

	public Item get(long id)
	{
		return itemRepository.findById(id).get();
	}

}
