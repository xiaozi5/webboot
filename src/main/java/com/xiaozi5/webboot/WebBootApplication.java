package com.xiaozi5.webboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Import({WebBootConfig.class,MVCConfig.class})
@EnableAutoConfiguration
public class WebBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebBootApplication.class, args);
	}
}
