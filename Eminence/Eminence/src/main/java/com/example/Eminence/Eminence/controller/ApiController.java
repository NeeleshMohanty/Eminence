package com.example.Eminence.Eminence.controller;

import com.example.Eminence.Eminence.Service.FootballMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private FootballMatchService footballMatchService;

    @GetMapping("/match/drawcount")
    public ResponseEntity<?> getDrawCountForYear(@RequestParam("year") int year) {
        int drawCount = footballMatchService.getDrawCountForYear(year);
        return ResponseEntity.ok(drawCount);
    }

    @GetMapping("/user/details")
    public ResponseEntity<?> getUserDetails(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(userDetails);
    }
}

