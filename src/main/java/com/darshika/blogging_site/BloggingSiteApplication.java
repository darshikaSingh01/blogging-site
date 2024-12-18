package com.darshika.blogging_site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.darshika.blogging_site.repository")
public class BloggingSiteApplication {
	public static void main(String[] args) {
		SpringApplication.run(BloggingSiteApplication.class, args);
	}
}
