/** Espadazo: el daño se reduce por completo con la defensa del objetivo. */
public class AtaqueEspada implements EstrategiaAtaque {
    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        int dano = Math.max(1, atacante.getAtaque() - objetivo.getDefensa());
        boolean critico = Azar.probabilidad(0.10);
        if (critico) dano *= 2;
        return new ResultadoAtaque(dano, critico, "espadazo");
    }
}
