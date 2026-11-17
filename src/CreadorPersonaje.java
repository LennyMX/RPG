/** Factory Method: cada subclase decide qué personaje concreto crear. */
public abstract class CreadorPersonaje {
    public abstract Personaje crearPersonaje(String nombre);

    // Hook opcional: validación común
    protected void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío");
    }
}
