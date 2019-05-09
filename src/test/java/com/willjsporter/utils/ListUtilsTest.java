package com.willjsporter.utils;

import org.junit.Test;

import java.util.List;

import static com.willjsporter.utils.ListUtils.toCoordinates;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ListUtilsTest {

    @Test
    public void shouldBeAbleToConvert2ItemListToCoordinates() throws Exception {
        var listToConvert = List.of(1,2);
        assertThat(toCoordinates(listToConvert), equalTo(new Coordinates(1,2)));
    }

    @Test
    public void listofLengthMoreThan2ShouldThrowException() {
        try {
            toCoordinates(List.of(1,2,3));
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("list must be of length 2 but was of length 3"));
        }
    }

}