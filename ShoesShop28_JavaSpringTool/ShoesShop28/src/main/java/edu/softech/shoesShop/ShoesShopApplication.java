package edu.softech.shoesShop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import edu.softech.shoesShop.config.StorageProperties;
import edu.softech.shoesShop.service.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ShoesShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoesShopApplication.class, args);
	}
	//7
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args->{
			storageService.init();
		});
	}

}
