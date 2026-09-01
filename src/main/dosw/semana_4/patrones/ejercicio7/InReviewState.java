package dosw.semana_4.patrones.ejercicio7;

public class InReviewState implements DocumentState {
    public void approve(Document doc) {
        System.out.println("[State] En Revisión → Aprobado");
        doc.setState(new ApprovedState());
    }

    public void reject(Document doc) {
        System.out.println("[State] En Revisión → Rechazado");
        doc.setState(new RejectedState());
    }
}