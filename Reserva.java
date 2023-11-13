/**
 * Esta clase es donde se crean los atributos de la Reserva
 * 
 * @author: Dulce Ambrosio - 231143 , sección 20
 * @version: 13/11/2023
 */
public class Reserva {

    private String fechaVuelo;
    private boolean tipoVuelo;
    private int cantidadBoletos;
    private String aerolinea;
    private String username;
    private String numeroTarjeta;
    private int cuotas;
    private String claseVuelo;
    private int numeroAsiento;
    private int cantidadMaletas;

    /*
     * Class constructor
     */
    public Reserva(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String username,
            String numeroTarjeta, int cuotas, String claseVuelo, int numeroAsiento, int cantidadMaletas) {
        this.fechaVuelo = fechaVuelo;
        this.tipoVuelo = tipoVuelo;
        this.cantidadBoletos = cantidadBoletos;
        this.aerolinea = aerolinea;
        this.username = username;
        this.numeroTarjeta = numeroTarjeta;
        this.cuotas = cuotas;
        this.claseVuelo = claseVuelo;
        this.numeroAsiento = numeroAsiento;
        this.cantidadMaletas = cantidadMaletas;
    }

    /*
     * setters y getters
     */
    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public boolean isTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(boolean tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public String getClaseVuelo() {
        return claseVuelo;
    }

    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public int getCantidadMaletas() {
        return cantidadMaletas;
    }

    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }

}