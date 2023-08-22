package com.jionek.CRUDPeople;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@RestController
@SpringBootApplication
public class CrudPeopleApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(CrudPeopleApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(new Locale("en", "US"));
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor(){
		return new LocaleChangeInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
}
