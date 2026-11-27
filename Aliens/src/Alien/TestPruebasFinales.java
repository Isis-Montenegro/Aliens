package Alien;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TestPruebasFinales {

    private static final double DELTA = 0.0001;

    @Test
    public void testCalculoPrecioTotalAlAgregarElementos() {
        Alien alien = new Alien(10, "Verde");

        assertEquals(0.0, alien.getPrecioTotal(), DELTA);

        assertTrue(alien.agregarBrazos(2));
        assertEquals(2, alien.getNumeroBrazos());
        assertEquals(4.0, alien.getPrecioTotal(), DELTA);

        assertTrue(alien.agregarPiernas(2));
        assertEquals(2, alien.getNumeroPies());
        assertEquals(6.0, alien.getPrecioTotal(), DELTA);

        assertTrue(alien.agregarOjos(3));
        assertEquals(3, alien.getNumeroOjos());
        assertEquals(7.5, alien.getPrecioTotal(), DELTA);
    }

    @Test
    public void testRestriccionesNoAlteranPrecioTotal() {
        Alien alien = new Alien(25, "Azul");

        assertTrue(alien.agregarBrazos(6));
        assertEquals(20.0, alien.getPrecioTotal(), DELTA);

        assertFalse(alien.agregarPiernas(5));
        assertEquals(0, alien.getNumeroPies());
        assertEquals(20.0, alien.getPrecioTotal(), DELTA);

        assertFalse(alien.agregarOjos(8));
        assertEquals(0, alien.getNumeroOjos());
        assertEquals(20.0, alien.getPrecioTotal(), DELTA);

        assertTrue(alien.agregarOjos(4));
        assertEquals(4, alien.getNumeroOjos());
        assertEquals(25.0, alien.getPrecioTotal(), DELTA);
    }

    @Test
    public void testTamanoAjustadoYLimitesMaximos() {
        Alien alien = new Alien(50, "Rojo");

        assertEquals(30, alien.getTamanio());

        assertTrue(alien.agregarBrazos(10));
        assertTrue(alien.agregarOjos(7));

        assertEquals(46.5, alien.getPrecioTotal(), DELTA);

        assertFalse(alien.agregarPiernas(1));
        assertFalse(alien.agregarOjos(1));
        assertEquals(46.5, alien.getPrecioTotal(), DELTA);
    }
}