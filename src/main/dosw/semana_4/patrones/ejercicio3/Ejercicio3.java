package dosw.semana_4.patrones.ejercicio3;

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("--- Cliente pide reporte PDF ---");
        ReportGenerator reportePdf = ReportFactory.create("PDF");
        reportePdf.generate();

        System.out.println("\n--- Cliente pide reporte CSV ---");
        ReportGenerator reporteCsv = ReportFactory.create("CSV");
        reporteCsv.generate();

        System.out.println("\n--- Cliente pide reporte Excel ---");
        ReportGenerator reporteExcel = ReportFactory.create("EXCEL");
        reporteExcel.generate();
    }
}