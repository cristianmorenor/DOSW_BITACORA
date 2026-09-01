package dosw.semana_4.patrones.ejercicio7;

public class JuridicoHandler extends DocumentHandler {
    protected boolean canHandle(Document doc) {
        return doc.requiereRevisionJuridica() && doc.getEstadoActual().equals("InReviewState");
    }

    protected void process(Document doc) {
        System.out.println("[Jurídico] Validando cláusulas legales");
    }
}