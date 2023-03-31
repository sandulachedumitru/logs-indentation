package com.hardcodacii.logsindentation.demo;

import com.hardcodacii.logsindentation.service.DisplayService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@RequiredArgsConstructor
@ComponentScan("com.hardcodacii.logsindentation")
public class LogsIndentationApplication implements CommandLineRunner {
	private final MainService mainService;
	private final DisplayService displayService;

	public static void main(String[] args) {
		SpringApplication.run(LogsIndentationApplication.class, args);
	}

	@Override
	public void run(String... args) {
		mainService.start();
		displayService.infoLn("exit method DemoPrintApplication.run");
	}
}
