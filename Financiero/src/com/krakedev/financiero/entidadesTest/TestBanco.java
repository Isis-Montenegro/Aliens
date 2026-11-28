package com.krakedev.financiero.entidadesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    
    
    @Test
    public void testDepositarMontoValido() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1712345678", "Ana", "Pérez");
        Cuenta cuenta = banco.crearCuenta(cliente);

        boolean resultado1 = banco.depositar(100.50, cuenta);
        assertTrue(resultado1);
        assertEquals(100.50, cuenta.getSaldoActual(), 0.001);

        boolean resultado2 = banco.depositar(50.00, cuenta);
        assertTrue(resultado2);
        assertEquals(150.50, cuenta.getSaldoActual(), 0.001);
    }
    
    @Test
    public void testDepositarMontoInvalido() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1712345678", "Ana", "Pérez");
        Cuenta cuenta = banco.crearCuenta(cliente);

        boolean resultadoCero = banco.depositar(0, cuenta);
        assertFalse(resultadoCero);
        assertEquals(0, cuenta.getSaldoActual(), 0.001);

        boolean resultadoNegativo = banco.depositar(-25.0, cuenta);
        assertFalse(resultadoNegativo);
        assertEquals(0, cuenta.getSaldoActual(), 0.001);
    }
    
    
    
    
    
}