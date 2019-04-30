package utils;

public class Coordinates {

    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates add(Coordinates otherCoordinates) {
        return new Coordinates(
                x + otherCoordinates.getX(),
                y + otherCoordinates.getY()
        );
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
