package Alien;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestAlienJUnit {

    @Test
    public void testAsignacionAtributosYPrecios() {
        Alien alien = new Alien(10, "Verde");

        assertEquals(10, alien.getTamanio());
        assertEquals("Verde", alien.getColor());
        assertEquals(2.0, alien.getPrecioCuerpo(), 0.001);
        assertEquals(1.0, alien.getPrecioExtremidad(), 0.001);
        assertEquals(0.5, alien.getPrecioOjo(), 0.001);
    }

    @Test
    public void testTamanoMenorAlMinimo() {
        Alien alien = new Alien(2, "Azul");

        assertEquals(5, alien.getTamanio());
        assertEquals(1.0, alien.getPrecioCuerpo(), 0.001);
        assertEquals(0.5, alien.getPrecioExtremidad(), 0.001);
        assertEquals(0.25, alien.getPrecioOjo(), 0.001);
    }

    @Test
    public void testTamanoMayorAlMaximo() {
        Alien alien = new Alien(50, "Rojo");

        assertEquals(30, alien.getTamanio());
        assertEquals(6.0, alien.getPrecioCuerpo(), 0.001);
        assertEquals(3.0, alien.getPrecioExtremidad(), 0.001);
        assertEquals(1.5, alien.getPrecioOjo(), 0.001);
    }
}