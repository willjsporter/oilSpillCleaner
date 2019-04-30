import org.javatuples.Pair;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class CleanerTest {

    @Test
    public void cleanerShouldStayStationaryIfNoDirectionsAreGiven() {
        var area = new Area();
        var startingPoint = Pair.with(0,0);
        var directions = List.of();
        Cleaner cleaner = new Cleaner(area, startingPoint, List.of() );
        cleaner.move();
        assertThat(cleaner.getPosition(), is(startingPoint));
    }
}