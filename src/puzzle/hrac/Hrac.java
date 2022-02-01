/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle.hrac;



/**
 * Hráč ktorému zadáme nickname, vek a uvedieme o aký typ hráča sa jedná.
 * 
 * @author  Michal Murín
 * @version 2.0  (6 Maj 2020)
 */
public class Hrac {
    private long casHry;
    private String nickname;
    private int pocetKrokov;
    private int vek;
    private TypHraca typHraca;
   
    /**
     * Vytvor Hráča so zadaným menom, vekom a typom.
     * @param nickname
     * @param vek
     * @param typHraca
     */
    public Hrac (String nickname, int vek, TypHraca typHraca) {
         
        if (nickname == null) {
            //nazovAgentury = "";
            throw new IllegalArgumentException("V konstruktore ste zadali null pre nickaname");
        }
        if (vek <= 0) {
            //nazovAgentury = "";
            throw new IllegalArgumentException("Vek hraca musi byt kladne cislo");
        }
        if (typHraca == null) {
            //nazovAgentury = "";
            throw new IllegalArgumentException("V konstruktore ste zadali null pre typ hraca");
        }
        this.casHry = 0;
        this.nickname = nickname;
        this.vek = vek;
        this.pocetKrokov = 0;
        this.typHraca = typHraca;
    }

    /**
     * Vráť čas hry.
     * @return 
     */
    public long getCasHry() {
        return this.casHry;
    }
    /**
     * Zmeň čas hry.
     * @param casHry 
     */
    public void setCasHry(long casHry) {
        this.casHry = casHry;
    }
    /**
     * Vráť meno hráča.
     * @return 
     */
    public String getNickname() {
        return this.nickname;
    }    
    /**
     * Vráť typ hráča.
     * @return 
     */
    public TypHraca getTypHraca() {
        return this.typHraca;
    }
    /**
     * Zmeň meno hráča.
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    /**
     * Vráť počet ťahov hráča v hre.
     * @return 
     */
    public int getPocetKrokov() {
        return this.pocetKrokov;
    }
    /**
     * Nastav počet ťahov hráča v hre.
     * @param kroky
     */
    public void setPocetKrokov(int kroky) {
        this.pocetKrokov = kroky;
    }
    /**
     * Vráť vek hráča.
     * @return 
     */
    public int getVek() {
        return this.vek;
    }
    /**
     * Vypíš atribúty Hráča.
     */
    public String toString() {
        return "[ Hráč s menom " + this.nickname + ", má " + this.vek + " rokov , je to " + this.typHraca + " hráč, na výhru potreboval počet ťahov = " + this.pocetKrokov  + ", hra mu trvala " + this.casHry +   " sekúnd ]";
    }
    /**
     * Vytvor hashCode Hráča.
     */
    public int hashCode() {
        return  this.vek *
                this.pocetKrokov *
                this.nickname.hashCode() *
                this.typHraca.hashCode() *
                (int)this.casHry;
    }
    /**
     * Porovnaj hráča s objektom o.
     * @param o
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        
        if (!(o instanceof Hrac)) {
            return false;
        }
        
        Hrac param = (Hrac)o;
        
        if (!(this.vek == param.vek)) {
            return false;
        }
        
        if (!(this.casHry == param.casHry)) {
            return false;
        }
        
        if (!(this.pocetKrokov == param.pocetKrokov)) {
            return false;
        }
        
        if (!this.typHraca.equals(param.typHraca)) {
            return false;
        }
         
        
        if (!this.nickname.equals(param.nickname)) {
            return false;
        }
        
        return true;
    }

    
    
}
