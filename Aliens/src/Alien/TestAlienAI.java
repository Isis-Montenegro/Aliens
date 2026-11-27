package Alien;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestAlienAI {

    private static final double DELTA = 0.0001;

    @Test
    public void testLimiteInferiorExacto() {
        Alien alien = new Alien(5, "Amarillo");

        assertEquals(5, alien.getTamanio());
        assertEquals("Amarillo", alien.getColor());
        assertEquals(1.0, alien.getPrecioCuerpo(), DELTA);
        assertEquals(0.5, alien.getPrecioExtremidad(), DELTA);
        assertEquals(0.25, alien.getPrecioOjo(), DELTA);
    }

    @Test
    public void testLimiteSuperiorExacto() {
        Alien alien = new Alien(30, "Morado");

        assertEquals(30, alien.getTamanio());
        assertEquals("Morado", alien.getColor());
        assertEquals(6.0, alien.getPrecioCuerpo(), DELTA);
        assertEquals(3.0, alien.getPrecioExtremidad(), DELTA);
        assertEquals(1.5, alien.getPrecioOjo(), DELTA);
    }

    @Test
    public void testJustoDebajoDelMinimo() {
        Alien alien = new Alien(4, "Gris");

        assertEquals(5, alien.getTamanio());
        assertEquals(1.0, alien.getPrecioCuerpo(), DELTA);
    }

    @Test
    public void testJustoEncimaDelMaximo() {
        Alien alien = new Alien(31, "Naranja");

        assertEquals(30, alien.getTamanio());
        assertEquals(6.0, alien.getPrecioCuerpo(), DELTA);
    }

    @Test
    public void testTamanoCeroYNegativo() {
        Alien alienCero = new Alien(0, "Blanco");
        Alien alienNegativo = new Alien(-15, "Negro");

        assertEquals(5, alienCero.getTamanio());
        assertEquals(5, alienNegativo.getTamanio());
        assertEquals(0.25, alienNegativo.getPrecioOjo(), DELTA);
    }

    @Test
    public void testAtributosInicialesPorDefecto() {
        Alien alien = new Alien(20, "Verde");

        assertEquals(0, alien.getNumeroOjos());
        assertEquals(0, alien.getNumeroBrazos());
        assertEquals(0, alien.getNumeroPies());
    }
}