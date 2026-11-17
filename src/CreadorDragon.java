public class CreadorDragon extends CreadorEnemigo {
    @Override
    public Personaje crearEnemigo() {
        Personaje p = new PersonajeBase("Dragón ancestral", 150, 22, 12, 12);
        p.setEstrategia(new AtaqueHechizo());
        return p;
    }
}
