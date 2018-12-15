package com.spring.web.mvc.dao;

import java.util.List;

import com.spring.web.mvc.dao.entity.CustomerEntity;
import com.spring.web.mvc.dao.entity.LoginEntity;

public interface ICustomerDao {

	String validateUser(LoginEntity entity);

	String updateCustomer(CustomerEntity customer);

	List<CustomerEntity> getCustomers();

	String deleteCustomerByEmail(String email);

	CustomerEntity findCustomerByEmail(String email);

	void save(CustomerEntity customer);

}
