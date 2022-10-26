package sample.demo1.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String email;
	private String role; // 관리자 확인
	
	private String provider;
	private String providerId;
	@CreationTimestamp // insert 쿼리 시 현시간으로 생성
	private Timestamp createData;
	
	@Builder
	public DUser(String username,String password,String email,String role,String provider,String providerId,Timestamp createData) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.provider = provider;
		this.providerId = providerId;
		this.createData = createData;
	}

}
