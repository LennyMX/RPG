/**
 * Componente común del patrón Decorator (y producto del Factory Method).
 *
 * Se añade atacarComo(atacante, objetivo): permite que la estrategia de ataque
 * lea los atributos del personaje YA decorado (la capa más externa), y no los
 * del PersonajeBase que está en el centro de la cadena.
 */
public interface Personaje {
    String getNombre();
    int getAtaque();
    int getDefensa();
    int getVelocidad();
    int getHp();
    void setHp(int hp);
    EstrategiaAtaque getEstrategia();
    void setEstrategia(EstrategiaAtaque estrategia);
    ResultadoAtaque atacar(Personaje objetivo);
    ResultadoAtaque atacarComo(Personaje atacante, Personaje objetivo);
    String getDescripcion();
}
