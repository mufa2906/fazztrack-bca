package id.tokobukufarhan.library.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class GreetingController {
  @GetMapping
  public String getGreeting() {
    return "Hello World!";
  }

  @GetMapping("/2")
  public String getGreeting(@RequestParam String name) {
    return "Hello "+name+"! dari request param";
  }

  @GetMapping("/2/{name}")
  public String getGreeting2(@PathVariable String name) {
    return "Hello "+name+"! dari path variable";
  }

  @PostMapping("/3")
  public String getGreeting3(@RequestBody String name) {
    return "Hello "+name+"! dari request body";
  }

}
