package com.templateproject.api.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.templateproject.api.filter.AuthFilter;
import com.templateproject.api.service.AuthService;

//@Configuration
//public class FilterConfig {
//	   @Bean
//	    public FilterRegistrationBean<AuthFilter> authFilterRegistration(AuthFilter authFilter) {
//	        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>(authFilter);
//	        registrationBean.addUrlPatterns("/auth/*"); // Ajustez les URL patterns en fonction de vos besoins
//	        return registrationBean;
//	    }
//
//	    @Bean
//	    public AuthFilter authFilter(AuthService authService) {
//	        return new AuthFilter(authService);
//	    }
//}
