import java.awt.*;

public class WalkingStrategy implements MovementStrategy {
    public void move(Point newLocation) {
        System.out.print(this);
    }

    @Override
    public String toString() {
        return "walking";
    }
}
