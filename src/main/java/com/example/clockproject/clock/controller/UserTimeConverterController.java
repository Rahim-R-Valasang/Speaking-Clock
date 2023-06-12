package com.example.clockproject.clock.controller;





import com.example.clockproject.clock.service.TimeConverterService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping("/user-time")
public class UserTimeConverterController {
    private final TimeConverterService timeConverterService;

    public UserTimeConverterController(TimeConverterService timeConverterService) {
        this.timeConverterService = timeConverterService;
    }

    @PostMapping("/convert")
    public ResponseEntity<String> convertUserTimeToWords(
            @RequestParam("time") @DateTimeFormat(pattern = "HH:mm") LocalTime time) {
        try {
//            String convertedTime = request.getTime();
            String convertedTime = timeConverterService.convertTimeToWords(time);
            return ResponseEntity.ok(convertedTime);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid time format provided.");
        }
    }
}


