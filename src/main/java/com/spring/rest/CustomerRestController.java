package com.spring.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Customer;
import com.spring.service.CustomerServiceDAO;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	private CustomerServiceDAO customerService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
		String response =customerService.addCustomer(customer);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/list")
	public List<Customer> listAllCustomer(){
		return customerService.listAllCustomer();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") int id){
		return customerService.getCustomer(id);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer, @PathVariable("id") int id){
		String response =customerService.updateCustomer(customer, id);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer( @PathVariable("id") int id){
		String response =customerService.deleteCustomer(id);
		return ResponseEntity.ok(response);
		
	}
	
}
