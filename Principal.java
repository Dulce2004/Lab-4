
/**
 * Esta clase es donde se crea la interacción con el usuario
 * 
 * @author: Dulce Ambrosio - 231143 , sección 20
 * @version: 13/11/2023
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kayac kayac = new Kayac(new ArrayList<>(), new ArrayList<>());

        while (true) {
            System.out.println("-----Bienvenido al Sistema de KAYAC-----");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Crear usuario");
            System.out.println("3. Salir");
            System.out.println("Ingrese la opción que desee: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("---------------------------------");
                    System.out.println("Ingrese el USUARIO: ");
                    String usernameLogin = scanner.next();
                    System.out.println("Ingrese su CONTRASEÑA: ");
                    String passwordLogin = scanner.next();

                    boolean loggedIn = kayac.login(usernameLogin, passwordLogin);

                    if (loggedIn) {
                        System.out.println("---------------------------------");
                        System.out.println("Ingrese la opción que desee: ");
                        System.out.println("1. Reservar un vuelo");
                        System.out.println("2. Confirmar vuelo");
                        System.out.println("3. Pérfil");
                        System.out.println("4. Salir");
                        int opcion2 = scanner.nextInt();
                        scanner.nextLine();
                        while (loggedIn) {

                        }
                        switch (opcion2) {
                            case 1:
                                System.out.println("--------------------------");
                                Reserva nuevaReserva = new Reserva(null, false, 0, null, usernameLogin, null, 0,
                                        null, 0, 0);
                                kayac.reservacion(usernameLogin, nuevaReserva);
                                break;

                            case 2:
                                System.out.println("--------------------------------");
                                System.out.println("Ingrese el número de reserva: ");
                                int opcionReserva = scanner.nextInt();
                                Reserva reservaSeleccionada = null;
                                int index;

                                int currentIndex = 1;

                                for (Reserva r : kayac.getReservas()) {
                                    if (r.getUsername().equals(usernameLogin)) {
                                        if (currentIndex == opcionReserva) {
                                            reservaSeleccionada = r;
                                            break;
                                        }
                                        currentIndex++;
                                    }
                                }

                                if (reservaSeleccionada != null) {
                                    System.out.println("Ingrese los datos para la confirmación:");
                                    kayac.confirmacion(reservaSeleccionada);
                                } else {
                                    System.out.println("Número de reserva no válido. Confirmación cancelada.");
                                }
                                break;
                            case 3:
                                System.out.println("Ingrese su nueva contraseña: ");
                                String nuevaPassword = scanner.next();
                                kayac.cambiarPassword(usernameLogin, nuevaPassword);
                                System.out.println("Contraseña cambiada exitosamente.");
                                break;
                            case 4:
                                System.out.println("Saliendo del Sistema de KAYAC....");
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Opción no válida. Volviendo al Menú Principal.");
                                break;
                        }
                    } else {
                        System.out.println("No se ha logrado iniciar sesión");
                    }

                    break;

                case 2:
                    System.out.println("-------------------------------------------");
                    System.out.println("Ingrese un nombre de usuario: ");
                    String usernameRegistro = scanner.next();
                    System.out.println("Ingrese una contraseña: ");
                    String passwordRegistro = scanner.next();
                    System.out.println("Ingrese el tipo de usuario (VIP o NoVIP): ");
                    String tipoUsuario = scanner.next();

                    kayac.registroUsuario(usernameRegistro, passwordRegistro, tipoUsuario);
                    System.out.println("Usuario creado exitosamente.");
                    break;
                case 3:
                    System.out.println("Saliendo del Sistema de KAYAC....");
                    System.exit(0);
                    break;
            }
        }

    }
}