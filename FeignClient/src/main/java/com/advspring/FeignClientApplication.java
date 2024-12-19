package com.advspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignClientApplication {
	// Bu program SpringJPA projesini çağırarak çalışıyor. SpringJPA projesindeki 5
	// endpoint'in aynısı bu projeye de yazdık. Gelen parametreleri aynen SpringJPA
	// projesine gönderip, dönen cevabı da geri döndürüyor.
	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}

}
