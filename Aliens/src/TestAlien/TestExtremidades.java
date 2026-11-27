package TestAlien;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import Alien.Alien;

public class TestExtremidades {

    @Test
    public void testCasosValidos() {
        Alien alien = new Alien(15, "Verde");

        assertTrue(alien.agregarBrazos(2));
        assertEquals(2, alien.getNumeroBrazos());

        assertTrue(alien.agregarPiernas(2));
        assertEquals(2, alien.getNumeroPies());
    }

    @Test
    public void testCasoLimiteExacto() {
        Alien alien = new Alien(20, "Azul");

        // Llegar exactamente a 10 extremidades
        assertTrue(alien.agregarBrazos(10));
        assertEquals(10, alien.getNumeroBrazos());

        // Intentar agregar 1 más debe fallar y no modificar nada
        assertFalse(alien.agregarPiernas(1));
        assertEquals(0, alien.getNumeroPies());
    }

    @Test
    public void testExcederLimiteNoModificaAtributos() {
        Alien alien = new Alien(10, "Rojo");

        assertFalse(alien.agregarBrazos(11));
        assertEquals(0, alien.getNumeroBrazos());

        assertFalse(alien.agregarPiernas(12));
        assertEquals(0, alien.getNumeroPies());
    }

    @Test
    public void testCasosCombinados() {
        Alien alien = new Alien(25, "Morado");

        // 4 brazos + 4 piernas = 8 extremidades (válido)
        assertTrue(alien.agregarBrazos(4));
        assertTrue(alien.agregarPiernas(4));
        assertEquals(4, alien.getNumeroBrazos());
        assertEquals(4, alien.getNumeroPies());

        // Intentar agregar 3 brazos más (8 + 3 = 11 > 10 -> falla)
        assertFalse(alien.agregarBrazos(3));
        assertEquals(4, alien.getNumeroBrazos());

        // Agregar 2 piernas más (8 + 2 = 10 -> válido)
        assertTrue(alien.agregarPiernas(2));
        assertEquals(6, alien.getNumeroPies());
    }
}