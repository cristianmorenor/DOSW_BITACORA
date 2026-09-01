package dosw.semana_4.patrones.ejercicio10;

import java.util.ArrayList;
import java.util.List;

public class ImageEditor {
    private final Image imagenBase = new BaseImage();
    private final List<ApplyFilterCommand> filtrosActivos = new ArrayList<>();

    public void addFiltro(ApplyFilterCommand comando) {
        filtrosActivos.add(comando);
        System.out.println("[+] Filtro aplicado: " + comando.getNombreFiltro());
        mostrarEstado();
    }

    public void removeFiltro(ApplyFilterCommand comando) {
        filtrosActivos.remove(comando);
        System.out.println("[-] Filtro deshecho: " + comando.getNombreFiltro());
        mostrarEstado();
    }

    public Image getImagenActual() {
        Image imagen = imagenBase;
        for (ApplyFilterCommand comando : filtrosActivos) {
            imagen = comando.aplicar(imagen);
        }
        return imagen;
    }

    public void mostrarEstado() {
        System.out.println("    Estado actual: " + getImagenActual().render());
    }
}