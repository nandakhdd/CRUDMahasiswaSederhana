/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.crudmahasiswasederhana.views;

import com.mycompany.crudmahasiswasederhana.controller.MahasiswaController;
import com.mycompany.crudmahasiswasederhana.interfc.MahasiswaInterface;
import com.mycompany.crudmahasiswasederhana.models.Mahasiswa;
import java.util.List;
//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author HP
 */
public class MahasiswaFrame extends javax.swing.JFrame {
    List<Mahasiswa> record=new ArrayList<Mahasiswa>();
    MahasiswaInterface mhsServis;
    int row;
    /**
     * Creates new form MahasiswaFrame
     */
    /**
     * Creates new form MahasiswaFrame
     */
    public MahasiswaFrame() {
        initComponents();
        mhsServis = new MahasiswaController();
        
        mahasiswaTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                row=mahasiswaTable.getSelectedRow();
                if(row!=-1){
                    isiText();
                }
            }
        });
        this.statusAwal();
                
    }
    
    void loadData(){
        try{
            record = mhsServis.getAll();
        }catch (SQLException ex){
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    void isiTabel(){
        Object data[][]=new Object[record.size()][3];
        int x=0;
        for(Mahasiswa mhs:record){
            data[x][0]=mhs.getNim();
            data[x][1]=mhs.getNama();
            data[x][2]=mhs.getAlamat();
            x++;
        }
        String judul[]={"nim","nama","alamat"};
        mahasiswaTable.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(mahasiswaTable);

    }
    
    void isiText(){
        Mahasiswa mhs=record.get(row);
        nimText.setText(mhs.getNim());
        namaText.setText(mhs.getNama());
        alamatText.setText(mhs.getAlamat());
        
    }
    
    void kosongkanText(){
            nimText.setText("");
            namaText.setText("");
            alamatText.setText("");
    }
    
    void statusAwal(){
            kosongkanText();
            loadData();
            isiTabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nimText = new javax.swing.JTextField();
        namaText = new javax.swing.JTextField();
        alamatText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        mahasiswaTable = new javax.swing.JTable();
        tambahBtn = new javax.swing.JButton();
        ubahBtn = new javax.swing.JButton();
        hapusBtn = new javax.swing.JButton();
        nimLabel = new javax.swing.JLabel();
        namaLabel = new javax.swing.JLabel();
        alamatLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nimText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimTextActionPerformed(evt);
            }
        });

        mahasiswaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(mahasiswaTable);

        tambahBtn.setText("Tambah");
        tambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBtnActionPerformed(evt);
            }
        });

        ubahBtn.setText("Ubah");
        ubahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahBtnActionPerformed(evt);
            }
        });

        hapusBtn.setText("Hapus");
        hapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBtnActionPerformed(evt);
            }
        });

        nimLabel.setText("NIM");

        namaLabel.setText("Nama");

        alamatLabel.setText("Alamat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nimLabel)
                            .addComponent(namaLabel)
                            .addComponent(alamatLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nimText, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(namaText)
                            .addComponent(alamatText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tambahBtn)
                            .addComponent(ubahBtn)
                            .addComponent(hapusBtn))
                        .addGap(2, 2, 2)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nimText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahBtn)
                    .addComponent(nimLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ubahBtn)
                    .addComponent(namaLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alamatText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusBtn)
                    .addComponent(alamatLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nimTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nimTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nimTextActionPerformed

    private void hapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBtnActionPerformed
        // TODO add your handling code here:
        try{
            String nim = nimText.getText();
            mhsServis.delete(nim);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data berhasil dihapus");
        }catch (SQLException ex){
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_hapusBtnActionPerformed

    private void tambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBtnActionPerformed
        // TODO add your handling code here:
        try{
          // TODO add your handlings code here
        Mahasiswa mhs = new Mahasiswa();
        mhs.setNim(nimText.getText());
        mhs.setNama(namaText.getText());
        mhs.setAlamat(alamatText.getText());
        mhsServis.insert(mhs);
        this.statusAwal();
        JOptionPane.showMessageDialog(this, "data tersimpan"); 
       }catch (SQLException ex){
           Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tambahBtnActionPerformed

    private void ubahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahBtnActionPerformed
        // TODO add your handling code here:
        try{
          // TODO add your handlings code here
        Mahasiswa mhs = new Mahasiswa();
        mhs.setNim(nimText.getText());
        mhs.setNama(namaText.getText());
        mhs.setAlamat(alamatText.getText());
        mhsServis.update(mhs);
        this.statusAwal();
        JOptionPane.showMessageDialog(this, "data berhasil diubah"); 
       }catch (SQLException ex){
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ubahBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MahasiswaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamatLabel;
    private javax.swing.JTextField alamatText;
    private javax.swing.JButton hapusBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mahasiswaTable;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JTextField namaText;
    private javax.swing.JLabel nimLabel;
    private javax.swing.JTextField nimText;
    private javax.swing.JButton tambahBtn;
    private javax.swing.JButton ubahBtn;
    // End of variables declaration//GEN-END:variables
}
