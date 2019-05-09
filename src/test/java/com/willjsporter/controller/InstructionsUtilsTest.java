package com.willjsporter.controller;

import com.willjsporter.utils.Coordinates;
import org.junit.Test;

import java.util.List;

import static com.willjsporter.controller.InstructionsUtils.listToCoordinates;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class InstructionsUtilsTest {

    @Test
    public void shouldBeAbleToConvert2ItemListToCoordinates() {
        var listToConvert = List.of(1,2);
        assertThat(listToCoordinates(listToConvert), equalTo(new Coordinates(1, 2)));
    }

    @Test
    public void listofLengthOtherThan2ShouldDefaultToZeroZeroCoordinates() {
        var invalidListToConvert = List.of(2,3,10,14);
        assertThat(listToCoordinates(invalidListToConvert), equalTo(new Coordinates(0, 0)));
    }

}