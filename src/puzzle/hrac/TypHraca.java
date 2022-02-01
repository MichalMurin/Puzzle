
package puzzle.hrac;

/**
 * Enumeriyácia typov hráčov, a to pokročilý a začiatočník.
 * 
 * @author  Michal Murín
 * @version 2.0  (6 Maj 2020)
 */
public enum TypHraca {
    ZACIATOCNIK("začiatočník"),
    POKROCILY("pokročilý");
    
    private String typ;
    /**
     * Vytvor typ hráča so zadaným typom.
     */
    TypHraca(String typ) {
        this.typ = typ;
    }
    /**
     * Vráť reprezentáciu enumu.
     * @return 
     */

    public String getReprezentacia() {
        return this.typ;
    }
    /**
     * Vypíš String pre enum.
     */
    public String toString() {
        return this.typ;
    }
}
