import org.junit.Test;
import utils.Coordinates;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class CleanerTest {

    @Test
    public void cleanerShouldStayStationaryIfNoDirectionsAreGiven() {
        var area = new Area();
        var startingPoint = new Coordinates(0, 0);
        Cleaner cleaner = new Cleaner(area, startingPoint, new ArrayList<>());

        cleaner.nextMove();
        assertThat(cleaner.getPosition(), is(startingPoint));
    }

    @Test
    public void cleanerShouldMoveBasedOnListOfDirections() {
        var area = new Area();
        var startingPoint = new Coordinates(0, 0);
        var directions = new ArrayList<Coordinates>(List.of(
                new Coordinates(1, 0),
                new Coordinates(2, 1),
                new Coordinates(-1, 5)
        ));

        Cleaner cleaner = new Cleaner(area, startingPoint, directions);

        cleaner.nextMove();
        assertThat(cleaner.getPosition(), equalTo(new Coordinates(1, 0)));

        cleaner.nextMove();
        assertThat(cleaner.getPosition(), equalTo(new Coordinates(3, 1)));

        cleaner.nextMove();
        assertThat(cleaner.getPosition(), equalTo(new Coordinates(2, 6)));
    }


}