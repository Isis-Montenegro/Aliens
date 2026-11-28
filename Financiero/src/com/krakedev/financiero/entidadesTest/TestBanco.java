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
    
    

    @Test
    public void testRetirarMontoValido() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1712345678", "Ana", "Pérez");
        Cuenta cuenta = banco.crearCuenta(cliente);
        banco.depositar(200.00, cuenta);

        boolean resultado1 = banco.retirar(50.00, cuenta);
        assertTrue(resultado1);
        assertEquals(150.00, cuenta.getSaldoActual(), 0.001);

        boolean resultado2 = banco.retirar(150.00, cuenta);
        assertTrue(resultado2);
        assertEquals(0.0, cuenta.getSaldoActual(), 0.001);
    }

    @Test
    public void testRetirarMontoInvalido() {
        Banco banco = new Banco();
        Cliente cliente = new Cliente("1712345678", "Ana", "Pérez");
        Cuenta cuenta = banco.crearCuenta(cliente);
        banco.depositar(100.00, cuenta);

        assertFalse(banco.retirar(0, cuenta));
        assertEquals(100.00, cuenta.getSaldoActual(), 0.001);

        assertFalse(banco.retirar(-20.00, cuenta));
        assertEquals(100.00, cuenta.getSaldoActual(), 0.001);

        assertFalse(banco.retirar(150.00, cuenta));
        assertEquals(100.00, cuenta.getSaldoActual(), 0.001);
    }
    
    @Test
    public void testTransferirExitoso() {
        Banco banco = new Banco();
        Cliente cliente1 = new Cliente("1712345678", "Ana", "Pérez");
        Cliente cliente2 = new Cliente("1798765432", "Luis", "Gómez");

        Cuenta origen = banco.crearCuenta(cliente1);
        Cuenta destino = banco.crearCuenta(cliente2);
        banco.depositar(300.00, origen);

        boolean resultado = banco.transferir(origen, destino, 120.50);

        assertTrue(resultado);
        assertEquals(179.50, origen.getSaldoActual(), 0.001);
        assertEquals(120.50, destino.getSaldoActual(), 0.001);
    }

    @Test
    public void testTransferirFallido() {
        Banco banco = new Banco();
        Cliente cliente1 = new Cliente("1712345678", "Ana", "Pérez");
        Cliente cliente2 = new Cliente("1798765432", "Luis", "Gómez");

        Cuenta origen = banco.crearCuenta(cliente1);
        Cuenta destino = banco.crearCuenta(cliente2);
        banco.depositar(100.00, origen);

        assertFalse(banco.transferir(origen, destino, 150.00));
        assertEquals(100.00, origen.getSaldoActual(), 0.001);
        assertEquals(0.0, destino.getSaldoActual(), 0.001);

        assertFalse(banco.transferir(origen, destino, -50.00));
        assertFalse(banco.transferir(origen, destino, 0));
        assertEquals(100.00, origen.getSaldoActual(), 0.001);
        assertEquals(0.0, destino.getSaldoActual(), 0.001);
    }
    
    
    
    
    
}