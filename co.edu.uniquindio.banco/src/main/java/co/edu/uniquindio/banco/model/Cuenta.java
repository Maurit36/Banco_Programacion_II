package co.edu.uniquindio.banco.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cuenta {

    /**
     * Atributos clase cuenta
     */
    private String numeroCuenta;
    private double saldo;
    private Usuario usuario;

    /**
     * Variable para relacionar padre
     */
    Banco ownedByBanco;

    /**
     * ArrayList relacionadas de la clase
     */
    List<Transaccion> listaTransacciones = new ArrayList<>();

    /**
     * Constructor vacío
     */
    public Cuenta() {
    }

    /**
     * Constructor con parámetros
     * @param numeroCuenta
     * @param saldo
     * @param usuario
     * @param listaTransacciones
     */
    public Cuenta(String numeroCuenta, double saldo, Usuario usuario, List<Transaccion> listaTransacciones) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.usuario = usuario;
        this.listaTransacciones = listaTransacciones;
    }

    /**
     * Getters y Setters atributos clase cuenta
     * @return
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     *Getters y Setters de variable para relacionar padre
     * @return
     */
    public Banco getOwnedByBanco() {
        return ownedByBanco;
    }

    public void setOwnedByBanco(Banco ownedByBanco) {
        this.ownedByBanco = ownedByBanco;
    }

    /**
     * Getters y Setters de ArrayList relacionadas de la clase
     * @return
     */
    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(List<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    /**
     * To String clase transaccion
     * @return
     */
    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", usuario=" + usuario +
                '}';
    }

    /**
     * Método para generar el número de cuenta de ahorros de forma aleatoria
     * @return
     */
    public String generarNumeroCuenta() {
        int valorMinimo = 524049384;
        int valorMaximo = 584049384;
        Random random = new Random();
        int numeroAleatorio = valorMinimo + random.nextInt((valorMaximo - valorMinimo)+1);
        return String.valueOf(numeroAleatorio);
    }

    /**
     * Método para obtener información de las cuentas y usuarios asociados
     * @return
     */
    public String obtenerInformacion() {
        String informacion = "";
        informacion = informacion +
                "Numero cuenta: " + getNumeroCuenta() + "\n" +
                "Saldo: " + getSaldo() + "\n";

        Usuario usuario = getUsuario();
        if (usuario != null){
            informacion += "Usuario asociado: " + usuario.toString() + "\n";
        }else {
            informacion += "Usuario asociado: No disponible" + "\n";
        }
        return informacion;
    }

    /**
     * Método para mostrar información de las transaferencias realizadas del ArrayList creado
     */
    public void mostrarInformacionTransacciones() {
        for (Transaccion transaccion: listaTransacciones){
            System.out.println(transaccion);
        }
    }

    /**
     *Método para consultar el listado de transacciones realizadas al corte de la fecha de consulta
     * @param fechaConsulta
     */
    public void consultarTransaccionFecha(LocalDateTime fechaConsulta) {
        for (Transaccion transaccion : listaTransacciones){
            if (transaccion.getFecha() == fechaConsulta){
                System.out.println("Las transacciones realizadas al corte de la fecha: "
                        + fechaConsulta + "\n" + transaccion);
            }
        }
    }
}