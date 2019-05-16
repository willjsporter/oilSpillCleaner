package com.willjsporter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
    public void ifNoDirectionscontrollerShouldSendBackStartingPositionAndNoSpillsCleaned () throws Exception {
        String instructionsString = readFileAsString("trivial_test_data.json");

        this.mockMvc.perform(post("/sendInstructions").contentType(MediaType.APPLICATION_JSON_UTF8).content(instructionsString))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.oilPatchesCleaned").value(0))
                .andExpect(jsonPath("$.finalPosition.x").value(1))
                .andExpect(jsonPath("$.finalPosition.y").value(1));
    }

    @Test
    public void controllerShouldProcessInstructionsAndSendBackFinalPositionAndNumberCleaned () throws Exception {
        String instructionsString = readFileAsString("test_data.json");

        this.mockMvc.perform(post("/sendInstructions").contentType(MediaType.APPLICATION_JSON_UTF8).content(instructionsString))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.oilPatchesCleaned").value(2))
                .andExpect(jsonPath("$.finalPosition.x").value(3))
                .andExpect(jsonPath("$.finalPosition.y").value(2));
    }

    @Test
    public void controllerShouldReturnErrorWhenInstructionsCauseCleanerToGoOutOfBounds () throws Exception {
        String instructionsString = readFileAsString("error_test_data.json");

        try {
            this.mockMvc.perform(
                    post("/sendInstructions")
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .content(instructionsString)
            );
            fail("Expected exception: \"cleaner is out of bounds at position (-1,1)\" but no exception thrown");
        } catch (Exception e) {
            assertThat(e.getCause().getMessage(), is("cleaner is out of bounds at position (-1,1)"));
        }
    }

    private String readFileAsString(String pathToFile) throws URISyntaxException, IOException {
        //implementation from spring docs: https://www.baeldung.com/reading-file-in-java#JDK7

        Path path = Paths.get(getClass().getClassLoader().getResource(pathToFile).toURI());
        byte[] fileBytes = Files.readAllBytes(path);
        return new String(fileBytes);
    }
}