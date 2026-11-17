/** +8 defensa. */
public class ArmaduraDecorator extends PersonajeDecorator {
    public ArmaduraDecorator(Personaje personaje) { super(personaje); }

    @Override public int getDefensa() { return super.getDefensa() + 8; }
    @Override public String getDescripcion() { return super.getDescripcion() + " + Armadura"; }
}
