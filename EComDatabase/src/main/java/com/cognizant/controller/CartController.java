package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Cart;
import com.cognizant.repository.CartRepository;
import com.sun.media.jfxmedia.logging.Logger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CartController {

	@Autowired
	CartRepository cartRepository;

	@GetMapping("/cart/add")
	public String addCart(@RequestParam("id") Integer id) {
		log.debug("Adding item in the cart", "START");
		Cart cart = new Cart();
		cart.setUserid("user");
		cart.setId(id);
		cartRepository.save(cart);
		log.debug("The new item in the cart", cart);
		log.debug("Adding item in the cart", "END");
		return "Added";

	}

	@GetMapping("/cart/all")
	public List<Cart> GetAllCartItems(@RequestParam("userid") String userid) {
		log.debug("Get all cart items","START");
		List<Cart> findAll = cartRepository.findByUserid(userid);
		log.debug("List of items",findAll);
		log.debug("Get all cart items","END");
		return findAll;

	}

	
	@GetMapping("cart/delete")
	public String deleteItem(@RequestParam("id") Integer id) {
		log.debug("Delete Cart Items","START");
		cartRepository.deleteByMenuId(id);
		log.debug("Delete Cart Items","END");
		return "Deleted";
	}
}
