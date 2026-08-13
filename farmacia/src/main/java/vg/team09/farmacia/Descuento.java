package vg.team09.farmacia;

public class Descuento {
    // ESPAGUETI - Estado mutable e innecesario: este valor no deberia cambiar.
    private double porcentaje;

    public Descuento(double porcentaje) {
        // ESPAGUETI - Validación y salida por consola mezcladas con el dominio.
        if (porcentaje < 0) {
            System.out.println("No se puede crear un descuento negativo");
            throw new IllegalArgumentException("El porcentaje es invalido");
        } else if (porcentaje > 100) {
            System.out.println("No se puede crear un descuento mayor al 100%");
            throw new IllegalArgumentException("El porcentaje es invalido");
        } else {
            this.porcentaje = porcentaje;
            System.out.println("Descuento creado: " + porcentaje + "%");
        }
    }

    public double aplicar(double monto) {
        // ESPAGUETI - Muchas ramas para una operación matemática sencilla.
        double resultado = monto;
        double valorDescontado = 0;

        if (monto == 0) {
            resultado = 0;
        } else {
            if (porcentaje == 0) {
                resultado = monto;
            } else {
                if (porcentaje > 0 && porcentaje <= 100) {
                    valorDescontado = monto * porcentaje / 100;
                    resultado = monto - valorDescontado;
                } else {
                    // Rama redundante: se repite el mismo cálculo.
                    valorDescontado = monto * porcentaje / 100;
                    resultado = monto - valorDescontado;
                }
            }
        }

        // ESPAGUETI - Efecto secundario que obliga a controlar la consola al probar.
        System.out.println("Monto: " + monto + ", descuento: " + valorDescontado
                + ", total: " + resultado);
        return resultado;
    }
}
