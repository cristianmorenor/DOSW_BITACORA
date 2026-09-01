package dosw.semana_4.patrones.ejercicio7;

public abstract class DocumentHandler {
    private DocumentHandler next;

    public DocumentHandler setNext(DocumentHandler next) {
        this.next = next;
        return next;
    }

    public void handle(Document doc) {
        if (canHandle(doc)) {
            process(doc);
        }
        if (next != null) {
            next.handle(doc);
        }
    }

    protected abstract boolean canHandle(Document doc);
    protected abstract void process(Document doc);
}