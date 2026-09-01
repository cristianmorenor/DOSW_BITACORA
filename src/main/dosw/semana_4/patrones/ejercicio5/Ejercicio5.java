package dosw.semana_4.patrones.ejercicio5;

public class Ejercicio5 {
    public static void main(String[] args) {
        System.out.println("--- Desarrollador solo llama procesarPago() ---");
        BankFacade banco = new BankFacade("ACC-4521");
        banco.procesarPago(230.75);
    }
}