package dosw.semana_4.patrones.ejercicio9;

public class Ejercicio9 {
    public static void main(String[] args) {
        AuthService authService = new AuthService();

        CredentialValidator cred = new CredentialValidator();
        PermissionValidator perm = new PermissionValidator();
        LocationValidator loc = new LocationValidator();
        TimeValidator time = new TimeValidator();
        cred.setNext(perm).setNext(loc).setNext(time);

        System.out.println("--- Empleado válido, dentro de horario y en Colombia ---");
        Credentials c1 = new Credentials("cmoreno", "Colombia", 10, false);
        AuthResult r1 = authService.login("EMPLEADO", c1);
        if (r1.isExitoso()) {
            cred.validate(c1);
            System.out.println("Acceso concedido a " + r1.getUsuario());
        }

        System.out.println("\n--- Externo autenticado con Google, pero fuera de horario ---");
        Credentials c2 = new Credentials("proveedor1", "Colombia", 23, false);
        AuthResult r2 = authService.login("EXTERNO", c2);
        if (r2.isExitoso()) {
            try {
                cred.validate(c2);
                System.out.println("Acceso concedido a " + r2.getUsuario());
            } catch (AccessDeniedException e) {
                System.out.println("Acceso denegado: " + e.getMessage());
            }
        }
    }
}