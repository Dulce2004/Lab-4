
/**
 * Esta clase es donde se crea la funcionalidad de los métodos 
 * implementados de la clase de Interfaz y es nuestrto controlador
 * 
 * @author: Dulce Ambrosio - 231143 , sección 20
 * @version: 13/11/2023
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Kayac implements IReserva {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Reserva> reservas;

    /*
     * Class constructor
     */
    public Kayac(ArrayList<Usuario> usuarios, ArrayList<Reserva> reservas) {
        this.usuarios = usuarios;
        this.reservas = reservas;
    }

    /*
     * setters y getters
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Método para cambiar la contraseña
     * 
     * @param param1 los valores son de tipo String (username y nuevaPasssword)
     * @return devuelve un String (username y nuevaPasssword)
     */
    @Override
    public void cambiarPassword(String username, String nuevaPassword) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                usuario.setPassword(nuevaPassword);
                guardarUsuario();
                break;
            }
        }
    }

    /**
     * Método para cambiar el tipo de cliente (de No VIP a VIP)
     * 
     * @param param1 los valores son de tipo String (username y nuevoTipo)
     * @return devuelve un String (username y nuevoTipo)
     */
    @Override
    public void cambiarTipoUsuario(String username, String nuevoTipo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                usuario.setTipo(nuevoTipo);
                guardarUsuario();
                break;
            }
        }

    }

    private String getTipoUsuario(String username) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario.getTipo();
            }
        }
        return null;
    }

    /**
     * Método para confirmar la reserva realizada por el usuario
     * 
     * @param param1 los valores son de tipo Reserva (reserva)
     * @return devuelve un Reserva (reserva)
     */
    @Override
    public void confirmacion(Reserva reserva) {
        Scanner scanner = new Scanner(System.in);

        if (reserva != null) {
            System.out.println("Para confirmar su reserva, ingrese los siguientes datos: ");
            System.out.println("Número de tarjeta: ");
            String numeroTarjeta = scanner.next();

            if (!"VIP".equalsIgnoreCase(getTipoUsuario(reserva.getUsername()))) {
                System.out.println("Ingrese el número de asiento: ");
                int numeroAsiento = scanner.nextInt();
                System.out.println("Ingrese la cantidad de maletas: ");
                int cantidadMaletas = scanner.nextInt();
                reserva.setNumeroAsiento(numeroAsiento);
                reserva.setCantidadMaletas(cantidadMaletas);
            }

            if (!"No VIP".equalsIgnoreCase(getTipoUsuario(reserva.getUsername()))) {
                System.out.println("Cantidad de cuotas (1 a 24): ");
                int cuotas = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente
                System.out.println("Ingrese la clase de vuelo (Coach o Primera clase): ");
                String claseVuelo = scanner.nextLine();
                reserva.setCuotas(cuotas);
                reserva.setClaseVuelo(claseVuelo);
            }

            reserva.setNumeroTarjeta(numeroTarjeta);

            guardarReserva();
            System.out.println("La confirmación se ha realizado de manera exitosa!");
            itinerario(reserva.getUsername());

        } else {
            System.out.println("No se encontró la reserva :()");
        }
    }

    /**
     * Método para guardar la reserva en el Reservas.csv
     * 
     * @param param1 los valores son de tipo archivo
     * @return devuelve un archivo
     */
    @Override
    public void guardarReserva() {
        try (BufferedWriter nuevaReserva = new BufferedWriter(new FileWriter("Reservas.csv"))) {
            for (Reserva reserva : reservas) {
                nuevaReserva.write(reserva.getUsername() + ";" + reserva.getFechaVuelo() + ";" + reserva.isTipoVuelo()
                        + ";"
                        + reserva.getCantidadBoletos() + ";" + reserva.getAerolinea()
                        + ";" + reserva.getNumeroTarjeta() + ";" + reserva.getCuotas() + ";" + reserva.getClaseVuelo()
                        + ";" + reserva.getNumeroAsiento() + ";" + reserva.getCantidadMaletas());
                nuevaReserva.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Método para guardar el usuario en usuarios.csv
     * 
     * @param param1 los valores son de tipo archivo
     * @return devuelve un archivo
     */
    @Override
    public void guardarUsuario() {
        try (BufferedWriter nuevoUsuario = new BufferedWriter(new FileWriter("usuarios.csv"))) {
            for (Usuario usuario : usuarios) {
                nuevoUsuario.write(usuario.getUsername() + ";" + usuario.getPassword() + ";" + usuario.getTipo());
                nuevoUsuario.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Método para mostrar el itinerario cuando se haga la confirmación
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve un los valores ingresados en la reserva
     */
    @Override
    public void itinerario(String username) {
        System.out.println("-----Itinerario de Reservas-----");
        for (Reserva reserva : reservas) {
            if (reserva.getUsername().equals(username)) {
                System.out.println("Usuario: " + reserva.getUsername());
                System.out.println("Fecha de vuelo: " + reserva.getFechaVuelo());
                System.out.println("Tipo de Vuelo: " + reserva.isTipoVuelo());
                System.out.println("Cantidad de boletos: " + reserva.getCantidadBoletos());
                System.out.println("Aerolínea: " + reserva.getAerolinea());
                System.out.println("-------------------");
            }
        }

    }

    /**
     * Método para leer los datos que se ingresan de la reserva
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve valores son de tipo String
     */
    @Override
    public void leerReserva() {
        try (BufferedReader br = new BufferedReader(new FileReader("Reservas.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String username = parts[0];
                String fechaVuelo = parts[1];
                boolean tipoVuelo = Boolean.parseBoolean(parts[2]);
                int cantidadBoletos = Integer.parseInt(parts[3]);
                String aerolinea = parts[4];
                String numeroTarjeta = parts[5];
                int cuotas = Integer.parseInt(parts[6]);
                String claseVuelo = parts[7];
                int numeroAsiento = Integer.parseInt(parts[8]);
                int cantidadMaletas = Integer.parseInt(parts[9]);

                Reserva reserva = new Reserva(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, username,
                        numeroTarjeta, cuotas, claseVuelo, numeroAsiento, cantidadMaletas);
                reservas.add(reserva);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para leer los datos que se ingresan del usuario
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve valores son de tipo String
     */
    @Override
    public void leerUsuario() {
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String username = parts[0];
                String password = parts[1];
                String tipo = parts[2];

                Usuario usuario = new Usuario(username, password, tipo);
                usuarios.add(usuario);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Método para crear el login para que el usuario pueda ingresar al sistema
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve valores son de tipo String
     */
    @Override
    public boolean login(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método para Registrar los datos de la reserva
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve valores son de tipo String
     */
    @Override
    public void registroUsuario(String username, String password, String tipo) {
        if (usuarios.isEmpty()) {
            Usuario nuevUsuario = new Usuario(username, password, tipo);
            usuarios.add(nuevUsuario);
        } else {
            for (Usuario usuario : usuarios) {
                if (usuario.getUsername().equals(username)) {

                }
            }
        }
        guardarUsuario();
    }

    /**
     * Método para ingresar los datos de la reservación
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve valores son de tipo String
     */
    @Override
    public void reservacion(String username, Reserva reserva) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Para reservar un vuelo ingrese los siguientes datos: ");
        System.out.println("Ingerese el nombre de usuario: ");
        String username2 = scanner.nextLine();
        System.out.println("Fecha de Vuelo (DD/MM/YYYY): ");
        String fechaVuelo = scanner.nextLine();
        System.out.println("¿El vuelo es de ida y vuelta (true/false)?: ");
        boolean tipoVuelo = scanner.nextBoolean();
        System.out.println("Cantidad de Boletos: ");
        int cantidadBoletos = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Aerolínea: ");
        String aerolinea = scanner.nextLine();

        reserva.setUsername(username2);
        reserva.setFechaVuelo(fechaVuelo);
        reserva.setTipoVuelo(tipoVuelo);
        reserva.setCantidadBoletos(cantidadBoletos);
        reserva.setAerolinea(aerolinea);

        reservas.add(reserva);
        guardarReserva();
        System.out.println("La resereva se ha guardado correctamente....");
    }

}