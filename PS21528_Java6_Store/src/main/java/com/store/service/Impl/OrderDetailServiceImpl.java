package com.store.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.DAO.OrderDetailDAO;
import com.store.entity.OrderDetail;
import com.store.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	OrderDetailDAO orderDetailDAO;

	@Override
	public OrderDetail findById(Long id) {
		return orderDetailDAO.findById(id).get();
	}
	

}
