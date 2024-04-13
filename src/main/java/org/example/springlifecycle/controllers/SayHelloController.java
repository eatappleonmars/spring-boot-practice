package org.example.springlifecycle.controllers;

import org.example.springlifecycle.FilterInspector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {

    private final FilterInspector filterInspector;

    public SayHelloController(FilterInspector filterInspector){
        this.filterInspector = filterInspector;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        filterInspector.printRegisteredFilters();
        return String.format("Hello %s!", name);
    }
}
