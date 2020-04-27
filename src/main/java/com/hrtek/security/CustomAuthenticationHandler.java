package com.hrtek.security;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class CustomAuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler {
	 
	 @Override
	 public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//	      String userTargetUrl = "/user/home";
//	      String adminTargetUrl = "/admin/home";
//	      String bossTargetUrl = "/boss/home";
		 String target = "/init";
	      Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
	      if (roles.contains("ROLE_ADMIN")) {
	         getRedirectStrategy().sendRedirect(request, response, target);
	      } else if (roles.contains("ROLE_USER")) {
	         getRedirectStrategy().sendRedirect(request, response, target);
	      } else if(roles.contains("ROLE_BOSS")) {
	    	  getRedirectStrategy().sendRedirect(request, response, target);
	      } else {
	         super.onAuthenticationSuccess(request, response, authentication);
	         return;
	      }
	   }
	}