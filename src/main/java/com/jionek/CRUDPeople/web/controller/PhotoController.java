//package com.jionek.CRUDPeople.web.controller;
//
//import com.jionek.CRUDPeople.business.model.Person;
//import com.jionek.CRUDPeople.business.service.PersonService;
//import com.jionek.CRUDPeople.data.FileStorageRepository;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import lombok.extern.log4j.Log4j2;
//
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/photo/")
//@Log4j2
//public class PhotoController {
//
//    public static final String DISPO = """
//             attachment; filename="%s"
//            """;
//    private FileStorageRepository fileStorageRepository;
//    private PersonService personRepository;
//
//
//    @GetMapping("/images/{resourcePath}")
//    public ResponseEntity<Resource> getPhoto(@PathVariable String resourcePath){
//        return ResponseEntity
//                .ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, String.format(DISPO, resourcePath))
//                .body(fileStorageRepository.findByName(resourcePath));
//    }
//
//}
