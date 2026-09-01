package dosw.semana_4.patrones.ejercicio7;

public class ApprovedState implements DocumentState {
    public void approve(Document doc) {
        System.out.println("[State] El documento ya está Aprobado, no hay más transición posible");
    }

    public void reject(Document doc) {
        System.out.println("[State] El documento ya está Aprobado, no se puede rechazar");
    }
}