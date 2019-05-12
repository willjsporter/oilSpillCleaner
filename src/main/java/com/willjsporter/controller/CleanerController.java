package com.willjsporter.controller;

import com.willjsporter.Cleaner;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CleanerController {

    @PostMapping(
            value = "/sendInstructions",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Cleaner sendAndActionCleaner(@RequestBody Instructions instructions) {
        return instructions.createCleaner();
    }
}
