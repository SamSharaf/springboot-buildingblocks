package com.stacksimplify.restservices.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  // URI - /helloworld
//  @RequestMapping(method= RequestMethod.GET, path="/helloworld")
  @GetMapping("/helloworld2")
  public String helloWorld(){
    return "Hello world";
  }

  @GetMapping("/helloWorldBean")
  public UserDetails helloWorldBean(){
    return new UserDetails("Kaylan", "Reddy", "Hyderabad");
  }
}
