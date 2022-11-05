package com.wellsfargo.training.rockblack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.wellsfargo.training.rockblack.model.ItemMaster;

import com.wellsfargo.training.rockblack.service.ItemMasterService;

@RestController
@RequestMapping(value="/api")
public class ItemMasterController {
	
	@Autowired
	private ItemMasterService imService;
	
	
	@PostMapping("/Item")
	public ItemMaster itemMastDetail(@Validated @RequestBody ItemMaster item) {
		
		ItemMaster im=new ItemMaster();
		
		im.setItemId(item.getItemId());
		im.setItemDescription(item.getItemDescription());
		im.setItemStatus(item.getItemStatus());
		im.setItemMake(item.getItemMake());
		im.setItemCategory(item.getItemCategory());
		im.setItemValuation(item.getItemValuation());
		
		
		im=imService.itemMasterDetail(im);
		return item;
	}
	
	@GetMapping("/allItem")
	public List<ItemMaster> getAllItemMaster(){
		return imService.getAllItemMaster();
	}

}
