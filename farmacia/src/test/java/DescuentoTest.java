import org.junit.jupiter.api.Test;
import vg.team09.farmacia.Descuento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DescuentoTest {

    @Test
    void debeAplicarDescuentoCorrectamente() {
        // Arrange
        Descuento descuento = new Descuento(10);

        // Act
        double resultado = descuento.aplicar(200);

        // Assert
        assertEquals(180, resultado);
    }

    @Test
    void debeLanzarErrorPorcentajeInvalido() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Descuento(-5));
        assertThrows(IllegalArgumentException.class, () -> new Descuento(150));
    }

}
