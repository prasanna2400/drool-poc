package org.beehyv.web;


import org.beehyv.models.HelloWorld;
import org.beehyv.service.DroolTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    DroolTestService service;


    @PostMapping("/message")
    ResponseEntity<?>sendMessage (@RequestBody HelloWorld helloWorld){
      HelloWorld response=  service.printMessage(helloWorld);
        return ResponseEntity.ok(response);
    }
}
