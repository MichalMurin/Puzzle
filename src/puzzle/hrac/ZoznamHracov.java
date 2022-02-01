
package puzzle.hrac;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import puzzle.vynimky.OdobratieHracaException;
import puzzle.vynimky.PridanieHracaException;

/**
 * HashMap hráčov typu Hrac s kľučom typu String, ktorý sa dá ukladať do súboru, 
 * dajú sa pridávať a odoberať hráči
 * a dá sa vypísať.
 * 
 * @author  Michal Murín
 * @version 2.0  (6 Maj 2020)
 */
public class ZoznamHracov  {
    private HashMap<String , Hrac> zoznam;
    private int pocetPokrocilychHracov;
    private int pocetZaciatocnikov;
    /**
     * Vytvor zoznam hráčov typu Hrac.
     */
    public ZoznamHracov() {
        this.zoznam = new HashMap<String , Hrac>();
        this.pocetPokrocilychHracov = 0;
        this.pocetZaciatocnikov = 0;
    }
    /**
     * Načítaj zoznam hráčov typu Hrac zo súboru.
     * @param nazovSuboru
     * @throws java.io.IOException
     */
    public ZoznamHracov(String nazovSuboru) throws IOException {
        this.zoznam = new HashMap<String , Hrac>();
        File subor = new File(nazovSuboru);
        Scanner citac = new Scanner(subor);
        String typ = citac.nextLine().trim();
        
        if (typ.equals("Zoznam")) {
            String verzia = citac.nextLine().trim();
            if (verzia.equals("0.0.1")) {
                this.pocetPokrocilychHracov = Integer.parseInt(citac.nextLine().trim());
                this.pocetZaciatocnikov = Integer.parseInt(citac.nextLine().trim());
                
                
                for (int i = 0; i < this.pocetPokrocilychHracov + this.pocetZaciatocnikov; i++) {
                    String pomNickName = citac.nextLine().trim();
                    int pomVek = Integer.parseInt(citac.nextLine().trim());
                    long pomCasHry = Long.parseLong(citac.nextLine().trim());
                    int pomPocetKrokov = Integer.parseInt(citac.nextLine().trim());
                    TypHraca pomTypHraca = null;
                    
                    TypHraca [] typyHracov = TypHraca.values();
                    String moznyTyp = citac.nextLine().trim();
                    boolean typHracaExistuje = false;
                    for (TypHraca t : typyHracov) {
                        if (t.toString().equals(moznyTyp)) {
                            typHracaExistuje = true;
                            pomTypHraca = t;
                        }
                    }
                    Hrac pomHrac = new Hrac(pomNickName, pomVek, pomTypHraca );
                    pomHrac.setCasHry(pomCasHry);
                    pomHrac.setPocetKrokov(pomPocetKrokov);
                    this.zoznam.put(pomHrac.getNickname(), pomHrac);
                    
                    
                    if (!typHracaExistuje) {
                        citac.close();
                        throw new IOException("Typ hraca v zadanom subore nie je podporovany!" );
                    }
                    
                }
                
                citac.close();
            } else {
                citac.close();
                throw new IOException ("Zadany subor s hracmi je v nepodporovanej verzii");
            }
        }
    }
    /**
     * Ulož zoznam do súboru.
     * @param nazovSuboru
     * @return 
     */
    public boolean ulozZoznamDoSuboru(String nazovSuboru) {
        
        File subor = new File(nazovSuboru);
        PrintWriter zapisovac = null;
        if (!this.zoznam.isEmpty()) {
        
            try {
                zapisovac =  new PrintWriter(subor);
                zapisovac.println("Zoznam");
                zapisovac.println("0.0.1");
                zapisovac.println(this.pocetPokrocilychHracov);
                zapisovac.println(this.pocetZaciatocnikov);
                for (Hrac hrac : this.zoznam.values()) {
                    zapisovac.println(hrac.getNickname());
                    zapisovac.println(hrac.getVek());
                    zapisovac.println(hrac.getCasHry());
                    zapisovac.println(hrac.getPocetKrokov());
                    zapisovac.println(hrac.getTypHraca());
                }
            } catch (IOException ex) {
                return false;
            } finally {
                if (zapisovac != null) {
                    zapisovac.close();
                }
            }
        }
        return true;
            
        
        
    }

    /**
     * Pridaj hráča do zoznamu.
     * @param hrac
     * @throws puzzle.vynimky.PridanieHracaException
     */
    public void pridajHraca(Hrac hrac) throws PridanieHracaException {
        if (hrac == null) {
            throw new PridanieHracaException("Zadany hrac nesmie byt null");
        }
        
        if (this.zoznam.containsKey(hrac.getNickname())) {
            throw new PridanieHracaException("Zadany hrac sa uz v zozname nachadza");
            //JOptionPane.showMessageDialog(null,"Zadane meno uz v zozname je");
        }
        
        if (hrac instanceof PokrocilyHrac || hrac.getTypHraca() == TypHraca.POKROCILY) {
            this.pocetPokrocilychHracov++;
        }
        
        if (hrac instanceof ZaciatocnikHrac || hrac.getTypHraca() == TypHraca.ZACIATOCNIK) {
            this.pocetZaciatocnikov++;
        }
        
        this.zoznam.put(hrac.getNickname(), hrac);
    }
    /**
     * Odober hráča zo zoznamu.
     * @param nickname
     * @return 
     * @throws puzzle.vynimky.OdobratieHracaException
     */
    public Hrac odoberHraca(String nickname) throws OdobratieHracaException {
        if (nickname == null) {
            throw new OdobratieHracaException("Zadali ste null pre nickname hraca");
        }
        
        if (!this.zoznam.containsKey(nickname)) {
            throw new OdobratieHracaException("Zadany hrac sa v zozname nenachadza");
        }
        
        Hrac vysl = this.zoznam.remove(nickname);
        
        if (vysl instanceof PokrocilyHrac) {
            this.pocetPokrocilychHracov--;
        }
        
        if (vysl instanceof ZaciatocnikHrac) {
            this.pocetZaciatocnikov--;
        }
        return vysl;  
    }
    /**
     * Zisti či sa hráč nachádza v zozname.
     * @param nickname
     * @return 
     */
    public boolean jeHrac(String nickname) {
        return this.zoznam.containsKey(nickname);
    }
    
    /**
     * Vymaž celý zoznam.
     */
    public void zmaz() {
        this.zoznam.clear();
        this.pocetPokrocilychHracov = 0;
        this.pocetZaciatocnikov = 0;
    }
    /**
     * Vráť počet pokročilých hráčov.
     * @return 
     */
    public int getPocetPokrocilychHracov() {
        return this.pocetPokrocilychHracov;
    }
    /**
     * Vráť počet začiatočníkov.
     * @return 
     */
    public int getPocetZaciatocnikov() {
        return this.pocetZaciatocnikov;
    }
    /**
     * Vráť hráča podľa nicknamu.
     * @param nickname
     * @return 
     */
    public Hrac getHrac(String nickname) {
        if (nickname == null) {
            throw new IllegalArgumentException("Zadali ste null pre nickname");
        }
        if (!this.zoznam.containsKey(nickname)) {
            throw new IllegalArgumentException("Hrac sa v zozname nenachadza");
        }
        return this.zoznam.get(nickname);
    }
    
    
    /**
     * Vypíš celý zoznam.
     */
    public String toString() {
        if (this.zoznam.isEmpty()) {
            return "Zoznam je prázdny";
        } else {
            String pom = "V zozname hráčov je " + this.pocetPokrocilychHracov + " pokročilých hráčov a " + this.pocetZaciatocnikov + " začiatočníkov: \n";
            for (Hrac hrac : this.zoznam.values()) {
                pom += hrac + "\n";
            }
            return pom;
        }
    }
   
}
