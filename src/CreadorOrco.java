public class CreadorOrco extends CreadorEnemigo {
    @Override
    public Personaje crearEnemigo() {
        Personaje p = new PersonajeBase("Orco bruto", 110, 32, 10, 6);
        p.setEstrategia(new AtaqueEspada());
        return p;
    }
}
