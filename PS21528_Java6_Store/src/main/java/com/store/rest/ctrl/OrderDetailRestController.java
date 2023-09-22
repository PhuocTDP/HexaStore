package com.store.rest.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.entity.OrderDetail;
import com.store.service.OrderDetailService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orderdetais")
public class OrderDetailRestController {
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@GetMapping("{id}")
	public OrderDetail getOne(@PathVariable("id") Long id) {
		return orderDetailService.findById(id);
	}

}
