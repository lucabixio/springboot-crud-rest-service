package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoggerControllerConfig {
	
	@Bean
	public DataLoggerController dataLoggerController(){
		return new DataLoggerController(dataLogger());
	}

	@Bean 
	public DataLogger dataLogger(){
		return new DataLogger();
	}

}
