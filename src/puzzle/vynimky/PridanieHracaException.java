
package puzzle.vynimky;

/**
 * Výnimka ktorá dedí z triedy Exception a kontroluje pridanie hráča do zoznamu.
 * 
 * @author  Michal Murín
 * @version 2.0  (6 Maj 2020)
 */
public class PridanieHracaException extends Exception {
    public PridanieHracaException(String popis) {
        super(popis);
    }     
}
