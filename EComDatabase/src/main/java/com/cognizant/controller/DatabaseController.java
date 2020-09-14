package com.cognizant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Menu;
import com.cognizant.repository.DatabaseRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DatabaseController {

	@Autowired
	DatabaseRepository databaseRepository;

	@GetMapping("/database/id/{i}")
	public Optional<Menu> getMenu(@PathVariable Integer i) {
		log.debug("Get Menu","START");
		Optional<Menu> menu = databaseRepository.findById(i);

		log.debug("The menu",menu);
		log.debug("Get Menu","End");
		return menu;
	}

	@GetMapping("/database/all")
	public List<Menu> getMenus() {
		log.debug("Get all menus for admin","START");
		List<Menu> findAll = databaseRepository.findAll();

		log.debug("List of menus",findAll);
		log.debug("Get all menus for admin","END");
		return findAll;
	}

	@GetMapping("/database/allitems")
	public List<Menu> getMenusCustomers() {
		log.debug("Get all menus for customer","START");
		List<Menu> findAll = databaseRepository.findAllCustomer();

		log.debug("List of menus",findAll);
		log.debug("Get all menus for customer","END");
		return findAll;
	}


	@GetMapping("/database/edit")
	public String editMenu(@RequestParam("id") Integer id, @RequestParam("pic") String pic,

			@RequestParam("name") String name, @RequestParam("price") float price,

			@RequestParam("active") boolean active, @RequestParam("category") String category,

			@RequestParam("freedelivery") boolean freedelivery) {
		
		log.debug("Edit Menu","START");
		databaseRepository.updateMenu(id, pic, name, price, active, category, freedelivery);
		log.debug("Edit Menu","END");
		return "Item Updated Successfully";
	}
	
	
	@GetMapping("database/delete")
	public String deleteItem(@RequestParam("id") Integer id) {
		log.debug("Delete Menu","START");
		databaseRepository.deleteItem(id);
		log.debug("Delete Menu","START");
		return "Item deleted Successfully";
	}

	@GetMapping("database/add")
	public String addItem(@RequestParam("pic") String pic, @RequestParam("name") String name,
			@RequestParam("price") float price, @RequestParam("active") boolean active,
			@RequestParam("category") String category, @RequestParam("freedelivery") boolean freedelivery) {
		log.debug("Add Menu","START");
		Menu m = new Menu();
		m.setPic(pic);
		m.setPrice(price);
		m.setName(name);
		m.setActive(active);
		m.setFreedelivery(freedelivery);
		m.setCategory(category);
		log.debug("The new items",m);

		databaseRepository.save(m);
		log.debug("Add Menu","END");
		return "Item added successfully";
	}

}
