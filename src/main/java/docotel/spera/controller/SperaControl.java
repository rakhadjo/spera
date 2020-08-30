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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<List<Position>> allPositions() {
        return ResponseEntity.accepted()
                .header("x-trace-id", "x-trace-id")
                .body(positionRepo.findAll());
    }
    
    @GetMapping("/troops/grades")
    public ResponseEntity<List<Grade>> allGrades() {
        return ResponseEntity.accepted()
                .header("x-trace-id", "x-trace-id")
                .body(gradeRepo.findAll());
    }
}
