import org.junit.jupiter.api.Test;
import vg.team09.farmacia.Descuento;
import vg.team09.farmacia.Producto;
import vg.team09.farmacia.Venta;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ventaTest {

    @Test
    void debeCalcularTotalConDescuento() {
        // Arrange
        Producto producto = new Producto("Vitamina C", 10.00, 50);
        Descuento descuento = new Descuento(20);
        Venta venta = new Venta(producto, 5, descuento);

        // Act
        double total = venta.calcularTotal();

        // Assert
        assertEquals(40.00, total);
        assertEquals(45, producto.getStock());
    }

    @Test
    void debeLanzarExcepcionSiNoHayStock() {
        // Arrange
        Producto producto = new Producto("Jarabe", 15.00, 2);
        Descuento descuento = new Descuento(10);
        Venta venta = new Venta(producto, 5, descuento);

        // Assert
        assertThrows(IllegalStateException.class, venta::calcularTotal);
    }

}
