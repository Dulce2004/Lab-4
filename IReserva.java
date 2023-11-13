/**
 * Esta clase es donde se crea los métodos que implementara nuesta clase KAYAC
 * 
 * @author: Dulce Ambrosio - 231143 , sección 20
 * @version: 13/11/2023
 */
public interface IReserva {
    /**
     * Método para crear el login para que el usuario pueda ingresar al sistema
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve valores son de tipo String
     */
    public boolean login(String username, String password);//

    /**
     * Método para Registrar los datos de la reserva
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve valores son de tipo String
     */
    public void registroUsuario(String username, String password, String tipo);//

    /**
     * Método para cambiar la contraseña
     * 
     * @param param1 los valores son de tipo String (username y nuevaPasssword)
     * @return devuelve un String (username y nuevaPasssword)
     */
    public void cambiarPassword(String username, String nuevaPassword);

    /**
     * Método para cambiar el tipo de cliente (de No VIP a VIP)
     * 
     * @param param1 los valores son de tipo String (username y nuevoTipo)
     * @return devuelve un String (username y nuevoTipo)
     */
    public void cambiarTipoUsuario(String username, String nuevoTipo);

    /**
     * Método para ingresar los datos de la reservación
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve valores son de tipo String
     */
    public void reservacion(String username, Reserva reserva);

    /**
     * Método para confirmar la reserva realizada por el usuario
     * 
     * @param param1 los valores son de tipo Reserva (reserva)
     * @return devuelve un Reserva (reserva)
     */
    public void confirmacion(Reserva reserva);

    /**
     * Método para mostrar el itinerario cuando se haga la confirmación
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve un los valores ingresados en la reserva
     */
    public void itinerario(String username);

    /**
     * Método para guardar el usuario en usuarios.csv
     * 
     * @param param1 los valores son de tipo archivo
     * @return devuelve un archivo
     */
    public void guardarUsuario();//

    /**
     * Método para guardar la reserva en el Reservas.csv
     * 
     * @param param1 los valores son de tipo archivo
     * @return devuelve un archivo
     */
    public void guardarReserva();

    /**
     * Método para leer los datos que se ingresan del usuario
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve valores son de tipo String
     */
    public void leerUsuario();

    /**
     * Método para leer los datos que se ingresan de la reserva
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve valores son de tipo String
     */
    public void leerReserva();

}