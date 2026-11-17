/** Puñalada: rápida y con alta probabilidad de crítico, pero la defensa la reduce por completo. */
public class AtaquePunalada implements EstrategiaAtaque {
    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        int dano = Math.max(1, atacante.getAtaque() - objetivo.getDefensa());
        boolean critico = Azar.probabilidad(0.30);
        if (critico) dano *= 2;
        return new ResultadoAtaque(dano, critico, "puñalada");
    }
}
