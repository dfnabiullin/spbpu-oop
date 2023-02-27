public class Hero {
    private int point = 0;
    private int movementDistance = 0;
    private Movement movementStrategy = new Walk();

    public String move() {
        point += movementDistance;
        return "Hero " + movementStrategy.move() + " to " + point;
    }

    public void setMovementDistance(int distance) {
        movementDistance = distance;
    }

    public void setMovementStrategy(Movement move) {
        movementStrategy = move;
    }
}
