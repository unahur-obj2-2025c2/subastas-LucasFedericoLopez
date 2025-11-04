package ar.edu.unahur.obj2.observer.observer;

import ar.edu.unahur.obj2.observer.subasta.Oferta;

public interface Observable {
    void agregarObservador(IObservador observador);
    void quitarObservador(IObservador observador);
    void notificar(Oferta oferta);
}
