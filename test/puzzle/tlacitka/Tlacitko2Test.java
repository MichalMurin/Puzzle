
package puzzle.tlacitka;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author michal
 */
public class Tlacitko2Test {
    private Tlacitko2 t2;
    public Tlacitko2Test() {
    }
    
    
    
    @Before
    public void setUp() throws IOException {
        this.t2 = new Tlacitko2("imgJPEG/1.jpg");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getObsahTlacitka method, of class Tlacitko2.
     */
    @Test
    public void testGetObsahTlacitka() {
        assertTrue("imgJPEG/1.jpg".equals(this.t2.getObsahTlacitka()));
    }

    /**
     * Test of prepis method, of class Tlacitko2.
     */
    @Test
    public void testPrepis() {
        this.t2.prepis("imgJPEG/2.jpg");
        assertTrue("imgJPEG/2.jpg".equals(this.t2.getObsahTlacitka()));
    }

    /**
     * Test of jePrazdny method, of class Tlacitko2.
     */
    @Test
    public void testJePrazdny() {
        assertFalse(this.t2.jePrazdny());
    }

    /**
     * Test of getTlacitko method, of class Tlacitko2.
     */
    @Test
    public void testGetTlacitko() throws IOException {
        
        String s2 = this.t2.getTlacitko().getText();
        assertTrue("".equals(s2));
        
    }

    /**
     * Test of getObsahPrazdenho method, of class Tlacitko2.
     */
    @Test
    public void testGetObsahPrazdenho() {
        assertTrue("imgJPEG/0.jpg".equals(this.t2.getObsahPrazdenho()));
    }
    
}
