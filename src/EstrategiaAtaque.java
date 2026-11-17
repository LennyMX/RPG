/** Strategy: una forma de atacar intercambiable. */
public interface EstrategiaAtaque {
    ResultadoAtaque atacar(Personaje atacante, Personaje objetivo);
}
