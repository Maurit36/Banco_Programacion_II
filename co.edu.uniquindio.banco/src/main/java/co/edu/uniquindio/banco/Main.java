package co.edu.uniquindio.banco;

import co.edu.uniquindio.banco.model.Banco;
import co.edu.uniquindio.banco.model.Cuenta;
import co.edu.uniquindio.banco.model.Usuario;
import co.edu.uniquindio.banco.model.Transaccion;
import co.edu.uniquindio.banco.model.enumeracion.Categoria;

import java.time.LocalDate;
import java.util.List;

public class Main {

    /**
     * Main principal del proyecto
     * @param args
     */
    public static void main(String[] args) {

        //Declaración método inicializar datos prueba
        Banco banco = inicializarDatosPrueba();

        /*CRUD Usuario*/

        //Create
        crearUsuario("Carlos", "barrio Cecilia", "1094029384", "carlos@hotmail.com",
                "1724", banco);
        crearUsuario("Sandra", "Conjunto Sinai", "1097738093", "sandra@hotmail.com",
                "9083", banco);
        crearUsuario("Miguel", "Barrio la milagrosa", "1083849302",
                "miguel@hotmail.com","4039", banco);
        crearUsuario("Sara", "Barrio la castellana", "1032940394",
                "sara@hotmail.com","7645", banco);

        //Read
        System.out.println("\n" + "-----> Información Usuarios Creados: " + "\n");
        mostrarInformacionUsuarios(banco);

        //Update
        actualizarUsuario("1083849302", "Andres", "Barrio la adiela",
                "andres@gmail.com", "1234", banco);
        System.out.println("\n" + "-----> Informacion Actualizada: " + "\n");
        mostrarInformacionUsuarios(banco);

        //Delate
        eliminarUsuario("1094029384", banco);
        System.out.println("\n" + "-----> Informacion Eliminada: " + "\n" );
        mostrarInformacionUsuarios(banco);

        /*CRUD Cuenta*/

        //Create
        crearCuenta("1032940394",80000, banco);
        crearCuenta("1083849302",70000, banco);
        crearCuenta("1097738093",75000, banco);

        System.out.println("\n" + "Informacion Cuentas de Ahorros Creadas: " + "\n");
        mostrarInformacionCuentas(banco);

        //Read
        System.out.println("\n" + "-----> Información Cuentas de Ahorros Creadas: " + "\n");
        mostrarInformacionCuentas(banco);

        /*Transacción*/

        System.out.println("\n" + "-----> Información de las Transacciones Realizadas:" + "\n");
        crearTransaccion("524049384", "524049386", 30000, Categoria.ROPA, banco);
        mostrarInformacionTransacciones(banco);

        System.out.println("\n" + "-----> Informacion de las Cuentas de Ahorros luego de Transacción:" + "\n");
        mostrarInformacionCuentas(banco);

        System.out.println("\n" + "-----> Consultar Saldo de una Cuenta de Ahorros:" + "\n");
        consultarSaldo("1083849302", "1234", banco);
        LocalDate fechaConsulta = LocalDate.of(2024, 2, 26);
        System.out.println("-----> Consulta de Transacción de acuerdo a la Fecha Indicada: " + fechaConsulta);
        Transaccion consultaFechaTransaccion = banco.consultarTransaccionFecha(fechaConsulta);
        System.out.println(consultaFechaTransaccion);

    }

    /**
     * Método para inicializar datos prueba
     * @return
     */
    private static Banco inicializarDatosPrueba() {
        Banco banco = new Banco();
        banco.setNombre("Bancolombia");
        banco.setDireccion("Calle 20 Nro 12-21");
        banco.setTelefono("3203849302");
        return banco;
    }

    /**
     * Método para crear usuario
     * @param nombre
     * @param direccion
     * @param cedula
     * @param correo
     * @param contrasena
     * @param banco
     */
    private static void crearUsuario(String nombre, String direccion, String cedula, String correo,
                                     String contrasena, Banco banco) {
        banco.crearUsuario(nombre, direccion, cedula, correo, contrasena);
    }

    /**
     * Método para crear cuenta
     * @param cedula
     * @param saldo
     * @param banco
     */
    private static void crearCuenta(String cedula, double saldo, Banco banco) {
        banco.crearCuenta(cedula, saldo);
    }

    /**
     * Método para mostrar información de usuarios
     * @param banco
     */
    private static void mostrarInformacionUsuarios(Banco banco) {
        List<Usuario> listaUsuarios = banco.obtenerUsuarios();
        int tamanoLista = listaUsuarios.size();
        for (int i=0; i < tamanoLista; i++) {
            Usuario usuario = listaUsuarios.get(i);
            System.out.println(usuario.toString());
        }
    }

    /**
     * Método para mostrar informaciín de cuentas de ahorros
     * @param banco
     */
    private static void mostrarInformacionCuentas(Banco banco) {
        List<Cuenta> listaCuentas = banco.obtenerCuentas();
        int tamanoLista = listaCuentas.size();
        for (int i=0; i < tamanoLista; i++) {
            Cuenta cuenta = listaCuentas.get(i);
            System.out.println(cuenta.obtenerInformacion());
        }
    }

    /**
     * Método para eliminar usuario
     * @param cedula
     * @param banco
     */
    private static void eliminarUsuario(String cedula, Banco banco) {
        banco.eliminarUsuario(cedula);
    }

    /**
     * Método para actualizar usuario
     * @param cedula
     * @param nombre
     * @param direccion
     * @param correo
     * @param contrasena
     * @param banco
     */
    private static void actualizarUsuario(String cedula, String nombre, String direccion, String correo,
                                          String contrasena, Banco banco) {
        banco.actualizarUsuario(cedula, nombre, direccion, correo, contrasena);
    }

    /**
     * Método para mostrar información de las transferencias realizadas
     * @param banco
     */
    private static void mostrarInformacionTransacciones(Banco banco) {
        for (Cuenta cuenta: banco.getListaCuentas()){
            cuenta.mostrarInformacionTransacciones();
        }
    }

    /**
     * Método para crear transacciones - PTE REVISAR FABIÁN
     * @param remitente
     * @param destinatario
     * @param valor
     * @param categoria
     * @param banco
     */
    private static void crearTransaccion(String remitente, String destinatario,
                                              double valor, Categoria categoria, Banco banco){
        banco.crearTransaccion(remitente, destinatario, valor, categoria);
    }

    /**
     * Método para consultar el saldo de las cuentas de ahorros creadas
     * @param cedula
     * @param contrasena
     * @param banco
     */
    private static void consultarSaldo(String cedula, String contrasena, Banco banco) {
        banco.consultarSaldo(cedula, contrasena);
    }
}