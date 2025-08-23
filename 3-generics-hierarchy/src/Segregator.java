import java.util.Collection;

public class Segregator {
    static void segregate(Collection<? extends Chordate> SrcCollection, Collection<? super EuropeanHedgehog> Collection1, Collection<? super PallasCat> Collection2, Collection<? super Lynx> Collection3) {
        for (Chordate src : SrcCollection) {
            switch (src) {
                case EuropeanHedgehog europeanHedgehog -> Collection1.add(europeanHedgehog);
                case PallasCat pallasCat -> Collection2.add(pallasCat);
                case Lynx lynx -> Collection3.add(lynx);
                default -> throw new IllegalStateException("Unexpected value: " + src);
            }
        }
    }
}
