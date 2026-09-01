package dosw.semana_4.patrones.ejercicio7;

public interface DocumentState {
    void approve(Document doc);
    void reject(Document doc);
}