package jp.co.sunarch.skillmgr;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SkillMgrApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillMgrApiApplication.class, args);

		Log logger = LogFactory.getLog(SkillMgrApiApplication.class);
		logger.info("★★★★★★★★★★★★★★★★★");
	}

}
