package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.exception.SubastadorNoRegistradoException;
import ar.edu.unahur.obj2.observer.subasta.ProductoSubastado;
import ar.edu.unahur.obj2.observer.subasta.Subastador;

public class SubastaTest {
    private ProductoSubastado producto;
    private Subastador subastador1;
    private Subastador subastador2;
    private Subastador subastador3;

    @BeforeEach
    void setUp() {
        producto = new ProductoSubastado("play");
        subastador1 = new Subastador("gonzager");
        subastador2 = new Subastador("diazdan");
        subastador3 = new Subastador("martomau");

        producto.reiniciarPorducto();
        subastador1.reiniciarUltimaOferta();
        subastador2.reiniciarUltimaOferta();
        subastador3.reiniciarUltimaOferta();

        producto.agregarObservador(subastador1);
        producto.agregarObservador(subastador3);

        producto.agregarOferta(subastador3.ofertar());
        producto.agregarOferta(subastador1.ofertar());
        producto.agregarOferta(subastador3.ofertar());
    }

    @Test
    void seVerificaQueLosSubastadores1Y3RecibenCorrectamenteLaUltimaOfertaRealizada() {
        assertEquals(30, subastador3.getUltimaOferta());
        assertEquals(30, subastador1.getUltimaOferta());
    }

    @Test
    void laUltimaOfertaRegistradaPerteneceAMartomau() {
        assertEquals("martomau", producto.getOfertasRecibidas().getLast().getSubastador().getNombre());
    }

    @Test
    void seDemustraQueElAumentoProgresivoSeaCorrectoYLaCantidadDeOfertasEs3() {
        assertEquals(30, subastador1.getUltimaOferta());
        assertEquals(30, subastador3.getUltimaOferta());
        
        assertEquals(3, producto.getOfertasRecibidas().size());
        assertEquals(30, producto.getOfertasRecibidas().getLast().getMonto());
    }
    @Test
    void alIntentarOfertardiadzanLanzaUnaExcepcion() {
        assertThrows(SubastadorNoRegistradoException.class, () -> producto.agregarOferta(subastador2.ofertar()),
         "El subastador no participa en la subasta");
    }

}
