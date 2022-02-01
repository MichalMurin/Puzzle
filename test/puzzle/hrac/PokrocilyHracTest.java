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
public class PokrocilyHracTest {
    private PokrocilyHrac p1;
    public PokrocilyHracTest() {
    }
    
    
    
    @Before
    public void setUp() {
        this.p1 = new PokrocilyHrac("Jozef" , 20 , true , "Slovensko");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNarodnost method, of class PokrocilyHrac.
     */
    @Test
    public void testGetNarodnost() {
        assertTrue("Slovensko".equals(this.p1.getNarodnost()));
    }

    /**
     * Test of getJePravidelnyHrac method, of class PokrocilyHrac.
     */
    @Test
    public void testGetJePravidelnyHrac() {
        assertTrue(this.p1.getJePravidelnyHrac());
    }

    /**
     * Test of toString method, of class PokrocilyHrac.
     */
    
    
}
