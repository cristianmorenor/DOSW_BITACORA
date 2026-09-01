package dosw.semana_4.patrones.ejercicio3;

import java.util.List;

public abstract class ReportGenerator {

    protected List<String> datosCrudos;
    protected List<String> datosProcesados;
    protected String contenidoFormateado;

    public final void generate() {
        fetchData();
        processData();
        applyFormat();
        exportFile();
    }

    protected void fetchData() {
        datosCrudos = List.of("Ventas: 1400", "Gastos: 900", "Utilidad: 400");
        System.out.println("Datos obtenidos: " + datosCrudos);
    }

    protected void processData() {
        datosProcesados = datosCrudos.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Datos procesados: " + datosProcesados);
    }

    protected abstract void applyFormat();

    protected abstract void exportFile();
}