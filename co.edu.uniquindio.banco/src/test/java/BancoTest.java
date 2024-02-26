package co.edu.uniquindio.banco;

import co.edu.uniquindio.banco.model.Banco;
import co.edu.uniquindio.banco.model.Cuenta;
import co.edu.uniquindio.banco.model.Transaccion;
import co.edu.uniquindio.banco.model.Usuario;
import co.edu.uniquindio.banco.model.enumeracion.Categoria;
import co.edu.uniquindio.banco.model.enumeracion.TipoTrans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class BancoTest {
    private Banco banco;
    private Usuario usuario;
    private List<Usuario> usuarios;
    private List<Cuenta> cuentas;
    private List<Transaccion> transacciones;

    @BeforeEach
    public void init(){
        banco = new Banco("Banco Prueba");
        usuario = new Usuario(
                "Fabian",
                "Calle 18 # 29 - 29 Piso 2",
                "1066435296",
                "nfabiangs@gmail.com",
                "Colombia01"
        );
        usuarios = new ArrayList<Usuario>();
        cuentas = new ArrayList<Cuenta>();
        transacciones = new ArrayList<Transaccion>();
        usuarios.add(usuario);
        cuentas.add(cuenta);
        transacciones.add(transaccion);
        banco.setUsuarios(usuarios);
    }

    @Test
    public void GenerarNumeroCuenta() {
        GenerarNumeroCuenta generarNumeroCuenta = new GenerarNumeroCuenta();
        String numeroCuenta = generarNumeroCuenta.generarNumeroCuenta();
        int numero = Integer.parseInt(numeroCuenta);
        assertTrue(numero >= 524049384 && numero <= 584049384);
    }
}