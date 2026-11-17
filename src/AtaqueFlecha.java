/** Flecha: la defensa del objetivo solo cuenta a la mitad. */
public class AtaqueFlecha implements EstrategiaAtaque {
    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        int dano = Math.max(1, atacante.getAtaque() - objetivo.getDefensa() / 2);
        boolean critico = Azar.probabilidad(0.20);
        if (critico) dano *= 2;
        return new ResultadoAtaque(dano, critico, "flecha");
    }
}
