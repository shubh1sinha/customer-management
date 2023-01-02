package com.spring.service;

import java.util.List;
import java.util.Optional;

import com.spring.entity.Customer;

public interface CustomerServiceDAO{
	
	public List<Customer> listAllCustomer();
	
	public String addCustomer(Customer customer);
	
	public Optional<Customer> getCustomer(int id);
	
	public String updateCustomer(Customer customer, int id);
	
	public String deleteCustomer(int id);
	
	
}
