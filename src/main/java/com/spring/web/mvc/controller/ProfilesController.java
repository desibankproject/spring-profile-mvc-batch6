package com.spring.web.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.web.mvc.controller.model.Profile;
import com.spring.web.mvc.model.Customer;
import com.spring.web.mvc.service.CustomerService;

@Controller
public class ProfilesController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(HttpServletRequest request){
		String email=request.getParameter("email");
		customerService.deleteCustomerByEmail(email);
		
		//Show remaining data now
		List<Customer> customers=customerService.getCustomers();
		request.setAttribute("customers",customers);
		return "showCustomers"; //welcome.jsp
	}
	
	@GetMapping("/show-data")
	public String showData(HttpServletRequest request){
		List<Customer> customers=customerService.getCustomers();
		request.setAttribute("customers",customers);
		return "showCustomers"; //welcome.jsp
	}
	
	
	
	@PostMapping("/add-profile")
	public String addProfile(HttpServletRequest request){
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String mobile=request.getParameter("mobile");
		String city=request.getParameter("city");
		String photo=request.getParameter("photo");
		
		Profile profile=new Profile(name, email, gender, city, mobile,photo);
		request.setAttribute("profile",profile);
		return "reviewProfile"; //welcome.jsp
	}
	
	
	@PostMapping("/save-review-profile")
	public String saveReviewProfile(HttpServletRequest request){
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String mobile=request.getParameter("mobile");
		String city=request.getParameter("city");
		String photo=request.getParameter("photo");
		
		//Profile profile=new Profile(name, email, gender, city, mobile,photo);
		Customer customer = new Customer(name, email, gender, city, mobile,photo);
		///Here we have to write code to save data into database
		customerService.save(customer);
		
		
		//request.setAttribute("profile",profile);
		List<Customer> customers=customerService.getCustomers();
		request.setAttribute("customers",customers);
		return "showCustomers"; //welcome.jsp
	}
}
