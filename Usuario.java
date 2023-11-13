/**
 * Esta clase es donde se crean los atributos del Usuario
 * 
 * @author: Dulce Ambrosio - 231143 , sección 20
 * @version: 13/11/2023
 */
public class Usuario {

    private String username;
    private String password;
    private String tipo;

    /*
     * Class constructor
     */
    public Usuario(String username, String password, String tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }

    /*
     * setters y getters
     */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}