package dosw.semana_4.patrones.ejercicio6;

public class Ejercicio6 {
    public static void main(String[] args) {
        UserProfile perfil = new UserProfile("Cristian", new GenreStrategy());

        perfil.addObserver(new HomePageComponent());
        perfil.addObserver(new SuggestedListComponent());
        perfil.addObserver(new NotificationService());

        System.out.println("--- Usuario cambia preferencia a: Historial ---");
        perfil.cambiarAlgoritmo(new HistoryStrategy());

        System.out.println("\n--- Usuario cambia preferencia a: Popularidad ---");
        perfil.cambiarAlgoritmo(new PopularityStrategy());
    }
}