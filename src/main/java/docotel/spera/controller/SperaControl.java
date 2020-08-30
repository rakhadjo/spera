/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.controller;

import docotel.spera.models.Position;
import docotel.spera.repositories.PositionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rakhadjo
 */
@RestController
@RequestMapping("/api")
public class SperaControl {
    
    @Autowired
    private PositionRepository positionRepo;
    
    @GetMapping("/troops/positions")
    public @ResponseBody List<Position> allPositions() {
        return positionRepo.findAll();
    }
}
