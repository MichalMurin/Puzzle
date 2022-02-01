
package puzzle.tlacitka;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Tlačítko level 1, ktoré implementuje IHratelny, vytvorí JButton s popisom typu String.
 * 
 * @author  Michal Murín
 * @version 2.0  (6 Maj 2020)
 */
public class Tlacitko1 implements IHratelny {
    private JButton tlacitko;
    private String obsahTlacitka;
    
    /**
     * Vytvor tlačítko levelu 1 so zadaným obsahom.
     * @param obsahTlacitka
     */
    public Tlacitko1(String obsahTlacitka) {
        if (obsahTlacitka == null) {
            throw new IllegalArgumentException("nenajdeny obsah tlacitka");
        }
        this.obsahTlacitka = obsahTlacitka;
        this.tlacitko = new JButton(obsahTlacitka);
        this.nastylizuj();
        
    }
    /**
     * Vráť obsah tlačítka.
     * @return 
     */
    public String getObsahTlacitka() {
        return this.obsahTlacitka;
    }
    /**
     * Vráť JButton.
     * @return 
     */
    public JButton getTlacitko() {
        return this.tlacitko;
    }
    /**
     * Naštylizuj tlačítko .
     */
    private void nastylizuj() {
        Font font = new Font("Tahoma" , Font.BOLD , 40);
        this.tlacitko.setFont(font);
        this.tlacitko.setForeground(Color.WHITE);
        this.tlacitko.setBackground(Color.BLACK);
        Border line = new LineBorder(Color.WHITE);
        Border margin = new EmptyBorder(5 , 15 , 5 , 15);
        Border compound = new CompoundBorder(line , margin);
        this.tlacitko.setBorder(compound);
    }
    /**
     * Prepíš nápis na tlačítku.
     * @param novyObsah
     */
    public void prepis(String novyObsah) {
        
        if (novyObsah == null) {
            throw new IllegalArgumentException("nenajdeny obsah tlacitka");
        }
        this.tlacitko.setText(novyObsah);
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
     * Vráť obsah prázdneho tlačítka.
     * @return 
     */
    public String getObsahPrazdenho() {
        return "";
    }
}
