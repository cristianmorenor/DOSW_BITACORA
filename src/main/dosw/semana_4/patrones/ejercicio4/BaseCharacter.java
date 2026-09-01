package dosw.semana_4.patrones.ejercicio4;

public class BaseCharacter implements Character {
    private final String nombre;
    private final String armadura;
    private final String arma;
    private final String skill;
    private final int poderBase;

    public BaseCharacter(String nombre, String armadura, String arma, String skill, int poderBase) {
        this.nombre = nombre;
        this.armadura = armadura;
        this.arma = arma;
        this.skill = skill;
        this.poderBase = poderBase;
    }

    public String getNombre() { return nombre; }

    public int attack() {
        System.out.println(nombre + " ataca conn " + arma + " (armadura: " + armadura + ", skill: " + skill + ")");
        return poderBase;
    }
}