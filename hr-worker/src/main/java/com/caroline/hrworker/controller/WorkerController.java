package com.caroline.hrworker.controller;

import com.caroline.hrworker.entity.Worker;
import com.caroline.hrworker.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> get(){
         return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> getById(@PathVariable Long id){
        return ResponseEntity.ok(repository.findById(id).get());
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs(){
        return ResponseEntity.noContent().build();
    }
}
