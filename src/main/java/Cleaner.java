import utils.Coordinates;

import java.util.List;

public class Cleaner {

    private Area area;
    private Coordinates position;
    private List<Coordinates> directions;


    public Cleaner(Area area, Coordinates position, List<Coordinates> directions) {
        this.area = area;
        this.position = position;
        this.directions = directions;
    }

    public void move() {

    }

    public Area getArea() {
        return area;
    }

    public Coordinates getPosition() {
        return position;
    }

    public List<Coordinates> getDirections() {
        return directions;
    }

}
