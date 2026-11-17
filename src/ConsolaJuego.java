import java.util.Scanner;

/**
 * UI de consola. Solo conoce los creadores (Factory Method) y la interfaz
 * Personaje (Decorator); nunca instancia PersonajeBase ni estrategias.
 */
public class ConsolaJuego {

    private static CreadorPersonaje creadorDe(int clase) {
        switch (clase) {
            case 1: return new CreadorGuerrero();
            case 2: return new CreadorMago();
            case 3: return new CreadorArquero();
            default: return new CreadorPicaro();
        }
    }

    private static CreadorEnemigo creadorEnemigoDe(int enemigo) {
        switch (enemigo) {
            case 1: return new CreadorGoblin();
            case 2: return new CreadorOrco();
            default: return new CreadorDragon();
        }
    }

    private static Personaje equipar(Personaje p, int objeto) {
        switch (objeto) {
            case 1: return new EspadaDecorator(p);
            case 2: return new ArmaduraDecorator(p);
            case 3: return new VenenoDecorator(p);
            case 4: return new AmuletoRegeneracionDecorator(p);
            case 5: return new BendicionDecorator(p);
            default: return p;
        }
    }

    /** Ejecuta un combate completo con la selección dada. */
    public void jugar(String nombre, int clase, int[] equipamiento, int enemigoOpcion) {
        Personaje heroe = creadorDe(clase).crearPersonaje(nombre);
        for (int objeto : equipamiento) heroe = equipar(heroe, objeto);

        System.out.println("Héroe: " + heroe.getDescripcion());
        System.out.println("ATK: " + heroe.getAtaque()
                + " | DEF: " + heroe.getDefensa()
                + " | VEL: " + heroe.getVelocidad()
                + " | HP: " + heroe.getHp());

        Personaje enemigo = creadorEnemigoDe(enemigoOpcion).crearEnemigo();
        System.out.println("Enemigo: " + enemigo.getNombre()
                + " | ATK: " + enemigo.getAtaque()
                + " | DEF: " + enemigo.getDefensa()
                + " | HP: " + enemigo.getHp());

        new MotorCombate().iniciarCombate(heroe, enemigo);
    }

    /** Modo interactivo. */
    public void jugarInteractivo(Scanner in) {
        System.out.print("Nombre: ");
        String nombre = in.nextLine().trim();
        if (nombre.isEmpty()) nombre = "Héroe";

        int clase = leerEntero(in, "Clase (1=Guerrero, 2=Mago, 3=Arquero, 4=Pícaro): ", 1, 4);

        System.out.print("Equipamiento separado por comas "
                + "(1=Espada, 2=Armadura, 3=Veneno, 4=Amuleto regeneración, 5=Bendición; vacío = ninguno): ");
        int[] equipo = parsearEquipo(in.nextLine());

        int enemigo = leerEntero(in, "Enemigo (1=Goblin, 2=Orco, 3=Dragón): ", 1, 3);
        System.out.println();
        jugar(nombre, clase, equipo, enemigo);
    }

    private static int leerEntero(Scanner in, String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            try {
                int v = Integer.parseInt(in.nextLine().trim());
                if (v >= min && v <= max) return v;
            } catch (NumberFormatException ignorado) { }
            System.out.println("Opción inválida, intenta de nuevo.");
        }
    }

    private static int[] parsearEquipo(String linea) {
        return java.util.Arrays.stream(linea.split(","))
                .map(String::trim)
                .filter(s -> s.matches("[1-5]"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
