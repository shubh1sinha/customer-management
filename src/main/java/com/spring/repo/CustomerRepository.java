package com.spring.repo;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	@Query("Insert into customer values(:customerId, :name)")
	void insertData(int customerId, String name);


}
