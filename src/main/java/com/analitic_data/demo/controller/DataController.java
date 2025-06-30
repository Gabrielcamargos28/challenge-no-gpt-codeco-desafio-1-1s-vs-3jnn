package com.analitic_data.demo.controller;

import com.analitic_data.demo.dto.ResponseSuperUsers;
import com.analitic_data.demo.dto.UserDTO;
import com.analitic_data.demo.service.ProcessorService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

@RestController()
@RequestMapping("users")
public class DataController {

    @Autowired
    ProcessorService processorService;


    @PostMapping()
    public ResponseEntity<List<UserDTO>> readAndSaveInMemory() throws IOException {
        return ResponseEntity.ok(this.processorService.loadData());
    }
    @GetMapping("/superusers")
    public ResponseEntity<ResponseSuperUsers> superUsers(){
        return ResponseEntity.ok(processorService.superUsers());
    }
}
