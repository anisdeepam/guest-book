package com.guestbook.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.guestbook.constants.GuestBookAppConstants;
/**
 * GuestBook Main Application
 * @author Anis Deepa
 *
 */
@EnableJpaRepositories(basePackages={GuestBookAppConstants.GUEST_BOOK_REPO})
@ComponentScan(basePackages={GuestBookAppConstants.GUEST_BOOK})
@EntityScan(GuestBookAppConstants.GUEST_BOOK_ENTITY)
@SpringBootApplication
public class GuestBookApplication {
	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(GuestBookApplication.class);
		log.info("GuestBook Application Started");
		SpringApplication.run(GuestBookApplication.class, args);
	}

}
