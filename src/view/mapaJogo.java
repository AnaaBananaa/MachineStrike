/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import draw.Canva;
import draw.Paint;
import Singleton.Jogo;
import composite.Personagens;
import controler.ControladorJogo;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Personagem;

/**
 *
 * @author Aners
 */
public class mapaJogo extends javax.swing.JFrame implements Observer.ObservadorMapaJogo {

    /**
     * Creates new form mapaJogo
     */
    private ControladorJogo controladorJogo = new ControladorJogo();
    public static List<JLabel> labels = new ArrayList<>();
    private static Personagem pAux = null;

    public mapaJogo() {
        controladorJogo.anexar(this);
        initComponents();
        habilitaBotoes();
        defineLabel();
        jPanel2.setOpaque(false);
        jPanel2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (controladorJogo.getPersonagens().size() > 0) {
                    controladorJogo.validaPosicao(pAux, e.getX(), e.getY());
                } else {
                    pAux = controladorJogo.getPeca(e.getX(), e.getY());
                    controladorJogo.acao(e.getX(), e.getY());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        comboPersonagens.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                pAux = (Personagem) e.getItem();
            }
        });
        btnMatar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorJogo.setPersonagemSelecionado(pAux);
                controladorJogo.escolhePersonagem(2);
                selecionaLimitesAtaque();
            }
        });
        btnMover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorJogo.setPersonagemSelecionado(pAux);
                controladorJogo.escolhePersonagem(1);
                selecionaLimites();
            }
        });
        btnGirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorJogo.setPersonagemSelecionado(pAux);
                controladorJogo.escolhePersonagem(3);
                controladorJogo.acao(0, 0);
            }
        });
        btnSobAtaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorJogo.escolhePersonagem(4);
                selecionaLimitesAtaque();
            }
        });
        btnSobMover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorJogo.escolhePersonagem(5);
                selecionaLimites();
            }
        });
        btnTurno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controladorJogo.alteraTurno();
            }
        });
    }

    @Override
    public void selecionaLimites() {
        if (controladorJogo.getPersonagemSelecionado() != null) {
            List<JLabel> lSprint = new ArrayList<>();
            List<JLabel> l = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                if (controladorJogo.verificaLimites(labels.get(i).getY(), labels.get(i).getX(), i) != -1) {
                    l.add(labels.get(controladorJogo.verificaLimites(labels.get(i).getY(), labels.get(i).getX(), i)));
                }
                if (controladorJogo.verificaSprint(labels.get(i).getY(), labels.get(i).getX(), i) != -1 && !l.contains(labels.get(i))) {
                    lSprint.add(labels.get(controladorJogo.verificaSprint(labels.get(i).getY(), labels.get(i).getX(), i)));
                }
            }
            ((Canva) jPanel2).desenhaSprint(lSprint);
            ((Canva) jPanel2).desenhaLimites(l);
        }
    }

    @Override
    public void limpaMorto(int x, int y) {
        for (JLabel label : labels) {
            if (label.getX() == x && label.getY() == y) {
                label.setIcon(null);
            }
        }
    }

    @Override
    public void selecionaLimitesAtaque() {
        if (controladorJogo.getPersonagemSelecionado() != null) {
            List<JLabel> l = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                if (controladorJogo.verificaLimitesAtaque(labels.get(i).getY(), labels.get(i).getX(), i) != -1) {
                    l.add(labels.get(controladorJogo.verificaLimitesAtaque(labels.get(i).getY(), labels.get(i).getX(), i)));
                }
            }
            ((Canva) jPanel2).desenhaLimites(l);
        }
    }

    @Override
    public void limpaTela() {
        ((Canva) jPanel2).limpar();
    }

    @Override
    public void carregaCombo() {
        DefaultComboBoxModel comboModel = (DefaultComboBoxModel) comboPersonagens.getModel();
        comboModel.removeAllElements();
        for (Personagem p : controladorJogo.getPersonagens()) {
            comboModel.addElement(p);
        }
    }

    @Override
    public void exibePersonagens() {
        personagemPanel.removeAll();
        personagemPanel.repaint();
        Personagens personagens = new Personagens();
        for (Personagem p : Jogo.getInstance().getPersonagens()) {
            personagens.add(p);
        }
        JPanel panel = personagens.getDados();
        personagemPanel.add(panel);
    }

    @Override
    public void exibirTela() {
        setVisible(true);
        getContentPane().setBackground(Jogo.getInstance().getCorFundo());
        getContentPane().setForeground(Jogo.getInstance().getCorFonte());
        btnGirar.setBackground(Jogo.getInstance().getCorBotoes());
        btnGirar.setForeground(Jogo.getInstance().getCorFonte());
        btnMatar.setBackground(Jogo.getInstance().getCorBotoes());
        btnMover.setBackground(Jogo.getInstance().getCorBotoes());
        btnSobAtaque.setBackground(Jogo.getInstance().getCorBotoes());
        btnSobMover.setBackground(Jogo.getInstance().getCorBotoes());
        btnTurno.setBackground(Jogo.getInstance().getCorBotoes());
    }

    public void defineLabel() {
        int yAux = 0;
        int xAux = 0;
        int aux = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                labels.add(new JLabel());
                labels.get(aux).setBounds(xAux, yAux, 64, 64);
                ((Paint) jPanel1).add(labels.get(aux));
                xAux += 64;
                aux += 1;
            }
            xAux = 0;
            yAux += 64;
        }
    }

    @Override
    public void adicionaEmTela(Personagem p) {
        if (!controladorJogo.getPersonagens().isEmpty()) {
            ImageIcon img = new ImageIcon(new ImageIcon(p.getFotoPersonagem()).getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
            int posicao = p.getX() + (p.getY() * 8);
            labels.get(posicao).setIcon(img);
            controladorJogo.getPersonagens().remove(p);
        }
        controladorJogo.atualizacoes(controladorJogo.getPersonagens().size() > 0);
    }

    @Override
    public void atualizaLabel(Personagem p, int xAux, int yAux) {
        int posicao = xAux + yAux;
        for (JLabel label : labels) {
            if ((label.getX() == (p.getX() * 64)) && label.getY() == (p.getY() * 64)) {
                label.setIcon(null);
            }
        }
        for (JLabel label : labels) {
            if ((label.getX() == labels.get(posicao).getX()) && (label.getY() == labels.get(posicao).getY())) {
                ImageIcon img = new ImageIcon(new ImageIcon(p.getFotoPersonagem()).getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
                label.setIcon(img);
            }
        }
    }

    @Override
    public void atualizaImagem(Personagem p) {
        int xAux = p.getX();
        int yAux = p.getY() * 8;
        int posicao = xAux + yAux;
        for (JLabel label : labels) {
            if ((label.getX() == labels.get(posicao).getX()) && (label.getY() == labels.get(posicao).getY())) {
                ImageIcon img = new ImageIcon(new ImageIcon(p.getFotoPersonagem()).getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
                label.setIcon(img);
            }
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

        comboPersonagens = new javax.swing.JComboBox<>();
        jPanel1 = new Paint();
        jPanel2 = new Canva();
        btnMover = new javax.swing.JButton();
        btnMatar = new javax.swing.JButton();
        btnGirar = new javax.swing.JButton();
        btnSobMover = new javax.swing.JButton();
        btnSobAtaque = new javax.swing.JButton();
        btnTurno = new javax.swing.JButton();
        personagemPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelJ1 = new javax.swing.JLabel();
        labelJ2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnMover.setText("MOVER");

        btnMatar.setText("ATACAR");

        btnGirar.setText("GIRAR");

        btnSobMover.setText("Sobrecarregar mover");

        btnSobAtaque.setText("Sobrecarregar atacar");
        btnSobAtaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSobAtaqueActionPerformed(evt);
            }
        });

        btnTurno.setText("FINALIZAR TURNO");

        javax.swing.GroupLayout personagemPanelLayout = new javax.swing.GroupLayout(personagemPanel);
        personagemPanel.setLayout(personagemPanelLayout);
        personagemPanelLayout.setHorizontalGroup(
            personagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        personagemPanelLayout.setVerticalGroup(
            personagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );

        jLabel1.setText("PONTOS DO JOGADOR 1");

        jLabel2.setText("PONTOS DE JOGADOR 2");

        labelJ1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelJ1.setText("00");

        labelJ2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelJ2.setText("00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(personagemPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnMover, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnMatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnSobMover, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnGirar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnSobAtaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(comboPersonagens, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelJ1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(labelJ2)
                                        .addGap(5, 5, 5)))
                                .addGap(162, 162, 162))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(comboPersonagens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGirar)
                            .addComponent(btnMatar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSobMover)
                            .addComponent(btnSobAtaque))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTurno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelJ1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelJ2)
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)))
                .addComponent(personagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if (!controladorJogo.isCarregouTudo()) {
            controladorJogo.getPersonagens().addAll(controladorJogo.getPersonagem());
            carregaCombo();
        }
        exibePersonagens();
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnSobAtaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSobAtaqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSobAtaqueActionPerformed

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
            java.util.logging.Logger.getLogger(mapaJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mapaJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mapaJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mapaJogo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mapaJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGirar;
    private javax.swing.JButton btnMatar;
    private javax.swing.JButton btnMover;
    private javax.swing.JButton btnSobAtaque;
    private javax.swing.JButton btnSobMover;
    private javax.swing.JButton btnTurno;
    private javax.swing.JComboBox<String> comboPersonagens;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelJ1;
    private javax.swing.JLabel labelJ2;
    private javax.swing.JPanel personagemPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void habilitaBotoes() {
        btnMatar.setEnabled(controladorJogo.getHabilitaBotaoMatar());
        btnGirar.setEnabled(controladorJogo.getHabilitaBotaoRotacionar());
        btnMover.setEnabled(controladorJogo.getHabilitaBotaoMover());
        btnSobAtaque.setEnabled(controladorJogo.isHabilitaBotaoSobrecargaAtacar());
        btnSobMover.setEnabled(controladorJogo.isHabilitaBotaoSobrecargaMover());
        btnTurno.setEnabled(controladorJogo.getJogadas() == 2 || !controladorJogo.isMoveu());
    }

    @Override
    public void enviaMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    @Override
    public void atualizaPontos(int j1, int j2) {
        labelJ1.setText(""+j1);
        labelJ2.setText(""+j2);
    }

}
