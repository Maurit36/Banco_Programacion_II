package co.edu.uniquindio.banco.model;

import co.edu.uniquindio.banco.model.enumeracion.Categoria;
import co.edu.uniquindio.banco.model.enumeracion.TipoTrans;

import java.time.LocalDate;

public class Transaccion {

    /**
     * Atributos clase transaccion
     */
    private String remitente;
    private Cuenta cuentaOrigen;
    private String destinatario;
    private Cuenta cuentaDestino;
    private double valor;
    private LocalDate fecha;
    private Categoria categoria;
    private short costo;
    private TipoTrans tipoTrans;

    /**
     * Variable para relacionar padre
     */
    Banco ownedByBanco;

    /**
     * Constructor vacío
     */
    public Transaccion(Cuenta cuentaOrigen, Cuenta cuentaDestino, double valor, Categoria categoria,
                       TipoTrans tipoTrans) {
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
     * @param tipoTrans
     */
    public Transaccion(String remitente, Cuenta cuentaOrigen, String destinatario, Cuenta cuentaDestino,
                       double valor, LocalDate fecha, Categoria categoria, short costo,
                       TipoTrans tipoTrans) {
        this.remitente = remitente;
        this.cuentaOrigen = cuentaOrigen;
        this.destinatario = destinatario;
        this.cuentaDestino = cuentaDestino;
        this.valor = valor;
        this.fecha = fecha;
        this.categoria = categoria;
        this.costo = costo;
        this.tipoTrans = tipoTrans;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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

    public TipoTrans getTipoTrans() {
        return tipoTrans;
    }

    public void setTipoTrans(TipoTrans tipoTrans) {
        this.tipoTrans = tipoTrans;
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
                ", tipoTrans=" + tipoTrans +
                '}';
    }
}