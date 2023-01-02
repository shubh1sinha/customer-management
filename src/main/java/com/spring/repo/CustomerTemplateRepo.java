package com.spring.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.entity.Customer;

@Repository
public class CustomerTemplateRepo implements CustomerTemplateRepoDAO<Customer> {

	@Autowired
	private JdbcTemplate template;
	

	RowMapper<Customer> rowMapper = (rs, rowNum) -> {
		Customer customer = new Customer();
		customer.setCustomerId(rs.getInt("customerid"));
		customer.setName(rs.getString("name"));
		customer.setAge(rs.getInt("age"));
		customer.setEmail(rs.getString("email"));
		customer.setPhone(rs.getString("phone"));
		return customer;
	};

	@Override
	public List<Customer> listAll() {
		String sql = "Select * from customer";
		return template.query(sql, rowMapper);
	}

	@Override
	public void add(Customer customer) {
		String sql = "Insert into customer(name, age, email, phone) values(?,?,?,?)";
		template.update(sql, customer.getName(), customer.getAge(), customer.getEmail(), customer.getPhone());

	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Customer> get(int id) {
		String sql = "Select * from customer where customerid = ?";
		Customer customer = null;
		try {
			customer = template.queryForObject(sql, new Object[]{id}, rowMapper);
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(customer);
	}

	@Override
	public void update(Customer customer, int id) {
		
		String sql = "Update customer set name=?, email=?, age= ?, phone=? where customerid=?";
		template.update(sql, customer.getName(), customer.getEmail(), customer.getAge(), customer.getPhone(), id);
	}

	@Override
	public void delete(int id) {	
			template.update("delete from customer where customerid=?", id);	
	}

}
