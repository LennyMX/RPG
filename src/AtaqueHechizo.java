/** Hechizo: ignora la defensa del objetivo (daño mágico). */
public class AtaqueHechizo implements EstrategiaAtaque {
    @Override
    public ResultadoAtaque atacar(Personaje atacante, Personaje objetivo) {
        int dano = Math.max(1, atacante.getAtaque());
        boolean critico = Azar.probabilidad(0.10);
        if (critico) dano = (int) Math.round(dano * 1.5);
        return new ResultadoAtaque(dano, critico, "hechizo");
    }
}
