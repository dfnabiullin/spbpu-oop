import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Hero hero = new Hero();
        int distance;
        char move;
        Scanner in = new Scanner(System.in);
        System.out.println("Type the distance of movement:");
        distance = in.nextInt();
        hero.setMovementDistance(distance);
        System.out.println(
                "Press \"w\" to walk.\nPress \"r\" to ride a horse.\nPress \"f\" to fly.\nPress \"s\" to swim.\nPress \"d\" to change the distance of movement.\nPress \"e\" to end journey.");
        do {
            move = (char) System.in.read();
            switch (move) {
                case 'w': {
                    hero.setMovementStrategy(new Walk());
                    System.out.println(hero.move());
                    break;
                }
                case 'r': {
                    hero.setMovementStrategy(new RidingAHorse());
                    System.out.println(hero.move());
                    break;
                }
                case 'f': {
                    hero.setMovementStrategy(new Fly());
                    System.out.println(hero.move());
                    break;
                }
                case 's': {
                    hero.setMovementStrategy(new Swim());
                    System.out.println(hero.move());
                    break;
                }
                case 'd': {
                    System.out.println("Type the distance of movement");
                    distance = in.nextInt();
                    hero.setMovementDistance(distance);
                    break;
                }
            }
        } while (move != 'e');
        in.close();
    }
}
