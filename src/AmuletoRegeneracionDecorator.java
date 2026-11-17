/** +3 defensa y +2 HP por turno (se regenera al comenzar su ataque, sin superar su HP inicial). */
public class AmuletoRegeneracionDecorator extends PersonajeDecorator {
    private static final int REGENERACION = 2;
    private final int hpMaximo;

    public AmuletoRegeneracionDecorator(Personaje personaje) {
        super(personaje);
        this.hpMaximo = personaje.getHp();
    }

    @Override public int getDefensa() { return super.getDefensa() + 3; }
    @Override public String getDescripcion() { return super.getDescripcion() + " + Amuleto de regeneración"; }

    @Override
    public ResultadoAtaque atacarComo(Personaje atacante, Personaje objetivo) {
        int antes = getHp();
        setHp(Math.min(hpMaximo, antes + REGENERACION));
        int curado = getHp() - antes;

        ResultadoAtaque r = super.atacarComo(atacante, objetivo);
        if (curado <= 0) return r;
        return new ResultadoAtaque(r.getDano(), r.isCritico(),
                r.getEfecto() + " + regeneración (+" + curado + " HP)");
    }
}
