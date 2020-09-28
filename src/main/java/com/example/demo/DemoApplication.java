package com.example.demo;

import com.example.demo.aop.business.BarService;
import com.example.demo.aop.business.FooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	final
	FooService fooService;

	final
	BarService barService;

	public DemoApplication(FooService fooService, BarService barService) {
		this.fooService = fooService;
		this.barService = barService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var foo = fooService.calculateSomething();
		var bar = barService.calculateSomething();
		LOGGER.info("Foo {}", foo);
		LOGGER.info("Bar {}", bar);
	}
}
