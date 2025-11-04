package ar.edu.unahur.obj2.observer.subasta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unahur.obj2.observer.exception.SubastadorNoRegistradoException;
import ar.edu.unahur.obj2.observer.observer.IObservador;
import ar.edu.unahur.obj2.observer.observer.Observable;

public class ProductoSubastado implements Observable{
    private final String nombre;
    private List<Oferta> ofertasRecibidas = new ArrayList<>();
    private Set<IObservador> subastadores = new HashSet<>();

    public ProductoSubastado(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void agregarObservador(IObservador observador) {
        subastadores.add(observador);
    }

    @Override
    public void quitarObservador(IObservador observador) {
        subastadores.remove(observador);
    }

    @Override
    public void notificar(Oferta oferta) {
        subastadores.forEach(s -> s.actualizar(oferta));
    }

    public void agregarOferta(Oferta oferta) {
        if (!subastadores.contains(oferta.getSubastador())) {
            throw new SubastadorNoRegistradoException("El subastador no participa en la subasta");
        }
        ofertasRecibidas.add(oferta);
        notificar(oferta);
    }
    
    public void reiniciarPorducto() {
        ofertasRecibidas = new ArrayList<>();
        subastadores = new HashSet<>();
    }
    
    public List<Oferta> getOfertasRecibidas() {
        return ofertasRecibidas;
    }
}
