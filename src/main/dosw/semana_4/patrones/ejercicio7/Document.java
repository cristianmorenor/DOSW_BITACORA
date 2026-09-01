package dosw.semana_4.patrones.ejercicio7;

public class Document {
    private final String titulo;
    private final boolean requiereRevisionJuridica;
    private DocumentState state;

    public Document(String titulo, boolean requiereRevisionJuridica) {
        this.titulo = titulo;
        this.requiereRevisionJuridica = requiereRevisionJuridica;
        this.state = new DraftState();
    }

    public void setState(DocumentState state) {
        this.state = state;
    }

    public void approve() {
        state.approve(this);
    }

    public void reject() {
        state.reject(this);
    }

    public String getTitulo() { return titulo; }

    public boolean requiereRevisionJuridica() { return requiereRevisionJuridica; }

    public String getEstadoActual() {
        return state.getClass().getSimpleName();
    }
}