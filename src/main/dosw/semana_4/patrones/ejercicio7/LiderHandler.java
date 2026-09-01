package dosw.semana_4.patrones.ejercicio7;

public class LiderHandler extends DocumentHandler {
    protected boolean canHandle(Document doc) {
        return doc.getEstadoActual().equals("InReviewState");
    }

    protected void process(Document doc) {
        System.out.println("[Líder] Validando alineación con objetivos del equipo");
    }
}