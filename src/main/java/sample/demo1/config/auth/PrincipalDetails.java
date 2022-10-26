package sample.demo1.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Data;
import sample.demo1.domain.DUser;
@Data
public class PrincipalDetails implements UserDetails, OAuth2User{
	private DUser user;
	private Map<String , Object> attributes;
	
	public PrincipalDetails(DUser user) {
		this.user = user;
	}
	public PrincipalDetails(DUser user, Map<String , Object> attributes) {
		this.user = user;
		this.attributes = attributes;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				// TODO Auto-generated method stub
				return user.getRole();
			}
		});
		return collect;
	}
	@Override
    public String getPassword() { // User 비밀번호 리턴
        return user.getPassword();
    }

    @Override
    public String getUsername() { // User PK 또는 고유한 값을 리턴
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() { // User 계정 만료 여부 리턴
        return true; // true : 만료 안됨
    }

    @Override
    public boolean isAccountNonLocked() { // User 계정 잠김 여부 리턴
        return true; // treu : 잠기지 않음
    }

    @Override
    public boolean isCredentialsNonExpired() { // User 비밀번호 만료 여부 리턴
        return true; // true : 만료 안됨
    }

    @Override
    public boolean isEnabled() { // User 계정 활성화 여부 리턴
        return true; // true : 활성화 됨
    }

    // === OAuth2User 메서드 === //
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return null;
    }
}
