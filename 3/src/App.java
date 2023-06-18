import static animals.Animals.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        way1();
        way2();
        way3();
    }

    public static void way1() {
        List<Chordate> SrcCollection = List.of(new Mammal(), new Erinaceidae(), new Felidae(), new Carnivora());
        List<EuropeanHedgehog> Collection1 = new ArrayList<>();
        List<PallasСat> Collection2 = new ArrayList<>();
        List<Lynx> Collection3 = new ArrayList<>();
        System.out.println("Way №1");
        segregate(SrcCollection, Collection1, Collection2, Collection3);
        printCollections(SrcCollection, Collection1, Collection2, Collection3);
    }

    public static void way2() {
        List<Chordate> SrcCollection = List.of(new Carnivora(), new Chordate(), new PallasСat(), new Felidae());
        List<EuropeanHedgehog> Collection1 = new ArrayList<>();
        List<PallasСat> Collection2 = new ArrayList<>();
        List<Lynx> Collection3 = new ArrayList<>();
        System.out.println("Way №2");
        segregate(SrcCollection, Collection1, Collection2, Collection3);
        printCollections(SrcCollection, Collection1, Collection2, Collection3);
    }

    public static void way3() {
        List<Chordate> SrcCollection = List.of(new Erinaceidae(), new Eulipotyphla(), new Carnivora(), new Carnivora());
        List<EuropeanHedgehog> Collection1 = new ArrayList<>();
        List<PallasСat> Collection2 = new ArrayList<>();
        List<Lynx> Collection3 = new ArrayList<>();
        System.out.println("Way №3");
        segregate(SrcCollection, Collection1, Collection2, Collection3);
        printCollections(SrcCollection, Collection1, Collection2, Collection3);
    }

    public static <T, K, H, D> void printCollections(List<T> c0, List<K> c1, List<H> c2, List<D> c3) {
        System.out.println(c0.toString() + '\n' + c1.toString() + '\n' + c2.toString() + '\n' + c3.toString() + '\n');
    }

    public static void segregate(List<? extends Chordate> SrcCollection, List<? super EuropeanHedgehog> Collection1, List<? super PallasСat> Collection2, List<? super Lynx> Collection3) {
        for (int i = 0; i < SrcCollection.size(); i++) {
            if (SrcCollection.get(i) instanceof EuropeanHedgehog) {
                Collection1.add((EuropeanHedgehog) SrcCollection.get(i));
            }
            if (SrcCollection.get(i) instanceof PallasСat) {
                Collection2.add((PallasСat) SrcCollection.get(i));
            }
            if (SrcCollection.get(i) instanceof Lynx) {
                Collection3.add((Lynx) SrcCollection.get(i));
            }
        }
    }
}
