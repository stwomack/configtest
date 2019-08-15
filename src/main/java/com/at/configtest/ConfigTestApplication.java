package com.at.configtest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigTestApplication.class, args);
	}

	@RefreshScope
	@RestController
	class MessageRestController {

		@Value("${message}")
		private String message;

		@RequestMapping("/message")
		String getMessage() {
			System.out.println("MESSAGE CALLED");
			return this.message;
		}

		@RequestMapping("/wait")
		String timeout() throws InterruptedException {
			System.out.println("TIMEOUT CALLED");
			Thread.sleep(30000);
			return this.message;
		}

	}
}
