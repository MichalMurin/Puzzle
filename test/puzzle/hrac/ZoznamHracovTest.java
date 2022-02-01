/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle.hrac;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import puzzle.vynimky.OdobratieHracaException;
import puzzle.vynimky.PridanieHracaException;

/**
 *
 * @author micha
 */
public class ZoznamHracovTest {
    private ZoznamHracov z1;
    private Hrac h1;
    public ZoznamHracovTest() {
    }
    
    
    
    @Before
    public void setUp() {
        this.z1 = new ZoznamHracov();
        this.h1 = new PokrocilyHrac("Jozef" , 20 , true , "Slovensko");
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ulozZoznamDoSuboru method, of class ZoznamHracov.
     */
    @Test
    public void testUlozZoznamDoSuboru() throws PridanieHracaException, IOException {
        this.z1.pridajHraca(this.h1);
        this.z1.ulozZoznamDoSuboru("testovaciZoznam.txt");
        ZoznamHracov z2 = new ZoznamHracov("testovaciZoznam.txt");
        Hrac h2 = z2.getHrac("Jozef");
        assertTrue(h2.equals(this.h1));
        
    }

   
    /**
     * Test of pridajHraca method, of class ZoznamHracov.
     */
    @Test
    public void testPridajHraca() throws PridanieHracaException {
        this.z1.pridajHraca(this.h1);
        assertTrue(this.z1.jeHrac("Jozef"));
        
    }

    /**
     * Test of odoberHraca method, of class ZoznamHracov.
     */
    @Test
    public void testOdoberHraca() throws PridanieHracaException, OdobratieHracaException {
        this.z1.pridajHraca(this.h1);
        this.z1.odoberHraca("Jozef");
        assertFalse(this.z1.jeHrac("Jozef"));
    }

   
    /**
     * Test of zmaz method, of class ZoznamHracov.
     */
    @Test
    public void testZmaz() throws PridanieHracaException {
        this.z1.pridajHraca(this.h1);
        this.z1.zmaz();
        assertFalse(this.z1.jeHrac("Jozef"));
    }

    /**
     * Test of getPocetPokrocilychHracov method, of class ZoznamHracov.
     */
    @Test
    public void testGetPocetPokrocilychHracov() {
        this.z1.zmaz();
        assertTrue(this.z1.getPocetPokrocilychHracov() == 0);
        
    }

    /**
     * Test of getPocetZaciatocnikov method, of class ZoznamHracov.
     */
    @Test
    public void testGetPocetZaciatocnikov() {
        this.z1.zmaz();
        assertTrue(this.z1.getPocetZaciatocnikov() == 0);
    }

    /**
     * Test of getHrac method, of class ZoznamHracov.
     */
    @Test
    public void testGetHrac() throws PridanieHracaException {
        this.z1.pridajHraca(this.h1);
        assertTrue(this.z1.getHrac("Jozef").equals(this.h1));
    }

    
    
    
}
