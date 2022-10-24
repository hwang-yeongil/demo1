package sample.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.demo1.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
}
