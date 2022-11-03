package edu.softech.shoesShop.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SiteAuthenticationInterceptor {
	@Autowired
	private AdminAuthenticationInterceptor adminAuthenticationInterceptor;
	
}
