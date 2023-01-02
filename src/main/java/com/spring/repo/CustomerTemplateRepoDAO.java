package com.spring.repo;

import java.util.List;
import java.util.Optional;

public interface CustomerTemplateRepoDAO<T> {

	List<T> listAll();

	void add(T t);

	Optional<T> get(int id);

	void update(T t, int id);

	void delete(int id);

}
