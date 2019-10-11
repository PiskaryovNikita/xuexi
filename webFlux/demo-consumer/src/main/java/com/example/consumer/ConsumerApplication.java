package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);

    WebClient webClient = WebClient.create("http://localhost:8080");

    webClient.get()
        .uri("/hello")
        .accept(MediaType.TEXT_PLAIN)
        .exchange()
        .flatMap(resp -> resp.bodyToMono(String.class))
        .subscribe(System.out::println);


  }

}
