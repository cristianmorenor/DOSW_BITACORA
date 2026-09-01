package dosw.semana_4.patrones.ejercicio3;

public class ReportFactory {
    public static ReportGenerator create(String tipo) {
        return switch (tipo) {
            case "PDF" -> new PdfReport();
            case "EXCEL" -> new ExcelReport();
            case "CSV" -> new CsvReport();
            default -> throw new IllegalArgumentException("Tipo de reporte no soportado: " + tipo);
        };
    }
}