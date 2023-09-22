package com.store.Ctrl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.DAO.ProductDAO;
import com.store.entity.Product;
import com.store.service.ProductService;
import com.store.utils.SessionService;



@Controller
public class ProductCtrl {
	
	@Autowired 
	ProductService productService;
	
	@Autowired
	ProductDAO dao;
	
	SessionService sessionService;
	
	@RequestMapping("/product/list")
	public String list(Model model, @RequestParam("cid") Optional<String> cid) {
		if (cid.isPresent()) {
			List<Product> list = productService.findByCategoryId(cid.get());
			model.addAttribute("items", list);
		}else {
			List<Product> list = productService.findAll();
			model.addAttribute("items", list);
		}
		return "product/list";
	}
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product item = productService.findById(id);
		model.addAttribute("item",item);
		return "product/detail";
	}
	
	@RequestMapping("/product/search")
	public String searchAndPage(Model model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		if (kw.isPresent()) {
			List<Product> list = dao.findByKeywords(kw.get());
			model.addAttribute("items", list);
		}else {
			List<Product> list = productService.findAll();
			model.addAttribute("items", list);
		}
//		String kwords = kw.orElse(sessionService.get("keywords"));
//		sessionService.set("keywords", kwords);
//		Pageable pageable = PageRequest.of(p.orElse(0), 9);
//		Page<Product> page = dao.findByKeywords("%" + kwords + "%", pageable);
//		model.addAttribute("page", page);
		return "product/list";
	}
}
