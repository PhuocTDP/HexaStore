package com.store.Ctrl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.store.DAO.AccountDAO;
import com.store.entity.Account;



@Controller
public class SecurityCtrl {
	
	@Autowired
	AccountDAO accountDAO;

//	@Autowired
//	AccountService accountService;
//	@RequestMapping("/oauth2/login/success")
//	public String success(OAuth2AuthenticationToken oauth2) {
//        accountService.loginFromOAuth2(oauth2);
//		return "forward:/security/login/success";
//	}
	
	
	@RequestMapping("/security/register")
	public String register(Model model) {
		Account item = new Account();
		model.addAttribute("item", item);
		return "security/register";
	}
	@RequestMapping("/register/create")
	public String create(Model model, Account item) {
		accountDAO.save(item);
		model.addAttribute("message", "Insert successfully");
		return "security/login";
	}
	
	
	@RequestMapping("/security/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập");
		return "security/login";
	}
	
	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công");
		return "security/login";
	}
	
	@RequestMapping("/security/login/error")
	public String loginError(Model model) {
		model.addAttribute("message", "Sai thông tin đăng nhập");
		return "security/login";
	}
	
	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message", "Không có quyền truy cập");
		return "security/login";
	}
	
	@RequestMapping("/security/logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message", "Đăng xuất thành công");
		return "security/login";
	}
	@CrossOrigin("*")
	@ResponseBody
	@RequestMapping("/rest/security/authentication")
	public Object getAuthentication(HttpSession session) {
		return session.getAttribute("authentication");
	}
}
