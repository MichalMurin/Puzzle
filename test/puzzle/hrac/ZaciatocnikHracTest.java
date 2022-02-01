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
public class ZaciatocnikHracTest {
    private ZaciatocnikHrac z1;
    public ZaciatocnikHracTest() {
    }
    
    
    
    @Before
    public void setUp() {
        this.z1 = new ZaciatocnikHrac("Jozo", 30, false, "Oranzova");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getHraPrvyKrat method, of class ZaciatocnikHrac.
     */
    @Test
    public void testGetHraPrvyKrat() {
        assertTrue(!this.z1.getHraPrvyKrat());
    }

    /**
     * Test of getOblubenaFarba method, of class ZaciatocnikHrac.
     */
    @Test
    public void testGetOblubenaFarba() {
        assertTrue("Oranzova".equals(this.z1.getOblubenaFarba()));
    }

    
}
