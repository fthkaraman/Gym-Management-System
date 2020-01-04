package web;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fatih
 */
public class Sube extends javax.swing.JDialog {
    DefaultTableModel model;
    Web islemler = new Web();
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private Frame frame;

    /**
     * Creates new form Sube
     */
    public Sube(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = (DefaultTableModel) sube_tablo.getModel();
        subeGoruntule();       
    }
    Sube(int subeID, String subeAd, String sehirAd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sube_tablo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        sube_alani = new javax.swing.JTextField();
        sube_guncelle = new javax.swing.JButton();
        mesaj_alani = new javax.swing.JLabel();
        sube_sil = new javax.swing.JButton();
        sube_ekle = new javax.swing.JButton();
        sehir_liste = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sube_tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Şube ID", "Şube Ad", "Şehir Ad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sube_tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sube_tabloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sube_tablo);
        if (sube_tablo.getColumnModel().getColumnCount() > 0) {
            sube_tablo.getColumnModel().getColumn(0).setResizable(false);
            sube_tablo.getColumnModel().getColumn(1).setResizable(false);
            sube_tablo.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 272, -1, 153));

        jLabel1.setText("Şube:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 77, -1, -1));
        getContentPane().add(sube_alani, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 74, 114, -1));

        sube_guncelle.setText("Güncelle");
        sube_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sube_guncelleActionPerformed(evt);
            }
        });
        getContentPane().add(sube_guncelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 171, -1, -1));
        getContentPane().add(mesaj_alani, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 206, 152, 19));

        sube_sil.setText("Sil");
        sube_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sube_silActionPerformed(evt);
            }
        });
        getContentPane().add(sube_sil, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 171, -1, -1));

        sube_ekle.setText("Ekle");
        sube_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sube_ekleActionPerformed(evt);
            }
        });
        getContentPane().add(sube_ekle, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 171, -1, -1));

        sehir_liste.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "istanbul", "izmir", "ankara", "bursa", "balıkesir", "adana" }));
        sehir_liste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sehir_listeActionPerformed(evt);
            }
        });
        getContentPane().add(sehir_liste, new org.netbeans.lib.awtextra.AbsoluteConstraints(577, 74, 114, -1));

        jLabel3.setText("Şehir Listesi:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 77, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Şube ve Şehir");

        back.setIcon(new javax.swing.ImageIcon("C:\\Users\\Fatih\\Documents\\NetBeansProjects\\Web\\src\\web\\images\\icons8_undo_26px_1.png")); // NOI18N
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 219, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sube_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sube_guncelleActionPerformed
        
        String subeAd = sube_alani.getText();
        String sehirAd = sehir_liste.getSelectedItem().toString();
        
        int selectedrow = sube_tablo.getSelectedRow();
        
        if(selectedrow == -1){
            
            if(model.getRowCount() == 0){
                mesaj_alani.setText("Tablo boş!");
            }
            else{
                mesaj_alani.setText("Şube seçin!");
            }
        }
        else{
            int subeID = (int)model.getValueAt(selectedrow, 0);
            
            islemler.subeGuncelle(subeID,subeAd);
            
            subeGoruntule();
            
            mesaj_alani.setText("Başarıyla güncellendi.");
        }
    }//GEN-LAST:event_sube_guncelleActionPerformed

    private void sube_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sube_silActionPerformed
               
        int selectedrow = sube_tablo.getSelectedRow();
        
        if(selectedrow == -1){
            if(model.getRowCount() == 0){
                mesaj_alani.setText("Tablo boş.");
            }
            else{
                mesaj_alani.setText("Şube seçin!");
            }
        }
        else{
            int subeID = (int)model.getValueAt(selectedrow,0);
            
            islemler.subeSil(subeID);
            
            subeGoruntule();
            
            mesaj_alani.setText("Başarıyla silindi.");
        }
    }//GEN-LAST:event_sube_silActionPerformed

    private void sube_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sube_ekleActionPerformed
        
        String sehirAd = sehir_liste.getSelectedItem().toString();
        String subeAd = sube_alani.getText();
                                       
        islemler.subeEkle(sehirAd,subeAd);
        
        subeGoruntule();
        
        mesaj_alani.setText("Başarıyla eklendi.");
    }//GEN-LAST:event_sube_ekleActionPerformed

    private void sehir_listeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sehir_listeActionPerformed
             
        
    }//GEN-LAST:event_sehir_listeActionPerformed

    private void sube_tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sube_tabloMouseClicked
        int selectedrow = sube_tablo.getSelectedRow();
        
        sube_alani.setText(model.getValueAt(selectedrow, 1).toString());
        
    }//GEN-LAST:event_sube_tabloMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        AdminPanel adminEkrani = new AdminPanel(frame,true);
        setVisible(false);

        adminEkrani.setVisible(true);
        System.exit(0);
    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void subeGoruntule(){
        model.setRowCount(0); 
          
        ArrayList<SubeBilgi> subeler = new ArrayList<SubeBilgi>();
              
        subeler = islemler.subeGoster();
        
        if(subeler != null){
            for(SubeBilgi sube : subeler){
                Object[] eklenecek = {sube.getSubeID(),sube.getSubeAd(),sube.getSehirAd()};              
                model.addRow(eklenecek);
                //sehir_liste.addItem(sube.getSehirAd());              
            }
        }
        
    }
        
    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Sube.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sube.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sube.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sube.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Sube dialog = new Sube(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel mesaj_alani;
    private javax.swing.JComboBox<String> sehir_liste;
    private javax.swing.JTextField sube_alani;
    private javax.swing.JButton sube_ekle;
    private javax.swing.JButton sube_guncelle;
    private javax.swing.JButton sube_sil;
    private javax.swing.JTable sube_tablo;
    // End of variables declaration//GEN-END:variables
}