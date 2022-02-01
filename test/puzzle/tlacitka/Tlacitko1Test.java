/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle.tlacitka;

import javax.swing.JButton;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author micha
 */
public class Tlacitko1Test {
    private Tlacitko1 t1;
    public Tlacitko1Test() {
    }
    
    
    
    @Before
    public void setUp() {
        this.t1 = new Tlacitko1("1");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getObsahTlacitka method, of class Tlacitko1.
     */
    @Test
    public void testGetObsahTlacitka() {
        assertTrue("1".equals(this.t1.getObsahTlacitka()));
    }

    /**
     * Test of getTlacitko method, of class Tlacitko1.
     */
    @Test
    public void testGetTlacitko() {
        JButton b = new JButton("1");
        String obsah1 = b.getText();
        String obsah2 = this.t1.getTlacitko().getText();
        assertTrue(obsah1.equals(obsah2));
    }

    

    /**
     * Test of prepis method, of class Tlacitko1.
     */
    @Test
    public void testPrepis() {
        this.t1.prepis("2");
        assertTrue("2".equals(this.t1.getObsahTlacitka()));
    }

    /**
     * Test of jePrazdny method, of class Tlacitko1.
     */
    @Test
    public void testJePrazdny() {
        assertFalse(this.t1.jePrazdny());
    }

    /**
     * Test of getObsahPrazdenho method, of class Tlacitko1.
     */
    @Test
    public void testGetObsahPrazdenho() {
        assertTrue("".equals(this.t1.getObsahPrazdenho()));
    }
    
}
