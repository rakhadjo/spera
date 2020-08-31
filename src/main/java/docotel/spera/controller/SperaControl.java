/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.controller;

import docotel.spera.models.Troop;
import docotel.spera.repositories.GradeRepository;
import docotel.spera.repositories.PositionRepository;
import docotel.spera.repositories.TroopRepository;
import docotel.spera.responses.ResponseBody;
import docotel.spera.responses.Result;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @Autowired
    private TroopRepository troopsRepo;
    
    @GetMapping("/troops/positions")
    public ResponseEntity<List> allPositions(@RequestHeader("Authentication") String Authentication) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-trace-id", "x-trace-id");
        return new ResponseEntity<>(positionRepo.findAll(), headers, HttpStatus.OK);
    }
    
    @GetMapping("/troops/grades")
    public ResponseEntity<List> allGrades(@RequestHeader("Authentication") String Authentication) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-trace-id", "x-trace-id");
        return new ResponseEntity<>(gradeRepo.findAll(), headers, HttpStatus.OK);
    }
    
    @GetMapping("/troops/list")
    public ResponseEntity<List> allTroops(@RequestHeader("Authentication") String Authentication) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-trace-id", "x-trace-id");
        return new ResponseEntity<>(troopsRepo.findAll(), headers, HttpStatus.OK);
    }
    
    @PostMapping("/troops/add")
    public ResponseEntity<org.bson.Document> addTroop(
            @RequestHeader("Authentication") String Authentication, 
            @RequestBody Troop troop) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-trace-id", "x-trace-id");
        try {
            troopsRepo.save(troop);
            return new ResponseEntity<>(new ResponseBody(Result.SUCCESS).toJSON(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseBody(Result.ERROR).toJSON(), headers, HttpStatus.BAD_REQUEST);
        }
    }
}