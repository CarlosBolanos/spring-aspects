package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {
//    private static SentryClient sentry;

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
//        Sentry.init();

        try {
            var body = Arrays.asList(
                    new Book(1, "Mastering Spring 5.1", "Carlos Bolanos")
            );

            return new ResponseEntity<List<Book>>(body, HttpStatus.ACCEPTED);

        } catch(Exception ex){
            LOGGER.info("{}", ex.getStackTrace().toString());
        }

        return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
