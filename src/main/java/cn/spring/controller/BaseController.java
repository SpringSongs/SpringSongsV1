package cn.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import cn.spring.domain.SpringUser;
import cn.spring.security.MyUserPrincipal;
import cn.spring.security.UserSecurityService;

public class BaseController {

	protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	private UserSecurityService userSecurityService;

	public SpringUser getUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		boolean caseFlag = false;
		MyUserPrincipal userDetails = null;
		User user = null;
		try {
			user = (User) authentication.getPrincipal();
		} catch (Exception ex) {
			caseFlag = true;
			userDetails = (MyUserPrincipal) authentication.getPrincipal();

		}
		if (!caseFlag) {
			userDetails = (MyUserPrincipal) userSecurityService.loadUserByUsername(user.getUsername());
		}
		return userDetails.getBaseEntityUser();
	}
}
