package sample.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.demo1.domain.DUser;

public interface UserRepository extends JpaRepository<DUser, Integer>{
	public DUser findByUsername(String username);
}
