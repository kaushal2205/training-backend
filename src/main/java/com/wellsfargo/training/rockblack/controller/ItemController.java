package com.wellsfargo.training.rockblack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.wellsfargo.training.rockblack.model.Item;

import com.wellsfargo.training.rockblack.service.ItemService;

@RestController
@RequestMapping(value="/api")
public class ItemController {
	
	@Autowired
	private ItemService imService;
	
	
	@PostMapping("/Item")
	public Item itemRegister(@Validated @RequestBody Item item) {
		
		Item im=new Item();
		
		im.setItemId(item.getItemId());
		im.setItemDescription(item.getItemDescription());
		im.setItemStatus(item.getItemStatus());
		im.setItemMake(item.getItemMake());
		im.setItemCategory(item.getItemCategory());
		im.setItemValuation(item.getItemValuation());
		
		
		im=imService.itemRegister(im);
		return item;
	}
	
	@GetMapping("/allItem")
	public List<Item> getAllItem(){
		return imService.getAllItem();
	}

}
