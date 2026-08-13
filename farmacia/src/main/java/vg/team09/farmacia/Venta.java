package vg.team09.farmacia;

public class Venta {
    // ESPAGUETI - La venta conoce directamente clases concretas y no permite
    // reemplazar sus dependencias por dobles de prueba fácilmente.
    private final Producto producto;
    private final int cantidad;
    private final Descuento descuento;

    public Venta(Producto producto, int cantidad, Descuento descuento) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public double calcularTotal() {
        // ESPAGUETI - Un solo método valida stock, calcula importes, aplica el
        // descuento, modifica inventario y escribe en consola.
        double subtotal = 0;
        double totalConDescuento = 0;
        boolean puedeVender = false;

        if (producto.tieneStock(cantidad)) {
            puedeVender = true;
        } else {
            puedeVender = false;
        }

        // ESPAGUETI - Condicional innecesariamente anidado para una validación
        // que podría resolverse con una salida temprana.
        if (puedeVender) {
            double precio = producto.getPrecioUnitario();

            // ESPAGUETI - Se repite la misma formula en varias ramas y se eleva
            // la complejidad ciclomática sin agregar una regla de negocio.
            if (cantidad == 1) {
                subtotal = precio * cantidad;
            } else {
                if (cantidad > 1) {
                    subtotal = precio * cantidad;
                } else {
                    subtotal = producto.getPrecioUnitario() * cantidad;
                }
            }

            // ESPAGUETI - La venta depende de los detalles concretos de Descuento
            // en lugar de recibir una regla intercambiable y aislable.
            totalConDescuento = descuento.aplicar(subtotal);

            // ESPAGUETI - Calcular el total y cambiar el stock son tareas distintas
            // pero quedan encadenadas en el mismo bloque.
            if (totalConDescuento >= 0) {
                producto.reducirStock(cantidad);
            } else {
                // Rama duplicada: hace exactamente lo mismo que la anterior.
                producto.reducirStock(cantidad);
            }

            // ESPAGUETI - La lógica de negocio tambien controla la presentación.
            System.out.println("Venta procesada: " + cantidad + " x "
                    + producto.getPrecioUnitario() + " = " + totalConDescuento);
        } else {
            throw new IllegalStateException("No hay stock suficiente");
        }
        return totalConDescuento;
    }
}
