package es.hiberus.hotel;

import java.net.InetAddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiHotelesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiHotelesApplication.class, args);
		try {
			InetAddress host = InetAddress.getLocalHost();
			String hostName = host.getHostName().toLowerCase();
			Integer serverPort = 8091;
			System.out.printf(
				"%n" +
				"¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯%n" +
				"          APP RUNNING%n" +
				"________________________________%n" + 
				"http://%s:%s/%n" + 
				"¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯%n",
				hostName, serverPort
			);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
