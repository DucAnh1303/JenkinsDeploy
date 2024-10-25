package com.service.jenkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/all")
    public List<String> getAll(){
        return Arrays.asList("a","b","c","d","e","f");
    }
}
