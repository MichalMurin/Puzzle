
package puzzle.tlacitka;


import puzzle.grafika.VyherneOknoGUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import puzzle.hrac.Hrac;
import puzzle.hrac.PokrocilyHrac;
import puzzle.hrac.ZaciatocnikHrac;
/**
 * Hracie pole ktoré vytvorí pole tlačítok, zamieša ich zobrazí na JFrame a pridá im hrateľnosť myšou.
 * JFrame obsahuje JMenuBar kde sa nachádzajú možnosti vyhrať hru a zobraziť pravidlá.
 * 
 * @author  Michal Murín
 * @version 2.0  (6 Maj 2020)
 */
public class HraciePole extends JFrame implements ActionListener {      
    private IHratelny[] pole;
    private Hrac hrac;
    private int pocetKrokov;
    private Color farba;
    private JMenuBar menuBar;
    private JMenu mnuProgram;
    private JMenuItem mniVyhraj;
    private JMenuItem mniPravidla;
    /**
     * Vytvor hracie pole pre zadaného hráča a ulož zadanú farbu.
     * @param hrac
     * @param farba
     */
    public HraciePole(Hrac hrac, Color farba) {
        if (hrac == null) {
            throw new IllegalArgumentException("Za hraca ste dosaili null");
        }
        if (farba == null) {
            throw new IllegalArgumentException("Za farbu ste dosaili null");
        }
        
        this.pole = new IHratelny[9];
        this.hrac = hrac;
        this.pocetKrokov = 0;
        this.farba = farba;
        this.hrac.setCasHry(System.currentTimeMillis());
        this.menuBar = new JMenuBar();
        this.mnuProgram = new JMenu("Program");
        this.mniVyhraj = new JMenuItem("Vyhraj");
        this.mniPravidla = new JMenuItem("Zobraz pravidlá");
        
    }
    /**
     * Zaplň pole tlačítkami, zamiešaj ich, daj im hrateľnosť myšou a zobraz ich na JFrame.
     * @throws java.io.IOException
     */
    public void hraj() throws IOException {
        this.zapln();
        this.zamiesaj();
        this.pridajOvladanieMysou();
        this.zobraz();
    }
    /**
     * Podľa typu hráča zaplň pole tlačítkami.
     * @throws java.io.IOException
     */
    public void zapln() throws IOException {
        if (this.hrac instanceof ZaciatocnikHrac) {
            this.pole[0] = new Tlacitko1("");
            for (int i = 1; i < this.pole.length; i++) {
                this.pole[i] = new Tlacitko1(Integer.toString(i));
            }
        }
        
        if (this.hrac instanceof PokrocilyHrac) {
            /*String pom = null;
            for (int i = 0; i < pole.length; i++) {
                pom = Integer.toString(i);
                pole[i] = new Tlacitko2("imgJPEG/" + pom + ".jpg");
            }*/
            
            this.pole[0] = new Tlacitko2("imgJPEG/0.jpg");
            this.pole[1] = new Tlacitko2("imgJPEG/1.jpg");
            this.pole[2] = new Tlacitko2("imgJPEG/2.jpg");
            this.pole[3] = new Tlacitko2("imgJPEG/3.jpg");
            this.pole[4] = new Tlacitko2("imgJPEG/4.jpg");
            this.pole[5] = new Tlacitko2("imgJPEG/5.jpg");
            this.pole[6] = new Tlacitko2("imgJPEG/6.jpg");
            this.pole[7] = new Tlacitko2("imgJPEG/7.jpg");
            this.pole[8] = new Tlacitko2("imgJPEG/8.jpg");
        
        }
    }
  /**
     * Zamiešaj tlačítka v poli.
     */
    public void zamiesaj() {
        IHratelny pom = null;
        Random rnd = new Random();
        for (int i = 1; i < 9; i++) {
            
            if (this.pole[i].equals(this.pole[rnd.nextInt(9)])) {
                this.pole[i] = this.pole[i];
                
            } else {
                
                int r =  rnd.nextInt(9);
                pom = this.pole[r];
                this.pole[r] = this.pole[i];
                this.pole[i] = pom;
            
            }
        }
            
    }
    /**
     * Zobraz tlačítka na JFrame.
     */
    public void zobraz() {
        
        this.pole[0].getTlacitko().setBounds(40 ,  40 ,  100 , 100);
        this.pole[1].getTlacitko().setBounds(160 , 40 , 100 , 100);  
        this.pole[2].getTlacitko().setBounds(280 , 40 , 100 , 100);  
        this.pole[3].getTlacitko().setBounds(40 , 160 , 100 , 100);  
        this.pole[4].getTlacitko().setBounds(160 , 160 , 100 , 100);   
        this.pole[5].getTlacitko().setBounds(280 , 160 , 100 , 100);  
        this.pole[6].getTlacitko().setBounds(40 , 280 , 100 , 100);   
        this.pole[7].getTlacitko().setBounds(160 , 280 , 100 , 100);  
        this.pole[8].getTlacitko().setBounds(280 , 280 , 100 , 100);
        
        this.mnuProgram.add(this.mniVyhraj);
        this.mnuProgram.add(this.mniPravidla);
        this.menuBar.add(this.mnuProgram);
        setJMenuBar(this.menuBar);
        
        for (IHratelny pom : this.pole) {
            add(pom.getTlacitko());  
        }
        
        setTitle("PUZZLE");    
        setSize(450 , 450);  
        setLayout(null);
        getContentPane().setBackground(this.farba);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 200);
        setResizable(false);
        setVisible(true);
    }
    /**
     * Skontorluj či sú tlačítka v správnom poradí.
     * @return 
     */
    public boolean jeVyhra() {
        if (this.hrac instanceof PokrocilyHrac && 
                "imgJPEG/1.jpg".equals(this.pole[0].getObsahTlacitka()) &&
                "imgJPEG/2.jpg".equals(this.pole[1].getObsahTlacitka()) &&  
                "imgJPEG/3.jpg".equals(this.pole[2].getObsahTlacitka()) && 
                "imgJPEG/4.jpg".equals(this.pole[3].getObsahTlacitka()) && 
                "imgJPEG/5.jpg".equals(this.pole[4].getObsahTlacitka()) &&
                "imgJPEG/6.jpg".equals(this.pole[5].getObsahTlacitka()) && 
                "imgJPEG/7.jpg".equals(this.pole[6].getObsahTlacitka()) &&
                "imgJPEG/8.jpg".equals(this.pole[7].getObsahTlacitka()) &&
                "imgJPEG/0.jpg".equals(this.pole[8].getObsahTlacitka()) ) {
            return true;
        } 
        
        if (this.hrac instanceof ZaciatocnikHrac &&
                "1".equals(this.pole[0].getObsahTlacitka()) && 
                "2".equals(this.pole[1].getObsahTlacitka()) &&  
                "3".equals(this.pole[2].getObsahTlacitka()) &&
                "4".equals(this.pole[3].getObsahTlacitka()) &&
                "5".equals(this.pole[4].getObsahTlacitka()) &&
                "6".equals(this.pole[5].getObsahTlacitka()) && 
                "7".equals(this.pole[6].getObsahTlacitka()) &&
                "8".equals(this.pole[7].getObsahTlacitka()) &&
                "".equals(this.pole[8].getObsahTlacitka()) ) {
            return true;
        }
        
        return false;
    }
    /**
     * Pridaj tlačítkam hrateľnosť myšou.
     */
    public void pridajOvladanieMysou() {
        
        for (IHratelny pom : this.pole) {
            pom.getTlacitko().addActionListener(this);
        }
        this.mniVyhraj.addActionListener(this);
        this.mniPravidla.addActionListener(this);
       
    }
    
    /**
     * Kontorluj kliknuté tlačítko a kontroluj výhru. 
     */
    public void actionPerformed(ActionEvent e) {
    
        String prazdne = this.pole[0].getObsahPrazdenho();
        
        if (e.getSource() == this.pole[0].getTlacitko()) {  
            String label = this.pole[0].getObsahTlacitka(); 
            this.pocetKrokov++;
            if (this.pole[1].jePrazdny()) {  
                this.pole[1].prepis(label);  
                this.pole[0].prepis(prazdne);  
            }  
            if (this.pole[3].jePrazdny()) {  
                this.pole[3].prepis(label);  
                this.pole[0].prepis(prazdne);   
            }   
        }  
    
        if (e.getSource() == this.pole[1].getTlacitko()) {  
            String label = this.pole[1].getObsahTlacitka(); 
            this.pocetKrokov++;
            if (this.pole[0].jePrazdny()) {  
                this.pole[0].prepis(label);  
                this.pole[1].prepis(prazdne);  
            }  
            if (this.pole[2].jePrazdny()) {  
                this.pole[2].prepis(label);  
                this.pole[1].prepis(prazdne);   
            }   
            if (this.pole[4].jePrazdny()) {  
                this.pole[4].prepis(label);  
                this.pole[1].prepis(prazdne);   
            } 
        }
    
        if (e.getSource() == this.pole[2].getTlacitko()) {  
            String label = this.pole[2].getObsahTlacitka(); 
            this.pocetKrokov++;
            if (this.pole[1].jePrazdny()) {  
                this.pole[1].prepis(label);  
                this.pole[2].prepis(prazdne);  
            }  
            if (this.pole[5].jePrazdny()) {  
                this.pole[5].prepis(label);  
                this.pole[2].prepis(prazdne);   
            }   
        }
    
        if (e.getSource() == this.pole[3].getTlacitko()) {  
            String label = this.pole[3].getObsahTlacitka(); 
            this.pocetKrokov++;
            if (this.pole[0].jePrazdny()) {  
                this.pole[0].prepis(label);  
                this.pole[3].prepis(prazdne);  
            }  
            if (this.pole[4].jePrazdny()) {  
                this.pole[4].prepis(label);  
                this.pole[3].prepis(prazdne);   
            }   
            if (this.pole[6].jePrazdny()) {  
                this.pole[6].prepis(label);  
                this.pole[3].prepis(prazdne);   
            } 
        }
    
        if (e.getSource() == this.pole[4].getTlacitko()) {  
            String label = this.pole[4].getObsahTlacitka(); 
            this.pocetKrokov++;
            if (this.pole[1].jePrazdny()) {  
                this.pole[1].prepis(label);  
                this.pole[4].prepis(prazdne);  
            }  
            if (this.pole[3].jePrazdny()) {  
                this.pole[3].prepis(label);  
                this.pole[4].prepis(prazdne);   
            }   
            if (this.pole[5].jePrazdny()) {  
                this.pole[5].prepis(label);  
                this.pole[4].prepis(prazdne);   
            }
            if (this.pole[7].jePrazdny()) {  
                this.pole[7].prepis(label);  
                this.pole[4].prepis(prazdne);   
            } 
        }
    
        if (e.getSource() == this.pole[5].getTlacitko()) {  
            String label = this.pole[5].getObsahTlacitka(); 
            this.pocetKrokov++;
            if (this.pole[2].jePrazdny()) {  
                this.pole[2].prepis(label);  
                this.pole[5].prepis(prazdne);  
            }  
            if (this.pole[4].jePrazdny()) {  
                this.pole[4].prepis(label);  
                this.pole[5].prepis(prazdne);   
            }   
            if (this.pole[8].jePrazdny()) {  
                this.pole[8].prepis(label);  
                this.pole[5].prepis(prazdne);   
            } 
        }
    
        if (e.getSource() == this.pole[6].getTlacitko()) {  
            String label = this.pole[6].getObsahTlacitka(); 
            this.pocetKrokov++;
            if (this.pole[3].jePrazdny()) {  
                this.pole[3].prepis(label);  
                this.pole[6].prepis(prazdne);  
            }  
            if (this.pole[7].jePrazdny()) {  
                this.pole[7].prepis(label);  
                this.pole[6].prepis(prazdne);   
            }   
        }
    
        if (e.getSource() == this.pole[7].getTlacitko()) {  
            String label = this.pole[7].getObsahTlacitka(); 
            this.pocetKrokov++;
            if (this.pole[6].jePrazdny()) {  
                this.pole[6].prepis(label);  
                this.pole[7].prepis(prazdne);  
            }  
            if (this.pole[4].jePrazdny()) {  
                this.pole[4].prepis(label);  
                this.pole[7].prepis(prazdne);   
            }   
            if (this.pole[8].jePrazdny()) {  
                this.pole[8].prepis(label);  
                this.pole[7].prepis(prazdne);   
            } 
        }

        if (e.getSource() == this.pole[8].getTlacitko()) {  
            String label = this.pole[8].getObsahTlacitka(); 
            this.pocetKrokov++;
            if (this.pole[5].jePrazdny()) {  
                this.pole[5].prepis(label);  
                this.pole[8].prepis(prazdne);  
            }  
            if (this.pole[7].jePrazdny()) {  
                this.pole[7].prepis(label);  
                this.pole[8].prepis(prazdne);   
            }   
        }
    
        if (e.getSource() == this.mniVyhraj) {
            this.vyhraj();
        }
    
        if (e.getSource() == this.mniPravidla) {
            String pravidla1 = "Pomocou myši posúvaj čísla na prázdne políčko a pokús sa zoradiť čísla od 1 po 8";
            String pravidla2 = "Pomocou myši posúvaj časti obrázku na prázdne políčko a pokús sa poskladať obrázok do správneho tvaru";
            if (this.hrac instanceof PokrocilyHrac) {
                JOptionPane.showMessageDialog(this, pravidla2, "Pravidlá", 1);
            }
            if (this.hrac instanceof ZaciatocnikHrac) {
                JOptionPane.showMessageDialog(this, pravidla1, "Pravidlá", 1);
            }
        }
    
    
    
        if (this.jeVyhra()) {
            try {
                this.hrac.setPocetKrokov(this.pocetKrokov);
                long start = this.hrac.getCasHry();
                this.hrac.setCasHry((System.currentTimeMillis() - start) / 1000);
                VyherneOknoGUI okno = new VyherneOknoGUI(this.hrac);
                this.setVisible(false);
                okno.setVisible(true);
                
            } catch (IOException ex) {
                System.err.println("Nepodarilo sa otvorit vyherne okno");
            }
        }
    
    }
   
    
    
   /**
     * Zoraď tlačítka do správneho poradia.
     */ 
    public void vyhraj() {
        if (this.hrac instanceof PokrocilyHrac) { 
            this.pole[0].prepis("imgJPEG/1.jpg");
            this.pole[1].prepis("imgJPEG/2.jpg");
            this.pole[2].prepis("imgJPEG/3.jpg");
            this.pole[3].prepis("imgJPEG/4.jpg");
            this.pole[4].prepis("imgJPEG/5.jpg");
            this.pole[5].prepis("imgJPEG/6.jpg");
            this.pole[6].prepis("imgJPEG/7.jpg");
            this.pole[7].prepis("imgJPEG/8.jpg");
            this.pole[8].prepis("imgJPEG/0.jpg");
            
        } 
        
        if (this.hrac instanceof ZaciatocnikHrac) { 
            this.pole[0].prepis("1");
            this.pole[1].prepis("2");
            this.pole[2].prepis("3");
            this.pole[3].prepis("4");
            this.pole[4].prepis("5");
            this.pole[5].prepis("6");
            this.pole[6].prepis("7");
            this.pole[7].prepis("8");
            this.pole[8].prepis("");
        } 
    }
    


    
}
