/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Zvanje;
import models.ZvanjeTableModel;
import zvanjeController.ZvanjeController;
import zvanjeController.ZvanjeFormController;

/**
 *
 * @author Marenda
 */
public class PrikazSvihZvanja extends javax.swing.JFrame {

    private ZvanjeController kontroler;

    /**
     * Creates new form PrikazSvihZvanja
     */
    public PrikazSvihZvanja() {
        initComponents();
        kontroler = new ZvanjeController();
        initTable();

        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonKreiraj = new javax.swing.JButton();
        jButtonIzmeni = new javax.swing.JButton();
        jButtonPrikazi = new javax.swing.JButton();
        jButtonObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
        );

        jButtonKreiraj.setText("Kreiraj");
        jButtonKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKreirajActionPerformed(evt);
            }
        });

        jButtonIzmeni.setText("Izmeni");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });

        jButtonPrikazi.setText("Prikazi");
        jButtonPrikazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrikaziActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonKreiraj, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(482, 482, 482)
                        .addComponent(jButtonIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(482, 482, 482)
                        .addComponent(jButtonPrikazi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(482, 482, 482)
                        .addComponent(jButtonObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButtonKreiraj)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonIzmeni)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonPrikazi)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonObrisi)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKreirajActionPerformed
        try {
            Zvanje z = kontroler.kreirajZvanje("NOVO");
            if (z != null) {
                addZvanjeToTable(z);
                showEditForm(z);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonKreirajActionPerformed

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                Zvanje z = getModel().getZvanje(selectedRow);
                ZvanjeFormController.getInstance().openEditZvanjeForm(z);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    private void jButtonPrikaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrikaziActionPerformed
        prikaziZvanje();
    }//GEN-LAST:event_jButtonPrikaziActionPerformed

    private void jButtonObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObrisiActionPerformed
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow >= 0) {
            try {
                Integer zvanjeId = getModel().getSelectedZvanjeId(selectedRow);
                Zvanje obrisanoZvanje = kontroler.deleteZvanje(zvanjeId);
                if (obrisanoZvanje != null) {
                    getModel().removeZvanje(obrisanoZvanje.getId());
                    JOptionPane.showMessageDialog(this, "Sistem je obrisao zvanje");
                    ZvanjeFormController.getInstance().zvanjeChanged();
                } else {
                    JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise znanje");
                }
            } catch (NumberFormatException nfe) {

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise zvanje");
            }
        }
    }//GEN-LAST:event_jButtonObrisiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonKreiraj;
    private javax.swing.JButton jButtonObrisi;
    private javax.swing.JButton jButtonPrikazi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private ZvanjeTableModel getModel() {
        return (ZvanjeTableModel) jTable1.getModel();
    }

    private void initTable() {
        popuniTabelu();
        TableModel model = new ZvanjeTableModel();
        jTable1.setModel(model);
        jTable1.setAutoCreateRowSorter(true);
    }

    public void popuniTabelu() {
        try {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        List<Zvanje> lista = kontroler.loadAll();
                        getModel().setZvanja(lista);
                    } catch (Exception ex) {
                        ex.printStackTrace();
//                        JOptionPane.showMessageDialog(this, ex.getMessage());
                    }
                }
            });
            thread.start();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void addZvanjeToTable(Zvanje z) {
        getModel().addZvanje(z);
    }

    private void showEditForm(Zvanje z) {
        try {
            ZvanjeFormController.getInstance().openEditZvanjeForm(z);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void prikaziZvanje() {
        int selectedRow = jTable1.getSelectedRow();
        Zvanje selektovanoZvanje = getModel().getZvanje(selectedRow);
        try {
            ZvanjeFormController.getInstance().prikaziIzabranoZvanje(selektovanoZvanje);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
