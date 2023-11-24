package Form;
import Koneksi_DB.koneksinya;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.*;
/**
 *
 * @author Rudiono
 */
public class Form_KategoriObat extends javax.swing.JFrame {

    ResultSet rs;
    
    /**
     * Creates new form Form_KategoriObat
     */
    public Form_KategoriObat() {
        initComponents();
        Datatabel();
    }
    
    int row=0;
    public void Tabelklik(){
        row=tabelkategori.getSelectedRow();
        txtidkategori.setText(tabelkategori.getValueAt(row, 0).toString());
        txtnama.setText(tabelkategori.getValueAt(row, 1).toString());
    }
    
    private void Autonomor(){
        String sql = "select max(id_kategori) from kategori";
        try{
            Statement state  = koneksinya.Koneksi().createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()){
                int a = rs.getInt(1);
                txtidkategori.setText("00"+ Integer.toString(a+1));
            }
        }catch (Exception e){
            System.out.println(""+ e.getMessage());
        }
    }
    
    public void Reset(){
        txtidkategori.setText(null);
        txtnama.setText(null);
    }
    
    public void Datatabel(){
       DefaultTableModel tabel = new DefaultTableModel();
       tabel.addColumn("ID KATEGORI");
       tabel.addColumn("NAMA KATEGORI");
       try{
           Statement state  = koneksinya.Koneksi().createStatement();
           rs = state.executeQuery("Select * from kategori");
           while(rs.next()){
               tabel.addRow(new Object[]{
                   rs.getString(1),
                   rs.getString(2),
               });
               tabelkategori.setModel(tabel);
           }
           state.close();
           rs.close();
       }
       catch(Exception e){
           System.out.println(e);
       }
    }
    
    public void Simpan(){
        String id = txtidkategori.getText();
        String nama = txtnama.getText();
        try{
            Statement state  = koneksinya.Koneksi().createStatement();
            state.executeUpdate("insert into kategori values ('"+id+"','"+nama+"')");
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan !");
            Reset();
            state.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Data Gagal Disimpan !");
        }
    }
    
    public void Update(){
        String id = txtidkategori.getText();
        String nama = txtnama.getText();
        try{
            Statement state  = koneksinya.Koneksi().createStatement();
            state.executeUpdate("update kategori set nama_kategori='"+nama
                    +"' where id_kategori='"+id+"';");
            JOptionPane.showMessageDialog(this, "Data Berhasil Diupdate !");
            Reset();
            state.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Data Gagal Diupdate !");
        }
    }
    
    public void Delete(){
        String id = txtidkategori.getText();
        try {
            Statement state  = koneksinya.Koneksi().createStatement();
            state.executeUpdate("delete from kategori where id_kategori='"+id+"';");
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus !");
            Reset();
            state.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Data Gagal Dihapus !");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelkategori = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtidkategori = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        btnget = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/books.png"))); // NOI18N
        jLabel3.setText("KATEGORI OBAT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        tabelkategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "ID KATEGORI", "KATEGORI OBAT"
            }
        ));
        tabelkategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelkategori);

        jLabel1.setText("ID KATEGORI");

        jLabel2.setText("NAMA KATEGORI");

        txtidkategori.setEnabled(false);

        btnget.setText("GET CODE");
        btnget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngetActionPerformed(evt);
            }
        });

        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save Blue 24 n p8.png"))); // NOI18N
        btnsimpan.setText("SIMPAN");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Edit.png"))); // NOI18N
        btnupdate.setText("UPDATE");
        btnupdate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnupdateStateChanged(evt);
            }
        });
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Recycle Bin.png"))); // NOI18N
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Back.png"))); // NOI18N
        jButton1.setText("BACK");
        jButton1.setMaximumSize(new java.awt.Dimension(117, 33));
        jButton1.setMinimumSize(new java.awt.Dimension(117, 33));
        jButton1.setPreferredSize(new java.awt.Dimension(117, 33));
        jButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jButton1ItemStateChanged(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnama)
                    .addComponent(txtidkategori))
                .addGap(18, 18, 18)
                .addComponent(btnget)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnsimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnupdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtidkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnget))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpan)
                    .addComponent(btnupdate)
                    .addComponent(btndelete)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnupdateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnupdateStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnupdateStateChanged

    private void btngetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngetActionPerformed
        // TODO add your handling code here:
        Autonomor();
    }//GEN-LAST:event_btngetActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        Simpan();
        Reset();
        Datatabel();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        Update();
        Reset();
        Datatabel();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        Delete();
        Datatabel();
        Reset();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void tabelkategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkategoriMouseClicked
        if(evt.getClickCount()==1){
            Tabelklik();
        }
        
    }//GEN-LAST:event_tabelkategoriMouseClicked

    private void jButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jButton1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu_Utama MU = new Menu_Utama();
        this.setVisible(false);
        MU.setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Form_KategoriObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_KategoriObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_KategoriObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_KategoriObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_KategoriObat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnget;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelkategori;
    private javax.swing.JTextField txtidkategori;
    private javax.swing.JTextField txtnama;
    // End of variables declaration//GEN-END:variables
}
