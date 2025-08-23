import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String METHOD_SELECTION_PROMPT = """
            Select the method parameters:
            1. segregate(mammals, erinaceidaes, felidaes, carnivoras)
            2. segregate(carnivoras, chordates, pallasCats, felidaes)
            3. segregate(erinaceidaes, eulipotyphlas, carnivoras, carnivoras)
            
            Write a number and press Enter""";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(METHOD_SELECTION_PROMPT);
            while (scanner.hasNextLine()) {
                switch (scanner.nextInt()) {
                    case 1 -> {
                        Collection<Mammal> mammals = List.of(new EuropeanHedgehog(), new PallasCat(), new Lynx(), new EuropeanHedgehog(), new PallasCat(), new Lynx());
                        Collection<Erinaceidae> erinaceidaes = new ArrayList<>();
                        Collection<Felidae> felidaes = new ArrayList<>();
                        Collection<Carnivora> carnivoras = new ArrayList<>();
                        Segregator.segregate(mammals, erinaceidaes, felidaes, carnivoras);
                        String output = """
                                mammals: %s
                                erinaceidaes: %s
                                felidaes: %s
                                carnivoras: %s""".formatted(mammals, erinaceidaes, felidaes, carnivoras);
                        System.out.println(output);
                    }
                    case 2 -> {
                        Collection<Carnivora> carnivoras = List.of(new PallasCat(), new Lynx(), new PallasCat(), new Lynx());
                        Collection<Chordate> chordates = new ArrayList<>();
                        Collection<PallasCat> pallasCats = new ArrayList<>();
                        Collection<Felidae> felidaes = new ArrayList<>();
                        Segregator.segregate(carnivoras, chordates, pallasCats, felidaes);
                        String output = """
                                carnivoras: %s
                                chordates: %s
                                pallasCats: %s
                                felidaes: %s""".formatted(carnivoras, chordates, pallasCats, felidaes);
                        System.out.println(output);
                    }
                    case 3 -> {
                        Collection<Erinaceidae> erinaceidaes = List.of(new EuropeanHedgehog(), new EuropeanHedgehog());
                        Collection<Eulipotyphla> eulipotyphlas = new ArrayList<>();
                        Collection<Carnivora> firstCarnivoras = new ArrayList<>();
                        Collection<Carnivora> secondCarnivoras = new ArrayList<>();
                        Segregator.segregate(erinaceidaes, eulipotyphlas, firstCarnivoras, secondCarnivoras);
                        String output = """
                                erinaceidaes: %s
                                eulipotyphlas: %s
                                carnivoras: %s
                                carnivoras: %s""".formatted(erinaceidaes, eulipotyphlas, firstCarnivoras, secondCarnivoras);
                        System.out.println(output);
                    }
                    default -> System.out.println("Unexpected value, only 1, 2 or 3 are allowed");
                }
            }
        }
    }
}