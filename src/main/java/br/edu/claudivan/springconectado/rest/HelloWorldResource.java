package br.edu.claudivan.springconectado.rest;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.AbstractMap.*;
import java.util.Map.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldResource {

    @GetMapping
    public ResponseEntity<SimpleEntry> sayHelloWorld(@Param("name") String name) {
        SimpleEntry result = new SimpleEntry("message", "Hello World " + Optional.of(name).orElseGet(() -> "") + "!");
        return ResponseEntity.ok(result);
    }
}
