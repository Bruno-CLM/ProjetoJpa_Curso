package io.github.brunoclm.configuration;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import io.github.brunoclm.annotations.ConfigProductionAnnotation;

@ConfigProductionAnnotation
public class ConfigProduction {

	@Value("${namedatabase}")
	private String nameDatabase;
	
	@Bean
	public CommandLineRunner informationProduction() {
		return args -> {
			System.out.println("\u001B[31m" + "*******************************************************************\r\n"
					+ "*** PRODUCTION mode.                                            ***\r\n"
					+ "*** ^^^^^^^^^^ 					                ***\r\n"
					+ "***                                                 		***\r\n"
					+ "*** IP:"+ InetAddress.getLocalHost().getHostAddress() +"                                             ***\r\n"
					+ "*** DATABASE: "+ nameDatabase +"                                     ***\r\n"
					+ "*******************************************************************");
		};
	}
	
}
