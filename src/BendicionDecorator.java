/** +15% a ataque, defensa y velocidad. */
public class BendicionDecorator extends PersonajeDecorator {
    public BendicionDecorator(Personaje personaje) { super(personaje); }

    private static int aumentar(int valor) { return (int) Math.round(valor * 1.15); }

    @Override public int getAtaque() { return aumentar(super.getAtaque()); }
    @Override public int getDefensa() { return aumentar(super.getDefensa()); }
    @Override public int getVelocidad() { return aumentar(super.getVelocidad()); }
    @Override public String getDescripcion() { return super.getDescripcion() + " + Bendición"; }
}
