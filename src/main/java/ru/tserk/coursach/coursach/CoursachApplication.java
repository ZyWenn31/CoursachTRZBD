package ru.tserk.coursach.coursach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class CoursachApplication {

	public static void main(String[] args) {
		var i = SpringApplication.run(CoursachApplication.class, args);
		System.out.println(i.getApplicationName());
	}

}
