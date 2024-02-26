package co.edu.uniquindio.seguimientoBanco.model;

import co.edu.uniquindio.seguimientoBanco.model.enumeracion.Categoria;
import co.edu.uniquindio.seguimientoBanco.model.enumeracion.TipoTransaccion;

import java.time.LocalDateTime;

public class Transaccion {

    /**
     * Atributos clase transaccion
     */
    private String remitente;
    private Cuenta cuentaOrigen;
    private String destinatario;
    private Cuenta cuentaDestino;
    private double valor;
    private LocalDateTime fecha;
    private Categoria categoria;
    private short costo;
    private TipoTransaccion tipoTransaccion;

    /**
     * Variable para relacionar padre
     */
    Banco ownedByBanco;

    /**
     * Constructor vacío
     */
    public Transaccion(Cuenta cuentaOrigen, Cuenta cuentaDestino, double valor, Categoria categoria,
                       TipoTransaccion tipoTransaccion) {
    }

    /**
     * Constructor con parámetros
     * @param remitente
     * @param cuentaOrigen
     * @param destinatario
     * @param cuentaDestino
     * @param valor
     * @param fecha
     * @param categoria
     * @param costo
     * @param tipoTransaccion
     */
    public Transaccion(String remitente, Cuenta cuentaOrigen, String destinatario, Cuenta cuentaDestino, double valor,
                       LocalDateTime fecha, Categoria categoria, short costo, TipoTransaccion tipoTransaccion) {
        this.remitente = remitente;
        this.cuentaOrigen = cuentaOrigen;
        this.destinatario = destinatario;
        this.cuentaDestino = cuentaDestino;
        this.valor = valor;
        this.fecha = fecha;
        this.categoria = categoria;
        this.costo = costo;
        this.tipoTransaccion = tipoTransaccion;
    }

    /**
     * Getters y Setters atributos de clase transaccion
     * @return
     */
    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public short getCosto() {
        return costo;
    }

    public void setCosto(short costo) {
        this.costo = costo;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    /**
     * Getters y Setters de variable para relacionar padre
     */
    public Banco getOwnedByBanco() {
        return ownedByBanco;
    }

    public void setOwnedByBanco(Banco ownedByBanco) {
        this.ownedByBanco = ownedByBanco;
    }

    /**
     * To String clase transaccion
     * @return
     */
    @Override
    public String toString() {
        return "Transaccion{" +
                "remitente='" + remitente + '\'' +
                ", cuentaOrigen=" + cuentaOrigen +
                ", destinatario='" + destinatario + '\'' +
                ", cuentaDestino=" + cuentaDestino +
                ", valor='" + valor + '\'' +
                ", fecha=" + fecha +
                ", categoria=" + categoria +
                ", costo=" + costo +
                ", tipoTransaccion=" + tipoTransaccion +
                '}';
    }
}