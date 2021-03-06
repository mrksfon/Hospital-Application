/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.TipDoktora;
import models.TipDoktoraTableModel;
import tipDoktoraController.TipDoktoraController;
import tipDoktoraController.TipDoktoraFormController;

/**
 *
 * @author Marenda
 */
public class PrikazSvihTipovaDoktora extends javax.swing.JFrame {

    private TipDoktoraController kontroler;

    /**
     * Creates new form PrikazSvihTipovaDoktora
     */
    public PrikazSvihTipovaDoktora() {
        initComponents();
        kontroler = new TipDoktoraController();
        initForma();
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
        jTableTipoviDoktora = new javax.swing.JTable();
        jButtonKreiraj = new javax.swing.JButton();
        jButtonObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableTipoviDoktora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableTipoviDoktora);

        jButtonKreiraj.setText("Kreiraj ");
        jButtonKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKreirajActionPerformed(evt);
            }
        });

        jButtonObrisi.setText("Obrisi");
        jButtonObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonKreiraj, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jButtonObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonKreiraj)
                .addGap(18, 18, 18)
                .addComponent(jButtonObrisi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKreirajActionPerformed
        kreirajNoviTipDoktora();
    }//GEN-LAST:event_jButtonKreirajActionPerformed

    private void jButtonObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObrisiActionPerformed
        obrisiTipDoktora();
    }//GEN-LAST:event_jButtonObrisiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonKreiraj;
    private javax.swing.JButton jButtonObrisi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTipoviDoktora;
    // End of variables declaration//GEN-END:variables

    public void initForma() {
        try {
            List<TipDoktora> tipoviDoktora = kontroler.loadAll();
            jTableTipoviDoktora.setModel(new TipDoktoraTableModel(tipoviDoktora));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void kreirajNoviTipDoktora() {
        TipDoktoraFormController.getInstance().prikaziFormuZaKreirajne();
    }

    private void obrisiTipDoktora() {
        int selectedItem = jTableTipoviDoktora.getSelectedRow();

        TipDoktora zaBrisanje = getModel().get(selectedItem);

        try {
            TipDoktora obrisan = kontroler.delete(zaBrisanje);

            new Thread(new Runnable() {

                @Override
                public void run() {
                    TipDoktoraFormController.getInstance().tipDoktoraChanged();
                }
            }).start();
            JOptionPane.showMessageDialog(this, "Sistem je obrisao tip doktora");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise podatke o tipu doktora");
        }
    }

    private TipDoktoraTableModel getModel() {
        return (TipDoktoraTableModel) jTableTipoviDoktora.getModel();
    }
}
