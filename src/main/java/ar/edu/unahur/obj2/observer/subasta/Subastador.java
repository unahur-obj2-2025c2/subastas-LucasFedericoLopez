package ar.edu.unahur.obj2.observer.subasta;

import ar.edu.unahur.obj2.observer.observer.IObservador;

public class Subastador implements IObservador{

    private final String nombre;
    private Double ultimaOferta;


    public Subastador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(Oferta oferta) {
        this.ultimaOferta = oferta.getMonto();
    }

    public Oferta ofertar() {
        return new Oferta(this, this.ultimaOferta + 10.0);
    }

    public void reiniciarUltimaOferta() {
        ultimaOferta = 0.0;
    }
    
    public String getNombre() {
        return nombre;
    }

    public Double getUltimaOferta() {
        return ultimaOferta;
    }
}
