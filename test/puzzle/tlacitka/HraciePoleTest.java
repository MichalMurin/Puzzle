/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle.tlacitka;

import java.awt.Color;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import puzzle.hrac.Hrac;
import puzzle.hrac.ZaciatocnikHrac;

/**
 *
 * @author micha
 */
public class HraciePoleTest {
    private HraciePole h;
    private Hrac h0;
    public HraciePoleTest() {
    }
    
    
    
    @Before
    public void setUp() {
        this.h0 = new ZaciatocnikHrac("Jozef", 20, true, "Zelena");
        this.h = new HraciePole(this.h0, Color.BLACK);
    }
    
    @After
    public void tearDown() {
    }

    
    
    /**
     * Test of zamiesaj method, of class HraciePole.
     */
    @Test
    public void testZamiesaj() throws IOException {
        this.h.zapln();
        this.h.zamiesaj();
        assertFalse(this.h.jeVyhra());
    }

   
    /**
     * Test of vyhraj method, of class HraciePole.
     */
    @Test
    public void testVyhraj() throws IOException {
        this.h.zapln();
        this.h.zamiesaj();
        this.h.vyhraj();
        assertTrue(this.h.jeVyhra());
    }
    
}
