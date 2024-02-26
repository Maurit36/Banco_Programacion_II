package co.edu.uniquindio.seguimientoBanco.model;

import co.edu.uniquindio.seguimientoBanco.model.enumeracion.Categoria;
import co.edu.uniquindio.seguimientoBanco.model.enumeracion.TipoTransaccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    /**
     * Atributos clase banco
     */
    private String nombre;
    private String direccion;
    private String telefono;

    /**
     * ArrayList relacionadas de la clase
     */
    List<Usuario> listaUsuarios = new ArrayList<>();
    List<Cuenta> listaCuentas = new ArrayList<>();

    /**
     * Constructor vacío
     */
    public Banco() {
    }

    /**
     * Constructor con parámetros
     * @param nombre
     * @param direccion
     * @param telefono
     * @param listaUsuarios
     * @param listaCuentas
     */
    public Banco(String nombre, String direccion, String telefono, List<Usuario> listaUsuarios,
                 List<Cuenta> listaCuentas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaUsuarios = listaUsuarios;
        this.listaCuentas = listaCuentas;
    }

    /**
     * Getters y Setters atributos clase banco
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Getters y Setters de ArrayList relacionadas de la clase
     * @return
     */
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    /**
     * To String clase banco
     * @return
     */
    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    /**
     * Método para crear usuario
     * @param nombre
     * @param direccion
     * @param cedula
     * @param correo
     * @param contrasena
     */
    public void crearUsuario(String nombre, String direccion, String cedula,
                             String correo, String contrasena) {
        int resultadoBusqueda = devolverPosicionUsuario(cedula);
        if (resultadoBusqueda == -1) {
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setDireccion(direccion);
            usuario.setCedula(cedula);
            usuario.setCorreo(correo);
            usuario.setContrasena(contrasena);
            getListaUsuarios().add(usuario);
            System.out.println("Usuario creado exitosamente");
        } else {
            System.out.println("El usuario ya esta creado en el sistema");
        }
    }

    /**
     * Método para crear cuenta
     * @param saldo
     */
    public void crearCuenta(double saldo) {
        Cuenta cuenta = new Cuenta();
        String cuentaUnico = generarNumeroCuentaUnico();
        cuenta.setNumeroCuenta(cuentaUnico);
        cuenta.setSaldo(saldo);
        getListaCuentas().add(cuenta);
    }

    /**
     * Método para generar número único para cuenta de ahorros
     * @return
     */
    private String generarNumeroCuentaUnico() {
        Cuenta cuenta = new Cuenta();
        String numeroCuenta;
        do {
            numeroCuenta = cuenta.generarNumeroCuenta();
        }while (verificarNumeroCuenta(numeroCuenta));
        return numeroCuenta;
    }

    /**
     * Método para verificar el número único para cuenta de ahorros
     * @param numeroCuenta
     * @return
     */
    private boolean verificarNumeroCuenta(String numeroCuenta) {
        boolean bandera = false;
        for (Cuenta cuenta: listaCuentas){
            if (cuenta.getNumeroCuenta().equalsIgnoreCase(numeroCuenta)){
                bandera = true;
            }
        }
        return bandera;
    }

    /**
     * Método para devolver posición de usuario
     * @param cedula
     * @return
     */
    private int devolverPosicionUsuario(String cedula) {
        int posicion = -1;
        boolean bandera = false;
        for (int i = 0; i < listaUsuarios.size() && bandera == false; i++) {
            if (listaUsuarios.get(i).getCedula().equalsIgnoreCase(cedula)) {
                bandera = true;
                posicion = i;
            }
        }
        return posicion;
    }

    /**
     * Método para eliminar usuario
     * @param cedula
     */
    public void eliminarUsuario(String cedula) {
        for(Usuario usuario : listaUsuarios){
            if (usuario.getCedula().equalsIgnoreCase(cedula)){
                getListaUsuarios().remove(usuario);
                break;
            }
        }
    }

    /**
     * Método para actualizar información del usuario
     * @param cedula
     * @param nombre
     * @param direccion
     * @param correo
     * @param contrasena
     */
    public void actualizarUsuario(String cedula, String nombre, String direccion,
                                  String correo, String contrasena) {
        for (Usuario usuario : listaUsuarios){
            if (usuario.getCedula().equalsIgnoreCase(cedula)){
                usuario.setNombre(nombre);
                usuario.setDireccion(direccion);
                usuario.setCorreo(correo);
                usuario.setContrasena(contrasena);
                break;
            }
        }
    }

    /**
     * Método para obtener los usuarios en el ArrayList creado
     * @return
     */
    public List<Usuario> obtenerUsuarios() {
        return getListaUsuarios();
    }

    /**
     * Método para obtener las cuentas en el ArrayList creado
     * @return
     */
    public List<Cuenta> obtenerCuentas() {
        return getListaCuentas();
    }

    /**
     * Método para determinar si existe o no una cuenta de ahorros
     * @param idNumeroCuenta
     * @return
     */
    public Cuenta consultarCuentaAhorros(String idNumeroCuenta){
        Cuenta cuentaEncontrada = new Cuenta();
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getNumeroCuenta().equals(idNumeroCuenta)) {
                cuentaEncontrada = cuenta;
                break;
            }
        }
        return cuentaEncontrada;
    }

    /**
     * Método para revisar si el saldo de la cuenta es necesario para realizar la transacción
     * @param idNumeroCuenta
     * @param monto
     * @return
     */
    public boolean revisarSaldoNecesario(String idNumeroCuenta, double monto){
        boolean saldoNecesario = false;
        Cuenta cuentaOrigen = consultarCuentaAhorros(idNumeroCuenta);
        double saldo = cuentaOrigen.getSaldo();
        if (saldo >= (monto + 200)){
            saldoNecesario = true;
        }
        return saldoNecesario;
    }

    /**
     * Método para retornar una cuenta de ahorros existente
     * @param idNumeroCuenta
     * @return
     */
    public Cuenta obtenerCuenta(String idNumeroCuenta) {
        Cuenta cuentaExistente = new Cuenta();
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getNumeroCuenta().equals(idNumeroCuenta)) {
                cuentaExistente = cuenta;
                break;
            }
        }
        return cuentaExistente;
    }

    /**
     * Método para buscar una cuenta en el ArrayList
     * @param idCuenta
     * @return
     */
    public boolean buscarCuenta(String idCuenta) {
        boolean cuentaExiste = false;
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getNumeroCuenta().equals(idCuenta)) {
                cuentaExiste = true;
            }
        }
        return cuentaExiste;
    }

    /**
     * Método para crear transacciones
     * @param idCuentaOrigen
     * @param idCuentaDestino
     * @param valor
     * @param categoria
     * @return
     */
    public boolean crearTransaccion(String idCuentaOrigen, String idCuentaDestino, double valor,
                                    Categoria categoria){
        boolean transaccionExitosa = false;
        Cuenta cuentaOrigen = obtenerCuenta(idCuentaOrigen);
        Cuenta cuentaDestino = obtenerCuenta(idCuentaDestino);

        if (buscarCuenta(idCuentaDestino) && buscarCuenta(idCuentaOrigen) &&
                revisarSaldoNecesario(idCuentaOrigen, valor)) {
            Transaccion transaccionCuentaOrigen = new Transaccion(cuentaOrigen, cuentaDestino, valor,
                    categoria, TipoTransaccion.SALIDA);
            cuentaOrigen.getListaTransacciones().add(transaccionCuentaOrigen);
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo()-valor-200);
            Transaccion transaccionCuentaLlegada = new Transaccion(cuentaOrigen, cuentaDestino, valor,
                    categoria, TipoTransaccion.ENTRADA);
            cuentaDestino.getListaTransacciones().add(transaccionCuentaLlegada);
            cuentaDestino.setSaldo(cuentaDestino.getSaldo()+valor);

            transaccionExitosa = true;
        }
        return transaccionExitosa;
    }

    /**
     * Método que detalla las transacciones realizadas 1 mes despues de una fecha ingresada
     * @param idCuentaAhorros
     * @param fechaInicio
     * @return
     */
    public List<Transaccion> clasificarCuentasMes(String idCuentaAhorros, LocalDate fechaInicio){
        List<Transaccion> transaccionesMes = new ArrayList<Transaccion>();
        Cuenta cuenta = obtenerCuenta(idCuentaAhorros);
        for (Transaccion transaccion : cuenta.getListaTransacciones()) {
            for (LocalDate fecha = fechaInicio; fecha.isBefore(fechaInicio.plusDays(30)); fecha =
                    fecha.plusDays(1)){
                if(transaccion.getFecha().equals(fecha));
                transaccionesMes.add(transaccion);
            }
        }
        return transaccionesMes;
    }

    /**
     * Método para sumar las transacciones de 1 mes por el tipo de transacción realizada
     * @param idCuentaAhorros
     * @param fechaInicio
     * @param tipoTransaccion
     * @return
     */
    public double sumarMontoTipoTransaccion(String idCuentaAhorros, LocalDate fechaInicio,
                                            TipoTransaccion tipoTransaccion){
        float montosTipoMes = 0;
        List<Transaccion> transaccionesMes = clasificarCuentasMes(idCuentaAhorros, fechaInicio);
        for (Transaccion transaccion : transaccionesMes) {
            if(transaccion.getTipoTransaccion().equals(tipoTransaccion)){
                montosTipoMes += transaccion.getValor();
            }
        } return montosTipoMes;
    }

    /**
     * PTE - Método para cálcular el porcentaje de gastos
     * @param monto1
     * @param monto2
     * @return
     */
    public double calcularPorcentaje(double monto1, double monto2){
        return ((monto1)/(monto1 + monto2))*100;
    }

    /**
     * Método para sumar las transacciones de 1 mes por la categoría de transacción realizada
     * @param idCuentaAhorros
     * @param fechaInicio
     * @param categoria
     * @return
     */
    public double sumarMontoCategoriaTransaccion(String idCuentaAhorros, LocalDate fechaInicio,
                                                 Categoria categoria){
        double montosCategoriaMes = 0;
        List<Transaccion> transaccionesMes = clasificarCuentasMes(idCuentaAhorros, fechaInicio);
        for (Transaccion transaccion : transaccionesMes) {
            if(transaccion.getTipoTransaccion().equals(TipoTransaccion.SALIDA)){
                if (transaccion.getCategoria().equals(categoria)) {
                    montosCategoriaMes += transaccion.getValor();
                }
            }
        } return montosCategoriaMes;
    }

    /**
     * Método para obtener los gastos e ingresos del mes por tipo y categoría de transacción
     * @param idCuentaAhorros
     * @param fechaInicio
     */
    public void obtenerGastosIngresosMes(String idCuentaAhorros, LocalDate fechaInicio){
        double ingresosMes = sumarMontoTipoTransaccion(idCuentaAhorros, fechaInicio,
                TipoTransaccion.ENTRADA);
        double gastosMes = sumarMontoTipoTransaccion(idCuentaAhorros, fechaInicio, TipoTransaccion.SALIDA);
        double porcentajesGastosMes = calcularPorcentaje(gastosMes, ingresosMes);
        double porcentajeIngresosMes = calcularPorcentaje(ingresosMes, gastosMes);
        double gastosFacturas = sumarMontoCategoriaTransaccion(idCuentaAhorros, fechaInicio,
                Categoria.FACTURA);
        double gastosGasolina = sumarMontoCategoriaTransaccion(idCuentaAhorros, fechaInicio,
                Categoria.GASOLINA);
        double gastosRopa = sumarMontoCategoriaTransaccion(idCuentaAhorros, fechaInicio,
                Categoria.ROPA);
        double gastosViajes = sumarMontoCategoriaTransaccion(idCuentaAhorros, fechaInicio,
                Categoria.VIAJE);
    }
}