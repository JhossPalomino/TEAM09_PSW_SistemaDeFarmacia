package vg.team09.farmacia;

public class Producto {
    private final String nombre;
    private final double precioUnitario;
    private int stock;

    public Producto(String nombre, double precioUnitario, int stock) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;

        // ESPAGUETI - La entidad imprime mensajes por consola y mezcla inventario
        // con una interfaz de salida que deberia estar fuera del modelo.
        System.out.println("Producto cargado: " + nombre + " | stock: " + stock);
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public boolean tieneStock(int cantidad) {
        // ESPAGUETI - Una comparacion directa se convierte en muchas ramas y
        // variables temporales, aumentando los caminos de prueba sin necesidad.
        boolean resultado = false;

        if (cantidad < 0) {
            if (stock >= cantidad) {
                resultado = true;
            } else {
                resultado = false;
            }
        } else {
            if (stock >= cantidad) {
                resultado = true;
            } else {
                resultado = false;
            }
        }

        // ESPAGUETI - Se vuelve a evaluar el caso cero aunque ya esta incluido
        // en la comparacion anterior: hay lógica repetida.
        if (cantidad == 0) {
            if (stock >= 0) {
                resultado = true;
            } else {
                resultado = false;
            }
        }
        return resultado;
    }

    public void reducirStock(int cantidad) {
        // ESPAGUETI - La regla de stock se comprueba y luego se repite
        // dentro de otra estructura.
        boolean sePuedeReducir = tieneStock(cantidad);
        if (!sePuedeReducir) {
            throw new IllegalArgumentException("Stock insuficiente para " + nombre);
        }

        if (stock >= cantidad) {
            stock = stock - cantidad;
        } else {
            // Rama redundante: la misma condición ya fue comprobada.
            throw new IllegalArgumentException("Stock insuficiente para " + nombre);
        }

        // ESPAGUETI - La operación de inventario tambien informa al usuario,
        // mezclando una responsabilidad de dominio con presentación.
        System.out.println("Stock reducido de " + nombre + ": " + stock);
    }
}
