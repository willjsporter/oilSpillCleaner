import org.junit.Test;
import utils.Coordinates;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class CleanerTest {

    @Test
    public void cleanerShouldStayStationaryIfNoDirectionsAreGiven() {
        var area = new Area();
        var startingPoint = new Coordinates(0, 0);
        Cleaner cleaner = new Cleaner(area, startingPoint, List.of() );

        cleaner.move();
        assertThat(cleaner.getPosition(), is(startingPoint));
    }
}