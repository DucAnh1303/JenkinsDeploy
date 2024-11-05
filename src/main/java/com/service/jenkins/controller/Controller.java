package com.service.jenkins.controller;

import com.service.jenkins.entity.ManageEntity;
import com.service.jenkins.request.ManageRequest;
import com.service.jenkins.service.ManageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manage")
@RequiredArgsConstructor
public class Controller {

    private final ManageService manageService;


    @GetMapping("/search")
    public ResponseEntity<?> getAll(@RequestBody ManageEntity search) {
        return new ResponseEntity<>(manageService.findAll(search), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(manageService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> save( @RequestBody @Valid ManageRequest request) {
        return new ResponseEntity<>(manageService.created(request), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ManageRequest search) {
        return new ResponseEntity<>(manageService.update(search), HttpStatus.OK);
    }
}
