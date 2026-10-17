package com.learning.springbasics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world")
    public String helloWorld() {
        return "Hello World !!!";
    }

    @GetMapping("/person")
    public String helloName(@RequestParam("name") String name) {
        return "Hello " + name + " !!!";
    }

    @GetMapping("/person/{name}")
    public String helloPerson(@PathVariable("name") String name) {
        return "Hello Person " + name + " !!!";
    }

}