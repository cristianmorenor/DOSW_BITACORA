package dosw.semana_4.patrones.ejercicio5;

public class BankFacade {
    private final LegacyBankService legacy;
    private final PaymentProcessor adapter;

    public BankFacade(String cuenta) {
        this.legacy = new LegacyBankService();
        this.adapter = new LegacyBankAdapter(legacy, cuenta);
    }

    public void procesarPago(double monto) {
        legacy.openConnection();
        legacy.authenticate();
        System.out.println("Facade Inicializando contexto de sesión...");
        System.out.println("[Facade] Validando parámetros de la transacción...");
        adapter.pay(monto);
        System.out.println("[Facade] Registrando comprobante...");
        System.out.println("[Facade] Notificando al usuario...");
        legacy.closeConnection();
    }
}