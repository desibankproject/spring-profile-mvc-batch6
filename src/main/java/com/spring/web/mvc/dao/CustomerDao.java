package com.spring.web.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.web.mvc.dao.entity.CustomerEntity;
import com.spring.web.mvc.dao.entity.LoginEntity;


@Repository("CustomerDao")
public class CustomerDao {
	
	@Autowired
	@Qualifier("pjdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public String validateUser(LoginEntity entity){
		System.out.println("Before saving\n");
		String sql="select  username from logins_tbl where username=? and password=?";
		try {
			jdbcTemplate.queryForObject(sql,new Object[]{entity.getUsername(),entity.getPassword()},new BeanPropertyRowMapper(LoginEntity.class));	
		}catch(Exception ex){
			return "fail";
		}
		return "success";
	}

	public void save(CustomerEntity customer){
		System.out.println("Before saving\n");
		String sql="insert into customer_tbl(name,email,gender,mobile,photo,city) values(?,?,?,?,?,?)";
		Object data[] = new Object[]{customer.getName(),customer.getEmail(),customer.getGender(),customer.getMobile(),customer.getPhoto(),customer.getCity()};
		System.out.println(jdbcTemplate);
		jdbcTemplate.update(sql,data);	
		System.out.println("Completed saving");
	}
	
	public CustomerEntity findCustomerByEmail(String email){
		String sql="select sno,name,email,gender,mobile,photo,city from customer_tbl where email=?";
		CustomerEntity customerEntity=(CustomerEntity)jdbcTemplate.queryForObject(sql,new Object[]{email},new BeanPropertyRowMapper(CustomerEntity.class));	
		return customerEntity;
	}
	
	public String deleteCustomerByEmail(String email){
		String sql="delete from  customer_tbl where email=?";
		int row=jdbcTemplate.update(sql, new Object[]{email});	
		return "deleted";
	}
	
	public List<CustomerEntity> getCustomers(){
		List<CustomerEntity> customerList = new ArrayList<CustomerEntity>();
		String sql="select sno,name,email,gender,mobile,photo,city from customer_tbl";
		customerList=jdbcTemplate.query(sql, new BeanPropertyRowMapper(CustomerEntity.class));	
		return customerList;
	}

}
