package dosw.semana_4.patrones.ejercicio5;

public class LegacyBankService {

    public void openConnection() {
        System.out.println("[Legacy] Abriendo conexión con el banco antiguo...");
    }

    public void authenticate() {
        System.out.println("[Legacy] Autenticando con protocolo legacy...");
    }

    public boolean verifyBalance(String account, int cents) {
        System.out.println("[Legacy] Verificando saldo en centavos: " + cents);
        return true;
    }

    public void executeTransaction(String account, int cents) {
        System.out.println("[Legacy] Ejecutando transacción de " + cents + " centavos en cuenta " + account);
    }

    public void closeConnection() {
        System.out.println("[Legacy] Cerrando conexión con el banco antiguo...");
    }
}