/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docotel.spera.controller;

import docotel.spera.log.GetGradesLogEntry;
import docotel.spera.logrepos.GetGradesLogRepo;
import docotel.spera.models.Troop;
import docotel.spera.repositories.GradeRepository;
import docotel.spera.repositories.PositionRepository;
import docotel.spera.repositories.TroopRepository;
import docotel.spera.requests.DashboardRequest;
import docotel.spera.requests.UserProfileRequest;
import docotel.spera.responses.DashboardResponse;
import docotel.spera.responses.GetGradesResponse;
import docotel.spera.responses.ResponseBody;
import docotel.spera.responses.Result;
import docotel.spera.responses.UserProfileResponse;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.bson.Document;
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

    private String xTrace() {
        java.util.Random rand = new java.util.Random();
        String newTrace = "";
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < 12; i++) {
            int num = rand.nextInt(charSet.length());
            newTrace += charSet.charAt(num);
        }
        return newTrace;
    }

    @GetMapping("/troops/positions")
    public ResponseEntity<List> allPositions(
            @RequestHeader("Authentication") String Authentication) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-trace-id", xTrace());
        return new ResponseEntity<>(positionRepo.findAll(), headers, HttpStatus.OK);
    }

    @GetMapping("/troops/grades")
    public ResponseEntity<GetGradesResponse> allGrades(
            @RequestHeader("Authentication") String Authentication,
            HttpServletRequest request) {
        Timestamp t1 = new Timestamp(new Date().getTime());
        HttpHeaders headers = new HttpHeaders();
        GetGradesResponse rb = new GetGradesResponse(Result.SUCCESS);
        rb.data = gradeRepo.findAll();
        String trace = xTrace();
        headers.add("x-trace-id", trace);
        
        GetGradesLogEntry entry = new GetGradesLogEntry();
        entry.host_ip = request.getRemoteHost();
        entry.client_ip = request.getRemoteAddr();
        entry.request_header = new Document("Authentication", Authentication);
        entry.request_body = null;
        entry.response_header = new Document("x-trace-id", trace);
        entry.response_body = rb.toJSON();
        entry.nik = null;
        entry.request_datetime = t1;
        entry.response_datetime = new Timestamp(new Date().getTime());
        
        getGradesLogRepo.save(entry);
        return new ResponseEntity(rb.toJSON(), headers, HttpStatus.OK);
    }

    @GetMapping("/troops/list")
    public ResponseEntity<List> allTroops(
            @RequestHeader("Authentication") String Authentication) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-trace-id", xTrace());
        return new ResponseEntity<>(troopsRepo.findAll(), headers, HttpStatus.OK);
    }

    @PostMapping("/troops/add")
    public ResponseEntity<org.bson.Document> addTroop(
            @RequestHeader("Authentication") String Authentication,
            @RequestBody Troop troop) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-trace-id", xTrace());
        try {
            troopsRepo.save(troop);
            return new ResponseEntity<>(new ResponseBody(Result.SUCCESS).toJSON(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseBody(Result.ERROR).toJSON(), headers, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/dashboard")
    public ResponseEntity<org.bson.Document> dashboard(
            @RequestHeader("Authentication") String Authentication,
            @RequestBody DashboardRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-trace-id", xTrace());
        return new ResponseEntity(new DashboardResponse(Result.SUCCESS).toJSON(), headers, HttpStatus.OK);
    }

    @PostMapping("/user/login")
    public ResponseEntity<org.bson.Document> login(
            @RequestHeader("Authentication") String Authentication,
            @RequestBody UserProfileRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-trace-id", xTrace());
        try {
            Troop t = troopsRepo.findByNik(request.nik);
            UserProfileResponse response = new UserProfileResponse(Result.SUCCESS);
            response.data = t.toJSON();
            return new ResponseEntity(response.toJSON(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(
                    new org.bson.Document("error", e.getMessage()), headers, HttpStatus.BAD_REQUEST
            );
        }
    }
    
    @Autowired
    private GetGradesLogRepo getGradesLogRepo;
}
