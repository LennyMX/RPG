import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        ConsolaJuego juego = new ConsolaJuego();

        if (args.length > 0 && args[0].equals("--demo")) {
            demo(juego);
        } else {
            juego.jugarInteractivo(new Scanner(System.in, StandardCharsets.UTF_8));
        }
    }

    /** Cuatro corridas con distintas clases, equipamientos y enemigos (semilla fija = reproducible). */
    private static void demo(ConsolaJuego juego) {
        corrida(juego, 1, 42, "Aria", 2, new int[]{1, 3, 5}, 1);
        corrida(juego, 2, 7, "Thorin", 1, new int[]{2, 4}, 2);
        corrida(juego, 3, 21, "Legolas", 3, new int[]{1, 2, 3, 5}, 3);
        corrida(juego, 4, 99, "Sombra", 4, new int[]{3, 4, 5}, 1);
    }

    private static void corrida(ConsolaJuego juego, int n, long semilla, String nombre,
                                int clase, int[] equipo, int enemigo) {
        String[] clases = {"", "Guerrero", "Mago", "Arquero", "Pícaro"};
        String[] enemigos = {"", "Goblin", "Orco", "Dragón"};
        System.out.println("##########################################");
        System.out.println("# CORRIDA " + n);
        System.out.println("##########################################");
        System.out.println("Entrada simulada");
        System.out.println("Nombre: " + nombre);
        System.out.println("Clase: " + clase + " (" + clases[clase] + ")");
        System.out.println("Equipamiento: " + Arrays.toString(equipo).replaceAll("[\\[\\] ]", ""));
        System.out.println("Enemigo: " + enemigo + " (" + enemigos[enemigo] + ")");
        System.out.println();

        Azar.semilla(semilla);
        juego.jugar(nombre, clase, equipo, enemigo);
        System.out.println("\n");
    }
}
