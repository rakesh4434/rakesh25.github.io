package com.infor.newsApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
	@author 1822780
*/

@SpringBootApplication
public class NewsAppliactionApplication {
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(NewsAppliactionApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(NewsAppliactionApplication.class, args);
		
		/*
		 * LOGGER.error("Message logged at error level");
		 * LOGGER.warn("Message logged at warn level");
		 * LOGGER.info("Message logged at info level");
		 * LOGGER.debug("Message logged at debug level");
		 */
	}
	
	

}
 