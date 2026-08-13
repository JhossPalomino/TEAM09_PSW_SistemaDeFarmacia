package vg.team09.farmacia;

public class Producto {
    private final String nombre;
    private final double precioUnitario;
    private int stock;

    public Producto(String nombre, double precioUnitario, int stock) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public boolean tieneStock(int cantidad) {
        return stock >= cantidad;
    }

    public void reducirStock(int cantidad) {
        if (tieneStock(cantidad)) {
            stock -= cantidad;
        } else {
            throw new IllegalArgumentException("Stock insuficiente para " + nombre);
        }
    }
}
