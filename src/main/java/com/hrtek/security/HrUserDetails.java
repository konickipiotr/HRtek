package com.hrtek.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hrtek.enums.UserStatus;
import com.hrtek.model.User;

public class HrUserDetails implements UserDetails {
	private static final long serialVersionUID = -5154501967228376837L;
	private User user;

	public HrUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+ user.getRoles());
		if(user.getStatus() == UserStatus.ACTIVE) {
			authorities.add(new SimpleGrantedAuthority("ACCESS_" + "ACTIVE"));
		}else if(user.getStatus() == UserStatus.FIRSTLOGIN) {
			authorities.add(new SimpleGrantedAuthority("ACCESS_" + "FIRSTLOGIN"));
		}
		authorities.add(authority);
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.getStatus() == UserStatus.ACTIVE || user.getStatus() == UserStatus.FIRSTLOGIN;
	}
}
