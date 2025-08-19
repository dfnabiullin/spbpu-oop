import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String MOVEMENT_STRATEGY_PROMPT = """
            Select movement strategy for hero (Default: Walking):
            1. Walking
            2. Horse Riding
            3. Flying
            
            Write a number and press Enter
            """;

    public static void main(String[] args) {
        Hero hero = new Hero(new WalkingStrategy(), new Point());
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println(MOVEMENT_STRATEGY_PROMPT);
        while (scanner.hasNext()) {
            switch (scanner.nextLine()) {
                case "1":
                    hero.setMovementStrategy(new WalkingStrategy());
                    break;
                case "2":
                    hero.setMovementStrategy(new HorseRidingStrategy());
                    break;
                case "3":
                    hero.setMovementStrategy(new FlyingStrategy());
                    break;
                default:
                    System.out.println("Incorrect input, only 1, 2 or 3 allowed. The movement strategy has remained the same");
                    break;
            }
            hero.move(new Point(random.nextInt(), random.nextInt()));
        }
        scanner.close();
    }
}