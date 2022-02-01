
package puzzle.hrac;

/**
 * Pokročilý hráč, zdedený z Hráča, ktorému zadáme nickname, vek, národnosť a uvedieme či je pravidelný hráč.
 * 
 * @author  Michal Murín
 * @version 2.0  (6 Maj 2020)
 */
public class PokrocilyHrac extends Hrac {
    private String narodnost;
    private boolean jePravidelnyHrac;
    /**
     * Vytvor Pokročilého hráča so zadaným menom, vekom, národnosťou a pravidelnosťou hrania.
     * @param nickname
     * @param vek
     * @param jePravidelnyHrac
     * @param narodnost
     */
    public PokrocilyHrac(String nickname, int vek, boolean jePravidelnyHrac, String narodnost) {
        super(nickname, vek, TypHraca.POKROCILY);
        
        if (narodnost == null) {
            //nazovAgentury = "";
            throw new IllegalArgumentException("V konstruktore ste zadali null pre narodnost");
        }
        
        this.narodnost = narodnost;
        this.jePravidelnyHrac = jePravidelnyHrac;
        
        
    }

    /**
     * Vráť národnosť.
     * @return 
     */

    public String getNarodnost() {
        return this.narodnost;
    }
    /**
     * Vráť pravidelnosť hrania.
     * @return 
     */
    public boolean getJePravidelnyHrac() {
        return this.jePravidelnyHrac;
    }
    /**
     * Vypíš atribúty pokročilého hráča.
     */
    public String toString() {
        return "[ Hráč s menom " + getNickname() + ", je to " + getTypHraca() + " hráč, na výhru potreboval počet ťahov = " + getPocetKrokov()  + 
                ", trvalo mu to " + getCasHry() + " sekúnd. " + getNickname() + " je národnosti:" + this.narodnost + " a " + (this.jePravidelnyHrac ? "je pravidelný hráč" : "nieje pravidelný hráč") + "]";
        
    }
    /**
     * Vráť hashCode pokročilého hráča.
     * @return 
     */
    public int hashCode() {
        return  super.hashCode() *
                this.narodnost.hashCode() *
                (this.jePravidelnyHrac ? 1 : 2);
        
    }
    /**
     * Porovnaj pokročilého hráča s objektom o.
     * @param o
     * @return 
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        
        if (!(o instanceof PokrocilyHrac)) {
            return false;
        }
        
        PokrocilyHrac param = (PokrocilyHrac)o;
       
        if (!(super.equals(o))) {
            return false;
        }        
        
        if (!(this.jePravidelnyHrac == param.jePravidelnyHrac)) {
            return false;
        }
        
        if (!(this.narodnost.equals(param.narodnost))) {
            return false;
        }
        
        
        
        return true;
        
    }
    
    
}
