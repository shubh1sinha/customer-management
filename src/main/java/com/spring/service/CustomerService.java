package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Customer;
import com.spring.repo.CustomerTemplateRepoDAO;

@Service
public class CustomerService implements CustomerServiceDAO{

	
	@Autowired
	CustomerTemplateRepoDAO<Customer> customerRepo;

	@Override
	public List<Customer> listAllCustomer() {
		return customerRepo.listAll();
	}

	@Override
	public String addCustomer(Customer customer) {
		 customerRepo.add(customer);
		 return "Customer with "+customer.getName()+" added successfully.";
	}

	@Override
	public Optional<Customer> getCustomer(int id) {
		return customerRepo.get(id);
	}

	@Override
	public String updateCustomer(Customer customer, int id) {
		if(customerRepo.get(id).isPresent()) {
		 customerRepo.update(customer, id);
		 return "Customer with "+id+" updated successfully.";
		}
		else {
			return "Customer with id not found";
		}
	}

	@Override
	public String deleteCustomer(int id) {
		if(customerRepo.get(id).isPresent()) {
			customerRepo.delete(id);
			return "Customer with id="+id+" deleted.";
		}
		else {
			return "Customer not found";
		}

	}

	
	
}
