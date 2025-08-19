import java.awt.*;

public class FlyingStrategy implements MovementStrategy {
    public void move(Point newLocation) {
        System.out.print(this);
    }

    @Override
    public String toString() {
        return "flying";
    }
}
