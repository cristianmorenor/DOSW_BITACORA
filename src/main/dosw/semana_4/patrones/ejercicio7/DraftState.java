package dosw.semana_4.patrones.ejercicio7;

public class DraftState implements DocumentState {
    public void approve(Document doc) {
        System.out.println("[State] Borrador → En Revisión");
        doc.setState(new InReviewState());
    }

    public void reject(Document doc) {
        System.out.println("[State] Borrador → Rechazado");
        doc.setState(new RejectedState());
    }
}