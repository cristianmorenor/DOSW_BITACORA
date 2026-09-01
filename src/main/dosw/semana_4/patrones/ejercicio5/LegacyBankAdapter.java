package dosw.semana_4.patrones.ejercicio5;

public class LegacyBankAdapter implements PaymentProcessor {
    private final LegacyBankService legacy;
    private final String cuenta;

    public LegacyBankAdapter(LegacyBankService legacy, String cuenta) {
        this.legacy = legacy;
        this.cuenta = cuenta;
    }

    public void pay(double amount) {
        int cents = (int) Math.round(amount * 100);
        if (legacy.verifyBalance(cuenta, cents)) {
            legacy.executeTransaction(cuenta, cents);
        }
    }
}