public class CreadorGuerrero extends CreadorPersonaje {
    @Override
    public Personaje crearPersonaje(String nombre) {
        validarNombre(nombre);
        Personaje p = new PersonajeBase(nombre, 120, 18, 14, 8);
        p.setEstrategia(new AtaqueEspada());
        return p;
    }
}
