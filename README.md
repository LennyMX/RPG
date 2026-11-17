# RPG por turnos — Strategy, Factory Method y Decorator

Prototipo de consola en Java (sin dependencias, probado con Java 21).

## Compilar y ejecutar

```bash
mkdir out && javac -encoding UTF-8 -d out src/*.java
java -cp out Main            # modo interactivo
java -cp out Main --demo     # 4 corridas reproducibles (semilla fija) -> EJECUCION.txt
```

## Patrones

| Patrón | Dónde |
|---|---|
| Strategy | `EstrategiaAtaque` → `AtaqueEspada`, `AtaqueHechizo`, `AtaqueFlecha`, `AtaquePunalada` |
| Factory Method | `CreadorPersonaje` (Guerrero, Mago, Arquero, Pícaro) y `CreadorEnemigo` (Goblin, Orco, Dragón) |
| Decorator | `PersonajeDecorator` → `EspadaDecorator`, `ArmaduraDecorator`, `VenenoDecorator`, `AmuletoRegeneracionDecorator`, `BendicionDecorator` |

- Decoradores que modifican atributos: Espada, Armadura, Bendición.
- Decoradores que modifican el daño (`atacar`): Veneno (DOT) y Amuleto (regeneración al atacar).

## Cambio respecto al código base

Se añadió `atacarComo(atacante, objetivo)` a `Personaje`. Sin él, `PersonajeBase.atacar` pasa `this` a la
estrategia y el ataque ignora los bonos de los decoradores. Con él, la estrategia lee los atributos del
personaje ya decorado y los decoradores pueden modificar el resultado del ataque.
