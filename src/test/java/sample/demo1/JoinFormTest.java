package sample.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sample.demo1.domain.DUser;
import sample.demo1.repository.UserRepository;

public class JoinFormTest {
	
	UserRepository userRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Test
	public void join() {
		DUser duser = new DUser();
		duser.setUsername("aaa");
		duser.setPassword("aaa");
		duser.setEmail("aaa@aaa.aaa");
		
		System.out.println(duser);
        duser.setRole("ROLE_USER");
        String rawPassword = duser.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        duser.setPassword(encPassword);
        userRepository.save(duser);
	}
}
