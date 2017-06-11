package com.audit.app.customer;

import com.audit.app.customer.AuthFilter.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuditAppCustomer
{

	@Bean
	@Autowired
	public FilterRegistrationBean authApiFilter(AuthFilter authFilter) {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new AuthFilter());
		registration.addUrlPatterns("/nothing/auth/*");
		return registration;
	}

	@Bean
    public AuthFilter authFilter(){
	    return new AuthFilter();
    }

	public static void main(String[] args) {
		SpringApplication.run(AuditAppCustomer.class, args);
	}
}
