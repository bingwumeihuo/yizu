package com.yizu.house;

import com.yizu.common.util.IdWorker;
import com.yizu.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseApplication.class, args);
	}
	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}

}
