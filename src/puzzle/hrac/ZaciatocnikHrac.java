
package puzzle.hrac;

/**
 * Hráč začiatočník, zdedený z Hráča, ktorému zadáme nickname, vek, obľúbenú farbu a uvedieme či hrá hru po prvý krát.
 * 
 * @author  Michal Murín
 * @version 2.0  (6 Maj 2020)
 */
public class ZaciatocnikHrac extends Hrac {
    private boolean hraPrvyKrat;
    private String oblubenaFarba;
    /**
     * Vytvor hráča začiatočníka so zadaným menom, vekom, farbou a poradím hry.
     * @param nickname
     * @param vek
     * @param hraPrvyKrat
     * @param oblubenaFarba
     */
    public ZaciatocnikHrac(String nickname, int vek, boolean hraPrvyKrat, String oblubenaFarba) {
        super(nickname, vek, TypHraca.ZACIATOCNIK);
        
        if (oblubenaFarba == null) {
            //nazovAgentury = "";
            throw new IllegalArgumentException("V konstruktore ste zadali null pre oblubenu farbu");
        }
        
        this.hraPrvyKrat = hraPrvyKrat;
        this.oblubenaFarba = oblubenaFarba;
        
    }
    /**
     * Vráť či hráč hrá prvý krát.
     * @return 
     */

    public boolean getHraPrvyKrat() {
        return this.hraPrvyKrat;
    }
    /**
     * Vráť obľúbenú farbu.
     * @return 
     */

    public String getOblubenaFarba() {
        return this.oblubenaFarba;
    }
    /**
     * Vráť hashCode začiatočníka.
     * @return 
     */
    public int hashCode() {
        return  super.hashCode() *
                this.oblubenaFarba.hashCode() *
                (this.hraPrvyKrat ? 1 : 2);
        
    }
    /**
     * Porovnaj začiatočníka s objektom o.
     * @param o
     * @return 
     */
    
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        
        if (!(o instanceof ZaciatocnikHrac)) {
            return false;
        }
        
        ZaciatocnikHrac param = (ZaciatocnikHrac)o;
       
        if (!(super.equals(o))) {
            return false;
        }        
        
        if (!(this.hraPrvyKrat == param.hraPrvyKrat)) {
            return false;
        }
        
        if (!(this.oblubenaFarba.equals(param.oblubenaFarba))) {
            return false;
        }
        
        
        return true;
        
    }
     /**
     * Vypíš atribúty začiatočníka.
     */
    public String toString() {
        return "[ Hráč s menom " + getNickname() + ", je to " + getTypHraca() + " hráč, na výhru potreboval počet ťahov = " + getPocetKrokov()  + 
                ", trvalo mu to " + getCasHry() + " sekúnd. " + getNickname() + (this.hraPrvyKrat ? " hrá túto hru prvý krát. " : " už túto hru hral. ") + " Obľúbená farba je: " + this.oblubenaFarba + "]";
    }
    
    
}
