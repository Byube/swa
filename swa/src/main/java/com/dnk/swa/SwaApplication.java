package com.dnk.swa;

import javax.servlet.http.HttpSessionListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.dnk.swa.session.SwasessionCheck;

@SpringBootApplication
public class SwaApplication extends SpringBootServletInitializer{

	
	public static void main(String[] args) {
		SpringApplication.run(SwaApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(SwaApplication.class);
	}

	@Bean
	public HttpSessionListener httpSessionListener() {
		return new SwasessionCheck();
	}
	
	

}
  