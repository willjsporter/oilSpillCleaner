package com.willjsporter.controller;

import com.willjsporter.cleaner.Cleaner;
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
    public CleanerReport sendAndActionCleaner(@RequestBody Instructions instructions) throws Exception {
        Cleaner cleaner = instructions.createCleaner();
        while (cleaner.getDirections().size() > 0) {
            cleaner.nextMove();
        }

        return new CleanerReport(cleaner.getPosition(), cleaner.getTotalSpillsCleaned());
    }
}
