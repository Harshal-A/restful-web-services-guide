package com.spring.rest.controller;

import com.spring.rest.models.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/hello-world/{name}")
    public HelloWorldBean sayHelloBean(@PathVariable(name = "name") String name){
        return new HelloWorldBean("Hello from Hello World bean : "+name);
    }

    @GetMapping("/hello-internationalized")
    public String sayHelloInternalionalized(){

        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"default message",locale);
    }
}
