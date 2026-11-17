/**
 * +5 ataque (modifica atributos) y efecto DOT (modifica el daño en atacar).
 * El primer golpe envenena al objetivo durante DURACION golpes propios;
 * mientras dure, cada ataque suma DANO_DOT de daño extra.
 */
public class VenenoDecorator extends PersonajeDecorator {
    private static final int DANO_DOT = 3;
    private static final int DURACION = 3;

    private Personaje envenenado;
    private int turnosRestantes;

    public VenenoDecorator(Personaje personaje) { super(personaje); }

    @Override public int getAtaque() { return super.getAtaque() + 5; }
    @Override public String getDescripcion() { return super.getDescripcion() + " + Veneno"; }

    @Override
    public ResultadoAtaque atacarComo(Personaje atacante, Personaje objetivo) {
        ResultadoAtaque r = super.atacarComo(atacante, objetivo);

        boolean yaEnvenenado = objetivo == envenenado && turnosRestantes > 0;
        int extra = 0;
        String efecto = r.getEfecto() + " + veneno";
        if (yaEnvenenado) {
            extra = DANO_DOT;
            turnosRestantes--;
            efecto += " (DOT +" + DANO_DOT + ")";
        } else {
            envenenado = objetivo;
            turnosRestantes = DURACION;
        }
        return new ResultadoAtaque(r.getDano() + extra, r.isCritico(), efecto);
    }
}
