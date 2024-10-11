package com.capgemini.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(ConfigServerApplication.class, args);
		final DateFormat df = new SimpleDateFormat("yy-MM-dd");


		Date date =java.sql.Date.valueOf("2013-09-04");

	}

}
