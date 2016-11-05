package de.sebastianschmelcher.currencyConverter.Repositories;

import org.springframework.data.repository.CrudRepository;

import de.sebastianschmelcher.currencyConverter.Model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public User findByUsername(String username);
}