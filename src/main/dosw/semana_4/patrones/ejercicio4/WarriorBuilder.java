package dosw.semana_4.patrones.ejercicio4;

public class WarriorBuilder {
    private String armadura;
    private String arma;
    private String skill;
    private int poderBase = 10;

    public WarriorBuilder setArmor(String armadura) {
        this.armadura = armadura;
        return this;
    }

    public WarriorBuilder setWeapon(String arma) {
        this.arma = arma;
        return this;
    }

    public WarriorBuilder setSkill(String skill) {
        this.skill = skill;
        return this;
    }

    public Character build() {
        return new BaseCharacter("Guerrero", armadura, arma, skill, poderBase);
    }
}