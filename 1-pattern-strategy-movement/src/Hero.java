import java.awt.*;

public class Hero {
    private MovementStrategy movementStrategy;
    private Point currentLocation;

    public Hero(MovementStrategy movementStrategy, Point currentLocation) {
        this.movementStrategy = movementStrategy;
        this.currentLocation = (Point) currentLocation.clone();
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    public void move(Point newLocation) {
        System.out.print("Hero moved by ");
        movementStrategy.move(newLocation);
        this.currentLocation = (Point) newLocation.clone();
        System.out.println(" to " + currentLocation);
    }
}
