package vg.team09.farmacia;

public class Venta {
    private final Producto producto;
    private final int cantidad;
    private final Descuento descuento;

    public Venta(Producto producto, int cantidad, Descuento descuento) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public double calcularTotal() {
        if (!producto.tieneStock(cantidad)) {
            throw new IllegalStateException("No hay stock suficiente");
        }

        double subtotal = producto.getPrecioUnitario() * cantidad;
        double totalConDescuento = descuento.aplicar(subtotal);
        producto.reducirStock(cantidad);
        return totalConDescuento;
    }
}
