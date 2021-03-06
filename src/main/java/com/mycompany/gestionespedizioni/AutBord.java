/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionespedizioni;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caggi
 */
public class AutBord extends javax.swing.JFrame {

    Connection conn = null;
    ArrayList<Bordero> Ab;
    ArrayList<Persona> nom = new ArrayList<Persona>();
    SalvaBord sb;

    /**
     * Creates new form AutBord
     */
    public AutBord() {
        initComponents();
    }

    public SalvaBord getSb() {
        return sb;
    }

    public void setSb(SalvaBord sb) {
        this.sb = sb;
    }

    public ArrayList<Persona> getNom() {
        return nom;
    }

    public void setNom(ArrayList<Persona> nom) {
        this.nom = nom;
    }

    public ArrayList<Bordero> getAb() {
        return Ab;
    }

    public void setAb(ArrayList<Bordero> Ab) {
        this.Ab = Ab;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        bord = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COGNOME", "NOME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tab);

        bord.setText("APRI BORDERO'");
        bord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bord)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bord)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setNominativi(ArrayList<Bordero> ab) {
        Boolean b = false;
        ArrayList<Persona> n = new ArrayList<>();
        n.clear();
        Integer dim = ab.size(), dim2;

        //ciclo per il numero di spedizioni assegnate
        for (Integer i = 0; i < dim; i++) {
            b = false;
            Persona p = new Persona();
            p.setNome(ab.get(i).getA().getNome());
            p.setCognome(ab.get(i).getA().getCognome());

            dim2 = n.size();
            //ciclo per il numero di autisti inseriti
            for (Integer j = 0; j < dim2; j++) {
                //b=false;
                if (n.get(j).getCognome().equalsIgnoreCase(p.getCognome()) && n.get(j).getNome().equalsIgnoreCase(p.getNome())) {
                    b = true;
                }
            }
            if (!b) {
                n.add(p);
            }

        }
        this.setNom(n);
    }

    public ArrayList<Persona> getNominativo() {
        return nom;
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        this.setNominativi(Ab);
        Integer dim = this.getNom().size();
        DefaultTableModel model = (DefaultTableModel) tab.getModel();
        tab.setShowGrid(true);
        tab.setShowHorizontalLines(true);
        for (Integer i = 0; i < dim; i++) {
            model.addRow(new Object[]{this.getNom().get(i).getCognome().toUpperCase(), this.getNom().get(i).getNome().toUpperCase()});
        }

        //salvataggio dei bordero
        sb = new SalvaBord();
        sb.setAb(this.getAb());
        sb.start();
    }//GEN-LAST:event_formComponentShown

    private void bordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bordActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tab.getModel();
        //System.out.println(model.getValueAt(tab.getSelectedRow(), 0)+" "+model.getValueAt(tab.getSelectedRow(), 1));
        VisBord v = new VisBord();
        v.setCognome(model.getValueAt(tab.getSelectedRow(), 0).toString().toLowerCase());
        v.setNome(model.getValueAt(tab.getSelectedRow(), 1).toString().toLowerCase());
        v.setAb(this.getAb());
        v.setVisible(true);
    }//GEN-LAST:event_bordActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        try {
            try {
                if (this.getSb().isAlive()) {

                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    this.getSb().join();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    try {
                        conn.close();
                    } catch (SQLException sql) {
                        Err e = new Err();
                        e.setMsgtxt("DB ERROR. ERROR CODE " + sql.getErrorCode() + ", SQL STATE " + sql.getSQLState());
                        e.setVisible(true);
                    }
                    System.exit(0);
                }
            } catch (InterruptedException ie) {
                try {
                    conn.close();
                } catch (SQLException sql) {
                    Err e = new Err();
                    e.setMsgtxt("DB ERROR. ERROR CODE " + sql.getErrorCode() + ", SQL STATE " + sql.getSQLState());
                    e.setVisible(true);
                }
                ie.printStackTrace();
            }
        } catch (NullPointerException np) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(AutBord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutBord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutBord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutBord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutBord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bord;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tab;
    // End of variables declaration//GEN-END:variables
}
