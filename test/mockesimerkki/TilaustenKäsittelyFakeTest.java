/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mockesimerkki;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miikakaa
 */
public class TilaustenKäsittelyFakeTest {
    
    @Test
    public void testaaKäsittelijäWithFakeHinnoittelija() {
        // arrange
        float alkuSaldo = 100.0f;
        float listaHinta = 30.0f;
        float alennus = 20.0f;
        float loppuSaldo = alkuSaldo - (listaHinta * (1 - alennus / 100));
        
        Asiakas asiakas = new Asiakas(alkuSaldo);
        Tuote tuote = new Tuote("TDD in Action", listaHinta);
        Hinnoittelija hinnoittelija = new FakeHinnoittelija(alennus);
        
        // act
        TilaustenKäsittely käsittelijä = new TilaustenKäsittely();
        käsittelijä.setHinnoittelija(hinnoittelija);
        käsittelijä.käsittele(new Tilaus(asiakas, tuote));
        
        // assert
        assertEquals(loppuSaldo, asiakas.getSaldo(), 0.001);
    }
    
}
