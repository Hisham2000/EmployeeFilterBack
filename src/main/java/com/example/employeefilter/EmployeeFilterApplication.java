package com.example.employeefilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeFilterApplication.class, args);
		System.out.println(
				"  ______                       _                                   ______   _   _   _                 \n" +
				" |  ____|                     | |                                 |  ____| (_) | | | |                \n" +
				" | |__     _ __ ___    _ __   | |   ___    _   _    ___    ___    | |__     _  | | | |_    ___   _ __ \n" +
				" |  __|   | '_ ` _ \\  | '_ \\  | |  / _ \\  | | | |  / _ \\  / _ \\   |  __|   | | | | | __|  / _ \\ | '__|\n" +
				" | |____  | | | | | | | |_) | | | | (_) | | |_| | |  __/ |  __/   | |      | | | | | |_  |  __/ | |   \n" +
				" |______| |_| |_| |_| | .__/  |_|  \\___/   \\__, |  \\___|  \\___|   |_|      |_| |_|  \\__|  \\___| |_|   \n" +
				"                      | |                   __/ |                                                     \n" +
				"                      |_|                  |___/                                                      \n"
				);
	}

}
