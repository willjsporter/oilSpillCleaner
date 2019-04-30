import org.javatuples.Pair;

import java.util.List;

public class Cleaner {

    private Area area;
    private Pair<Integer, Integer> position;


    public Cleaner(Area area, Pair<Integer, Integer> position, List<Pair<Integer, Integer>> directions) {
        this.area = area;
        this.position = position;
        this.directions = directions;
    }

    public void move() {

    }

    public Area getArea() {
        return area;
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    public List<Pair<Integer, Integer>> getDirections() {
        return directions;
    }

    private List<Pair<Integer, Integer>> directions;
}
