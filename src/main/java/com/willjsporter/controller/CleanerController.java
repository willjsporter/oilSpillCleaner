package com.willjsporter.controller;

import com.willjsporter.Cleaner;
import com.willjsporter.utils.Coordinates;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CleanerController {

    @PostMapping(
            value = "/sendInstructions",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public CleanerReport sendAndActionCleaner(@RequestBody Instructions instructions) {
        return new CleanerReport(new Coordinates(3,2), 2);
    }
}
