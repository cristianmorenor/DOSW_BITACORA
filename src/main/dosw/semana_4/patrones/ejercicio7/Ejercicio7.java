package dosw.semana_4.patrones.ejercicio7;

public class Ejercicio7 {
    public static void main(String[] args) {
        AutorHandler autor = new AutorHandler();
        LiderHandler lider = new LiderHandler();
        JuridicoHandler juridico = new JuridicoHandler();
        FinancieroHandler financiero = new FinancieroHandler();
        autor.setNext(lider).setNext(juridico).setNext(financiero);

        System.out.println("--- Documento SIN revisión jurídica requerida ---");
        Document contrato = new Document("Propuesta comercial", false);
        System.out.println("Estado inicial: " + contrato.getEstadoActual());
        autor.handle(contrato);
        System.out.println("Estado final: " + contrato.getEstadoActual());

        System.out.println("\n--- Documento CON revisión jurídica requerida ---");
        Document acuerdo = new Document("Acuerdo de confidencialidad", true);
        System.out.println("Estado inicial: " + acuerdo.getEstadoActual());
        autor.handle(acuerdo);
        System.out.println("Estado final: " + acuerdo.getEstadoActual());
    }
}