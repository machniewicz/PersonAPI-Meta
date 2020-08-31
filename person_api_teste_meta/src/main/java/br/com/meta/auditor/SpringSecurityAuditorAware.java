package br.com.meta.auditor;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SpringSecurityAuditorAware implements AuditorAware<String>{

	public String getCurentAuditor(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	         
	      if (auth == null || ! auth.isAuthenticated()){
	         return null;
	      }
	      return((User) auth.getPrincipal()).getUsername();
	   }

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of(getCurentAuditor());
	}

}
