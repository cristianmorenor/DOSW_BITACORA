package dosw.semana_4.patrones.ejercicio4;

public class Ejercicio4 {
    public static void main(String[] args) {
        System.out.println("--- Guerrero base ---");
        Character guerrero = CharacterDirector.guerreroElite();
        int poderBase = guerrero.attack();
        System.out.println("Poder total del ataque: " + poderBase);

        System.out.println("\n--- Guerrero con Escudo + Velocidad (poderes temporales) ---");
        Character potenciado = new ShieldDecorator(new SpeedDecorator(guerrero));
        int poderPotenciado = potenciado.attack();
        System.out.println("Poder total del ataque: " + poderPotenciado);

        System.out.println("\n--- Guerrero con los 3 poderes activos ---");
        Character maximizado = new InvisibilityDecorator(new ShieldDecorator(new SpeedDecorator(guerrero)));
        int poderMaximo = maximizado.attack();
        System.out.println("Poder total del ataque: " + poderMaximo);
    }
}