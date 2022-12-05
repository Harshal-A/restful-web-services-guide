package com.spring.rest.controller;

import com.spring.rest.models.PersonV1;
import com.spring.rest.models.PersonV1;
import com.spring.rest.models.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 firstVersionOfPerson(){
        return new PersonV1("Bob Marley");
    }

    @GetMapping("/v2/person")
    public PersonV2 secondVersionOfPerson(){
        return new PersonV2("Bob", "Marley");
    }

    @GetMapping(value = "/person",params = "version=1")
    public PersonV1 firstVersionOfPersonRequestParameter(){
        return new PersonV1("Bob Marley");
    }

    @GetMapping(value = "/person",params = "version=2")
    public PersonV2 secondVersionOfPersonRequestParameter(){
        return new PersonV2("Bob", "Marley");
    }

    @GetMapping(value = "/person/header",headers = "X-API-VERSION=1")
    public PersonV1 firstVersionOfPersonRequestHeaders(){
        return new PersonV1("Bob Marley");
    }

    @GetMapping(value = "/person/header",headers = "X-API-VERSION=2")
    public PersonV2 secondVersionOfPersonRequestHeaders(){
        return new PersonV2("Bob", "Marley");
    }

    @GetMapping(value = "/person/accept",produces ="application/vnd.company.app-v1+json" )
    public PersonV1 firstVersionOfPersonAcceptHeader(){
        return new PersonV1("Bob Marley");
    }

    @GetMapping(value = "/person/accept",produces = "application/vnd.company.app-v2+json")
    public PersonV2 secondVersionOfPersonAcceptHeaders(){
        return new PersonV2("Bob", "Marley");
    }
}
