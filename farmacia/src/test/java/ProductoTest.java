import org.junit.jupiter.api.Test;
import vg.team09.farmacia.Producto;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    @Test
    void debeCalcularTodoCorrectamente() {
        // Arrange
        Producto producto = new Producto("Paracetamol", 2.50, 100);

        // Act
        double resultado = producto.getPrecioUnitario() * 3;

        // Assert
        assertEquals(7.50, resultado);
    }

    @Test
    void debeValidarStockCorrectamente() {
        // Arrange
        Producto producto = new Producto("Ibuprofeno", 1.80, 10);

        // Act & Assert
        assertTrue(producto.tieneStock(5));
        assertFalse(producto.tieneStock(15));
    }

    @Test
    void debeReducirStockCorrectamente() {
        // Arrange
        Producto producto = new Producto("Amoxicilina", 5.00, 20);

        // Act
        producto.reducirStock(5);

        // Assert
        assertEquals(15, producto.getStock());
    }
}
