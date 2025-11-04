package ar.edu.unahur.obj2.observer.subasta;

public class Oferta {
    private Subastador subastador;
    private Double monto;

    public Oferta(Subastador subastador, Double monto) {
        this.subastador = subastador;
        this.monto = monto;
    }

    public Subastador getSubastador() {
        return subastador;
    }

    public Double getMonto() {
        return monto;
    }

    
}
