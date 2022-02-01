
package puzzle.grafika;

import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import puzzle.hrac.TypHraca;
import puzzle.hrac.ZoznamHracov;

/**
 * GUI kde zadá hráč svoje údaje a vyberie si náročnosť.
 * metóda kontroluje, či sa v zozname hráčov nachádza hráč so zadaným menom.
 * 
 * @author  Michal Murín
 * @version 2.0  (6 Maj 2020)
 */
public class AplikaciaPuzzleGUI extends javax.swing.JFrame {
    private final JFrame frame;
        
    /**
     * Vytvor GUI pre hráča.
     */
    public AplikaciaPuzzleGUI() {
        this.initComponents();
        this.frame = this;
        
        this.buttonGroup1.add(this.rdbPokrocily);
        this.buttonGroup1.add(this.rdbZaciatocnik);
        
        this.txfNickname.setText("Meno");
        this.cbxVek.setSelectedItem("20");
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        lblNickname = new javax.swing.JLabel();
        txfNickname = new javax.swing.JTextField();
        lblVek = new javax.swing.JLabel();
        cbxVek = new javax.swing.JComboBox<>();
        lblTypHraca = new javax.swing.JLabel();
        rdbZaciatocnik = new javax.swing.JRadioButton();
        rdbPokrocily = new javax.swing.JRadioButton();
        btnPokracuj = new java.awt.Button();
        lblUvod = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuProgram = new javax.swing.JMenu();
        mniKoniec = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblNickname.setText("Zadaj svoj nickname");

        lblVek.setText("Zadaj svoj vek");

        cbxVek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75" }));

        lblTypHraca.setText("Vyber si obtiažnosť");

        rdbZaciatocnik.setSelected(true);
        rdbZaciatocnik.setText("Začiatočník");

        rdbPokrocily.setText("Pokročilý");
        rdbPokrocily.setToolTipText("");

        btnPokracuj.setLabel("Pokračuj");
        btnPokracuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokracujActionPerformed(evt);
            }
        });

        lblUvod.setText("Vitaj v hre Puzzle !!");

        mnuProgram.setText("Program");

        mniKoniec.setText("Koniec");
        mniKoniec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKoniecActionPerformed(evt);
            }
        });
        mnuProgram.add(mniKoniec);

        jMenuBar1.add(mnuProgram);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbPokrocily)
                            .addComponent(rdbZaciatocnik)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblNickname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txfNickname)
                                .addComponent(lblVek)
                                .addComponent(cbxVek, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblTypHraca)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btnPokracuj, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUvod)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lblUvod)
                .addGap(18, 18, 18)
                .addComponent(lblNickname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVek)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxVek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTypHraca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbZaciatocnik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbPokrocily)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPokracuj, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Ukonči.
     */
    private void mniKoniecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKoniecActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mniKoniecActionPerformed

   
    /**
     * Pokračuj na ďalšie okno.
     */
    private void btnPokracujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokracujActionPerformed
        String nickname = this.txfNickname.getText();
        File pomSubor = new File("zoznamHracov.txt");
        if (pomSubor.length() != 0) {
            try {
                ZoznamHracov pomZoznam = new ZoznamHracov("zoznamHracov.txt");
                if (!pomZoznam.jeHrac(nickname)) {
                    
                    this.pokracuj();
                    
                } else {
                    JOptionPane.showMessageDialog(null , "Vymysli si iné meno, meno " + nickname + " sa už v zozname nachádza.");
                    
                }
            } catch (IOException ex) {
                System.err.println("Nepodarilo sa nacitat pomocny zoznam");
            }
        }
        if (pomSubor.length() == 0) {
            this.pokracuj();
        }
       
       
                    
        
        
        
        
    }//GEN-LAST:event_btnPokracujActionPerformed
    /**
     * Pomocná metóda pre pokračovanie.
     */
    private void pokracuj() {
        String nickname = this.txfNickname.getText();
        int vek = Integer.valueOf((String)this.cbxVek.getSelectedItem());
        TypHraca typ = null;
        
        if (this.rdbPokrocily.isSelected()) {
            typ = TypHraca.POKROCILY;
            ApliakciaPokrocilyGUI novyPokrocilyHrac = new ApliakciaPokrocilyGUI(nickname , vek , typ);
            novyPokrocilyHrac.setVisible(true);
        }
        if (this.rdbZaciatocnik.isSelected()) {
            typ = TypHraca.ZACIATOCNIK;
            AplikaciaZaciatocnikGUI novyZaciatocnik = new AplikaciaZaciatocnikGUI(nickname , vek , typ);
            novyZaciatocnik.setVisible(true);
        }
        this.frame.setVisible(false);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AplikaciaPuzzleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikaciaPuzzleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikaciaPuzzleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikaciaPuzzleGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikaciaPuzzleGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnPokracuj;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxVek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblNickname;
    private javax.swing.JLabel lblTypHraca;
    private javax.swing.JLabel lblUvod;
    private javax.swing.JLabel lblVek;
    private javax.swing.JMenuItem mniKoniec;
    private javax.swing.JMenu mnuProgram;
    private javax.swing.JRadioButton rdbPokrocily;
    private javax.swing.JRadioButton rdbZaciatocnik;
    private javax.swing.JTextField txfNickname;
    // End of variables declaration//GEN-END:variables
}
