package com.cognizant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.dao.AdminDao;
import com.cognizant.model.Cart;
import com.cognizant.model.Menu;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

	@Autowired
	AdminDao admin;


	
	@RequestMapping(value = "/login")
	public String home() {
		return "login";
	}

	
	@RequestMapping("/user")
	public String userDashboard() {
		return "customer";
	}

	@RequestMapping("/admin")
	public String adminDashboard() {
		return "admin";
	}
	
	

	@GetMapping("/admin/all")
	@ResponseBody
	public List<Menu> getAllAdminItems() {
		log.debug("Get Admin menu items","START");
		List<Menu> allMenus = admin.getAllMenus();
		log.debug("Get Admin menu items","END");
		return allMenus;
	}

	@RequestMapping("/adminadd")
	public String adminadd() {
		return "adminadd";
	}

	@GetMapping("admin/add")
	@ResponseBody
	public String addItem(@RequestParam("pic") String pic, @RequestParam("name") String name,
			@RequestParam("price") float price, @RequestParam("active") boolean active,
			@RequestParam("category") String category, @RequestParam("freedelivery") boolean freedelivery)
	{
		log.debug("Get Admin add menu item","START");
		 admin.addItem(pic, name, price, active, category, freedelivery);
		 log.debug("Get Admin add menu item","END");
		return "Successful";
	}

	@RequestMapping("/adminupdate")
	public String adminupdate() {
		return "adminupdate";
	}

	@GetMapping("/admin/edit")
	@ResponseBody
	public String editMenu(@RequestParam("id") Integer id, @RequestParam("pic") String pic,

			@RequestParam("name") String name, @RequestParam("price") float price,

			@RequestParam("active") boolean active, @RequestParam("category") String category,

			@RequestParam("freedelivery") boolean freedelivery) {

		log.debug("Get Admin edit menu items","START");
		String editMenu = admin.editMenu(id, pic, name, price, active, category, freedelivery);
		log.debug("Get Admin edit menu items","END");
		return editMenu;
	}

	@RequestMapping("/admindelete")
	public String admindelete() {
		return "admindelete";
	}

	@GetMapping("admin/delete")
	@ResponseBody
	public String deleteItem(@RequestParam("id") Integer id) {
		log.debug("Get Admin delete menu items","START");
		String deleteItem = admin.deleteItem(id);
		log.debug("Get Admin delte menu items","END");
		return deleteItem;
	}
	
	
	
	@RequestMapping("/getallcartitems")
	public String usercartitems() {
		return "getallcartitems";
	}
	
	@RequestMapping("/addcart")
	public String additemsintocart() {
		return "addcart";
	}
	
	@RequestMapping("/deletecart")
	public String deleteitemintocart() {
		return "deletecart";
	}
	
	
	
	@GetMapping("/user/all")
	@ResponseBody
	public List<Cart> getAllCustomerItems(@RequestParam("userid") String userid) {
		log.debug("Get user cart items","START");
		List<Cart> getAllCartItems = admin.GetAllCartItems(userid);
		log.debug("Get user cart items","END");
		return getAllCartItems;
	}

	@GetMapping("/usercart/add")
	@ResponseBody
	public String addCart(@RequestParam("id") Integer id)
	{
		log.debug("Get user add cart item","START");
		String addCart = admin.addCart(id);
		log.debug("Get user add cart item","END");
		return addCart;
	}
	
	@GetMapping("usercart/delete")
	@ResponseBody
	public String deleteCartItem(@RequestParam("id") Integer id) {
		log.debug("Get user delete cart item","START");
		String deleteCartItem = admin.deleteCartItem(id);
		log.debug("Get user delete cart item","end");
		return deleteCartItem;
	}
	
}
