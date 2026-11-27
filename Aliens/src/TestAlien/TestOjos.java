package TestAlien;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import Alien.Alien;

public class TestOjos {

    @Test
    public void testOjosAlienPequeno() {
    	
        Alien alien = new Alien(10, "Verde");

        assertTrue(alien.agregarOjos(2));
        assertTrue(alien.agregarOjos(1));
        assertEquals(3, alien.getNumeroOjos());

        assertFalse(alien.agregarOjos(1));
        assertEquals(3, alien.getNumeroOjos());
    }

    @Test
    public void testOjosAlienMediano() {
    	
        Alien alien = new Alien(15, "Azul");

        assertTrue(alien.agregarOjos(5));
        assertEquals(5, alien.getNumeroOjos());

        assertFalse(alien.agregarOjos(1));
        assertEquals(5, alien.getNumeroOjos());
    }

    @Test
    public void testOjosAlienGrande() {

        Alien alien = new Alien(25, "Rojo");

        assertTrue(alien.agregarOjos(4));
        assertTrue(alien.agregarOjos(3));
        assertEquals(7, alien.getNumeroOjos());

        assertFalse(alien.agregarOjos(1));
        assertEquals(7, alien.getNumeroOjos());
    }
}
