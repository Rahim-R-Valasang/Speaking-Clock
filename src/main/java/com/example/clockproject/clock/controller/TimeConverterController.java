package com.example.clockproject.clock.controller;





import com.example.clockproject.clock.service.TimeConverterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/time")
public class TimeConverterController {
    private final TimeConverterService timeConverterService;

    public TimeConverterController(TimeConverterService timeConverterService) {
        this.timeConverterService = timeConverterService;
    }

    @GetMapping("/{time}")
    public ResponseEntity<String> getCurrentTimeInWords(@PathVariable String time ) {
//        LocalTime currentTime = LocalTime.now();
        String convertedTime = timeConverterService.convertTimeToWords(LocalTime.parse(time));
        return ResponseEntity.ok(convertedTime);
    }
}