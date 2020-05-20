package com.hrtek;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HRtekApplication {

	public static void main(String[] args) {
		//TimeZone tzone = TimeZone.getTimeZone("Asia/Calcutta");
		TimeZone tzone = TimeZone.getTimeZone("GMT+02");
		//TimeZone.setDefault(tzone);
		TimeZone.setDefault(tzone);
		SpringApplication.run(HRtekApplication.class, args);
	}

}
