package com.spring.web.mvc.service;

import java.util.List;

import com.spring.web.mvc.controller.model.Login;
import com.spring.web.mvc.model.Customer;

public interface ICustomerService {

	List<Customer> getCustomers();

	Customer findCustomerByEmail(String email);

	String deleteCustomerByEmail(String email);

	void save(Customer customer);

	String updateCustomer(Customer customer);

	String validateUser(Login login);

	String deleteCustomerByCid(int cid);

}
