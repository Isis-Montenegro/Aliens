package com.krakedev.financiero.entidadesTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.financiero.entidades.Cliente;
import com.krakedev.financiero.entidades.Cuenta;
import com.krakedev.financiero.servicios.Banco;

public class TestBanco {

    @Test
    public void testCrearCuentasConCodigosConsecutivos() {
        Banco banco = new Banco();
        Cliente cliente1 = new Cliente("1712345678", "Ana", "Pérez");
        Cliente cliente2 = new Cliente("1798765432", "Luis", "Gómez");

        Cuenta cuenta1 = banco.crearCuenta(cliente1);
        Cuenta cuenta2 = banco.crearCuenta(cliente2);
        Cuenta cuenta3 = banco.crearCuenta(cliente1);

        assertEquals("1000", cuenta1.getId());
        assertEquals("1001", cuenta2.getId());
        assertEquals("1002", cuenta3.getId());

        assertEquals(1003, banco.getUltimoCodigo());

        assertEquals("A", cuenta1.getTipo());
        assertEquals(cliente1, cuenta1.getPropietario());
        assertEquals(cliente2, cuenta2.getPropietario());
    }
}