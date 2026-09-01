package dosw.semana_4.patrones.ejercicio7;

public class AutorHandler extends DocumentHandler {
    protected boolean canHandle(Document doc) {
        return doc.getEstadoActual().equals("DraftState");
    }

    protected void process(Document doc) {
        System.out.println("[Autor] Revisando borrador: " + doc.getTitulo());
        doc.approve();
    }
}