package com.learning.springbasics.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/hello")
public class HelloController {

    //1st Basic Hello World Controller
    // -> http://127.0.0.1:5454/hello/world
    @GetMapping("/world")
    public String helloWorld() {
        return "Hello World !!!";
    }

    //2nd Hello World Controller with Request Parameter
    // -> http://127.0.0.1:5454/hello/person?name=Abhay
    @GetMapping("/person")
    public String helloName(@RequestParam("name") String name) {
        return "Hello " + name + " !!!";
    }

    //3rd Hello World Controller with Path Variable
    // -> http://127.0.0.1:5454/hello/person/John
    @GetMapping("/person/{name}")
    public String helloPerson(@PathVariable("name") String name) {
        return "Hello Person " + name + " !!!";
    }

}