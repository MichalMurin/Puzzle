
package puzzle.vynimky;

/**
 * Výnimka ktorá dedí z triedy Exception a kontroluje odobratie hráča zo zoznamu.
 * 
 * @author  Michal Murín
 * @version 2.0  (6 Maj 2020)
 */
public class OdobratieHracaException extends Exception {
    public OdobratieHracaException(String popis) {
        super(popis);
    } 
}
