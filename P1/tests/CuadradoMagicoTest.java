import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import es.udc.sistemasinteligentes.CuadradoMagico;

class CuadradoMagicoTest {

    @Test
    void testSolucion() {
        int[][] cuadrado = {
            {4, 9, 2},
            {3, 5, 7},
            {8, 1, 6}
        };
        assertEquals(15, new CuadradoMagico(cuadrado).getSolucion());
    }

    @Test
    void testEsCuadradoMagico() {
        int[][] cuadrado = {
            {4, 9, 2},
            {3, 5, 7},
            {8, 1, 6}
        };
        assertTrue(new CuadradoMagico(cuadrado).esCuadradoMagico());
    }
}
