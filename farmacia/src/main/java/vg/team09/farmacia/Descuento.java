package vg.team09.farmacia;

public class Descuento {
    private final double porcentaje;

    public Descuento(double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("El porcentaje es invalido");
        }
        this.porcentaje = porcentaje;
    }

    public double aplicar(double monto) {
        return  monto - (monto * porcentaje / 100);
    }
}
