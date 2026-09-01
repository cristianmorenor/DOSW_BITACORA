package dosw.semana_4.patrones.ejercicio4;

public class CharacterDirector {
    public static Character guerreroElite() {
        return new WarriorBuilder()
                .setArmor("Platino")
                .setWeapon("Espada legendaria")
                .setSkill("Furia")
                .build();
    }
}