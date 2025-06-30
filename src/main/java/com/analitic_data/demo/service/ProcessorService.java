package com.analitic_data.demo.service;

import com.analitic_data.demo.dto.ResponseSuperUsers;
import com.analitic_data.demo.dto.UserDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Stream;

@Service
public class ProcessorService {

    static final File file = new File("usuarios_1000.json");
    static final File totalFile = new File("usuarios.json");
    List<UserDTO> database = new ArrayList<>();


    public List<UserDTO> loadData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<UserDTO>> typeReference = new TypeReference<List<UserDTO>>(){};
        try {
            database = mapper.readValue(file, typeReference);
            return database;
        }catch (IOException e){
            throw new IOException(e);
        }
    }
    public ResponseSuperUsers superUsers(){
        long init = System.currentTimeMillis();
        List<UserDTO> filtredList = database.stream()
                .filter(userDTO -> (userDTO.score() >= 900 && userDTO.active()))
                .toList();

        long end = System.currentTimeMillis();
        String seconds = String.format("%.8f ms", (end - init) / 1000.0);
        return new ResponseSuperUsers(filtredList, seconds);
    }
    //    public List<> topCountries(){
//        this.nullDatabase();
//        List<UserDTO> filtredList = database.stream()
//                .filter(userDTO -> (userDTO.score() >= 900 && userDTO.active()))
//                .toList();
//        return
//    }

}
