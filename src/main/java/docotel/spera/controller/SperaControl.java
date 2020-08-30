/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.controller;

import docotel.spera.models.Grade;
import docotel.spera.models.Position;
import docotel.spera.repositories.GradeRepository;
import docotel.spera.repositories.PositionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author rakhadjo
 */
@RestController
@RequestMapping("/api")
public class SperaControl {
    
    @Autowired
    private PositionRepository positionRepo;
    
    @Autowired
    private GradeRepository gradeRepo;
    
    @GetMapping("/troops/positions")
    public ResponseEntity<List> allPositions(@RequestHeader("Authentication") String Authentication) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-trace-id", "x-trace-id");
        return new ResponseEntity<>(positionRepo.findAll(), headers, HttpStatus.OK);
    }
    
    @GetMapping("/troops/grades")
    public ResponseEntity<List> allGrades() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-trace-id", "x-trace-id");
        return new ResponseEntity<>(gradeRepo.findAll(), headers, HttpStatus.OK);
    }
}
