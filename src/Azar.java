import java.util.Random;

/** Fuente de aleatoriedad única; permite fijar una semilla para corridas reproducibles. */
public final class Azar {
    private static Random rnd = new Random();

    private Azar() {}

    public static void semilla(long semilla) { rnd = new Random(semilla); }

    public static boolean probabilidad(double p) { return rnd.nextDouble() < p; }
}
