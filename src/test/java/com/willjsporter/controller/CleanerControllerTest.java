package com.willjsporter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.willjsporter.Area;
import com.willjsporter.Cleaner;
import com.willjsporter.utils.Coordinates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CleanerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void controllerShouldProcessInstructionsAndSendBackAppropriateCleaner () throws Exception {
        String instructionsString = readFileAsString("test_data.json");

        String controllerResponse = this.mockMvc.perform(post("/sendInstructions").contentType(MediaType.APPLICATION_JSON_UTF8).content(instructionsString))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("area")))
                .andExpect(content().string(containsString("position")))
                .andExpect(content().string(containsString("directions")))
                .andExpect(content().string(containsString("totalSpillsCleaned")))
                .andReturn().getResponse().getContentAsString();

        Cleaner generatedCleaner = objectMapper.readValue(controllerResponse, Cleaner.class);
        Cleaner expectedCleaner = new Cleaner(
                new Area(5,5, List.of(new Coordinates(1,0), new Coordinates (2,0))),
                new Coordinates(0,0),
                new ArrayList<>(List.of(new Coordinates(0,1), new Coordinates(1,0), new Coordinates(0,-1), new Coordinates(1,0), new Coordinates(1,0), new Coordinates(0,1), new Coordinates(0,1)))
        );

        assertThat(generatedCleaner, equalTo(expectedCleaner));
    }

    private String readFileAsString(String pathToFile) throws URISyntaxException, IOException {
        //implementation from spring docs: https://www.baeldung.com/reading-file-in-java

        Path path = Paths.get(getClass().getClassLoader().getResource("test_data.json").toURI());
        byte[] fileBytes = Files.readAllBytes(path);
        return new String(fileBytes);
    }
}