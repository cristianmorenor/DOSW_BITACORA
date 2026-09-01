package dosw.semana_4.patrones.ejercicio7;

public class RejectedState implements DocumentState {
    public void approve(Document doc) {
        System.out.println("[State] El documento ya está Rechazado, no se puede aprobar");
    }

    public void reject(Document doc) {
        System.out.println("[State] El documento ya está Rechazado, no hay más transición posible");
    }
}