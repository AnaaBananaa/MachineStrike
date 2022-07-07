/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Observer.ObservadorEscolhaPersonagem;
import controler.ControladorEscolhaPersonagem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Personagem;
import model.Personagem1;
import model.Personagem2;

/**
 *
 * @author Aners
 */
public class escolhaPersonagem extends javax.swing.JFrame implements ObservadorEscolhaPersonagem {

    /**
     * Creates new form escolhaPersonagem
     */
    private ControladorEscolhaPersonagem uc;
    private escolhaMapa ep = new escolhaMapa();

    public escolhaPersonagem() {
        this.uc = new ControladorEscolhaPersonagem();
        this.uc.anexar(this);
        initComponents();
        personagem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uc.salvarPeronsagem(new Personagem1(uc.getJogador()));
                } catch (Exception ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        btnPersonagem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uc.salvarPeronsagem(new Personagem2(uc.getJogador()));
                } catch (Exception ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnContinuar.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uc.verificaPersonagem();
            }
        }
        );
        btnDesfaz.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                uc.desfazerEscolha();
            }
        }
        );
        btnMudaJogador.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                uc.mudarJogador();
            }
        }
        );
    }

    @Override
    public void exibirTela() {
        setVisible(true);
    }

    @Override
    public void mostrarPersonagem(List<Personagem> p) {
        txtAreaPersonagens.setText(p.toString());
    }

    @Override
    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    /**
     * Creates new form inicio
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        personagem1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnPersonagem2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaPersonagens = new javax.swing.JTextArea();
        btnContinuar = new javax.swing.JButton();
        btnMudaJogador = new javax.swing.JButton();
        btnDesfaz = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p1/p1Frente.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        personagem1.setText("ESCOLHER");
        personagem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personagem1ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p2/p2Frente.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        btnPersonagem2.setText("ESCOLHER");

        txtAreaPersonagens.setColumns(20);
        txtAreaPersonagens.setRows(5);
        jScrollPane1.setViewportView(txtAreaPersonagens);

        btnContinuar.setText("CONTINUAR >");

        btnMudaJogador.setText("Mudar Jogador");

        btnDesfaz.setText("Desfazer Escolha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDesfaz, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                        .addComponent(btnMudaJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(personagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnPersonagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(personagem1)
                    .addComponent(btnPersonagem2))
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinuar)
                    .addComponent(btnMudaJogador)
                    .addComponent(btnDesfaz))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void personagem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personagem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personagem1ActionPerformed

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
            java.util.logging.Logger.getLogger(escolhaPersonagem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(escolhaPersonagem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(escolhaPersonagem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(escolhaPersonagem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new escolhaPersonagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnDesfaz;
    private javax.swing.JButton btnMudaJogador;
    private javax.swing.JButton btnPersonagem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton personagem1;
    private javax.swing.JTextArea txtAreaPersonagens;
    // End of variables declaration//GEN-END:variables

    @Override
    public void exibirProxTela() {
        ep.exibirTela();
    }

}
