
package puzzle.tlacitka;


import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * Tlačítko level 2, ktoré implementuje IHratelny, vytvorí JButton s ikonou ktorá je načítaná zo súboru.
 * 
 * @author  Michal Murín
 * @version 2.0  (6 Maj 2020)
 */
public class Tlacitko2 implements IHratelny {
    private JButton tlacitko;
    private String obsahTlacitka;
    private Icon icon;
    /**
     * Vytvor tlačítko levelu 2 so zadanou cestou k suboru s ikonou.
     * @param obsahTlacitka
     * @throws java.io.IOException
     */
    public Tlacitko2(String obsahTlacitka) throws IOException {
        if (obsahTlacitka == null) {
            throw new IllegalArgumentException("nenajdeny obsah tlacitka");
        }
        this.obsahTlacitka = obsahTlacitka;
        //this.icon = new ImageIcon(obsahTlacitka);
        this.icon = new ImageIcon(ImageIO.read(new File(obsahTlacitka)));
           
        this.tlacitko = new JButton(this.icon);
        
        
    }
    /**
     * Vráť obsah tlačítka.
     * @return 
     */
    public String getObsahTlacitka() {
        return this.obsahTlacitka;
    }
    /**
     * Prepíš ikonu na tlačítku podľa novej cestz k súboru s novou ikonou.
     * @param novyObsah
     */
    public void prepis(String novyObsah) {
        
        if (novyObsah == null) {
            throw new IllegalArgumentException("nenajdeny obsah tlacitka");
        }
        
        Icon i = null;
        try {
            i = new ImageIcon(ImageIO.read(new File(novyObsah)));
        } catch (IOException ex) {
            System.err.println("Nepodarilo sa nacitat obrazok");
        }

        this.tlacitko.setIcon(i);
        this.obsahTlacitka = novyObsah;
    }
    
    /**
     * Zisti či je tlačítko prázdne.
     * @return 
     */
    public boolean jePrazdny() {
        return this.obsahTlacitka.equals(this.getObsahPrazdenho());
    }
    /**
     * Vráť JButton.
     * @return 
     */
    public JButton getTlacitko() {
        return this.tlacitko;
    }

    /**
     * Vráť cestu k ikone prázdneho tlačítka.
     * @return 
     */
    public String getObsahPrazdenho() {
        return "imgJPEG/0.jpg";
    }

    

   
}
