package dosw.semana_4.patrones.ejercicio7;

public class FinancieroHandler extends DocumentHandler {
    protected boolean canHandle(Document doc) {
        return doc.getEstadoActual().equals("InReviewState");
    }

    protected void process(Document doc) {
        System.out.println("[Financiero] Validando presupuesto asociado");
        doc.approve();
    }
}