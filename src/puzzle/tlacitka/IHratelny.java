
package puzzle.tlacitka;

import javax.swing.JButton;

/**
 * Interface IHratelny ktorý obsahuje metódy potrebné pre hru Puzzle.
 * 
 * @author  Michal Murín
 * @version 2.0  (6 Maj 2020)
 */
public interface IHratelny {
    void prepis(String novyObsah);
    String getObsahTlacitka();
    boolean jePrazdny();
    JButton getTlacitko();
    String getObsahPrazdenho();
    
}
