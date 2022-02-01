/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle.hrac;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author micha
 */
public class HracTest {
    private Hrac h1;
    public HracTest() {
    }
    
    
    
    @Before
    public void setUp() {
        this.h1 = new Hrac("Jozef", 40, TypHraca.POKROCILY);
        this.h1.setCasHry(70);
        this.h1.setPocetKrokov(100);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCasHry method, of class Hrac.
     */
    @Test
    public void testGetCasHry() {
        assertTrue(this.h1.getCasHry() == 70);
    }

    /**
     * Test of setCasHry method, of class Hrac.
     */
    @Test
    public void testSetCasHry() {
        this.h1.setCasHry(50);
        assertTrue(this.h1.getCasHry() == 50);
    }
    /**
     * Test of getNickname method, of class Hrac.
     */
    @Test
     public void testGetNickname() {
        assertTrue("Jozef".equals(this.h1.getNickname()));
    }
       
    

    /**
     * Test of getTypHraca method, of class Hrac.
     */
    @Test
    public void testGetTypHraca() {
        assertTrue(this.h1.getTypHraca() == TypHraca.POKROCILY);
    }

    /**
     * Test of setNickname method, of class Hrac.
     */
    @Test
    public void testSetNickname() {
        this.h1.setNickname("Marek");
        assertTrue("Marek".equals(this.h1.getNickname()));
    }

    /**
     * Test of getPocetKrokov method, of class Hrac.
     */
    @Test
    public void testGetPocetKrokov() {
        assertTrue(this.h1.getPocetKrokov() == 100);
    }

    /**
     * Test of setPocetKrokov method, of class Hrac.
     */
    @Test
    public void testSetPocetKrokov() {
        this.h1.setPocetKrokov(200);
        assertTrue(this.h1.getPocetKrokov() == 200);
    }

    /**
     * Test of getVek method, of class Hrac.
     */
    @Test
    public void testGetVek() {
        assertTrue(this.h1.getVek() == 40);
    }

    
    
}
