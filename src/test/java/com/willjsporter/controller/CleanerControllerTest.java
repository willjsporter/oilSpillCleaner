package com.willjsporter.controller;

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

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CleanerControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void controllerShouldProcessInstructionsAndSendBackFinalPositionAndNumberCleaned () throws Exception {
        String instructions = readFileAsString("test_data.json");
        this.mockMvc.perform(post("/sendInstructions").contentType(MediaType.APPLICATION_JSON_UTF8).content(instructions))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("areaSize")))
                .andExpect(content().string(containsString("startingPosition")))
                .andExpect(content().string(containsString("oilPatches")))
                .andExpect(content().string(containsString("navigationInstructions")));
    }

    private String readFileAsString(String pathToFile) throws URISyntaxException, IOException {
        //implementation from spring docs

        Path path = Paths.get(getClass().getClassLoader().getResource("test_data.json").toURI());
        byte[] fileBytes = Files.readAllBytes(path);
        String data = new String(fileBytes);
        return data;
    }
}