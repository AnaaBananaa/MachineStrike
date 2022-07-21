/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Observer.ObservadorEscolhaPersonagem;
import Singleton.Jogo;
import controler.ControladorEscolhaPersonagem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import model.Personagem;
import model.Personagem1;
import model.Personagem10;
import model.Personagem2;
import model.Personagem3;
import model.Personagem4;
import model.Personagem5;
import model.Personagem6;
import model.Personagem7;
import model.Personagem8;
import model.Personagem9;

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
    private InfoPersonagem inf = new InfoPersonagem();

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
        btnInfo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Personagem p = new Personagem1(0);
                    p.setFotoPersonagem(ImageIO.read(new File(p.getCaminhoImagem() + "Frente.png")));
                    inf.exibirTela(p);
                } catch (IOException ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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
        btnInfo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Personagem p = new Personagem2(0);
                    p.setFotoPersonagem(ImageIO.read(new File(p.getCaminhoImagem() + "Frente.png")));
                    inf.exibirTela(p);
                } catch (IOException ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnPersonagem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uc.salvarPeronsagem(new Personagem3(uc.getJogador()));
                } catch (Exception ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnInfo3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Personagem p = new Personagem3(0);
                    p.setFotoPersonagem(ImageIO.read(new File(p.getCaminhoImagem() + "Frente.png")));
                    inf.exibirTela(p);
                } catch (IOException ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnPersonagem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uc.salvarPeronsagem(new Personagem4(uc.getJogador()));
                } catch (Exception ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnInfo4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Personagem p = new Personagem4(0);
                    p.setFotoPersonagem(ImageIO.read(new File(p.getCaminhoImagem() + "Frente.png")));
                    inf.exibirTela(p);
                } catch (IOException ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnPersonagem5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uc.salvarPeronsagem(new Personagem5(uc.getJogador()));
                } catch (Exception ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnInfo5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Personagem p = new Personagem5(0);
                    p.setFotoPersonagem(ImageIO.read(new File(p.getCaminhoImagem() + "Frente.png")));
                    inf.exibirTela(p);
                } catch (IOException ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnPersonagem6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uc.salvarPeronsagem(new Personagem6(uc.getJogador()));
                } catch (Exception ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnInfo6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Personagem p = new Personagem6(0);
                    p.setFotoPersonagem(ImageIO.read(new File(p.getCaminhoImagem() + "Frente.png")));
                    inf.exibirTela(p);
                } catch (IOException ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnPersonagem7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uc.salvarPeronsagem(new Personagem7(uc.getJogador()));
                } catch (Exception ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnInfo7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Personagem p = new Personagem7(0);
                    p.setFotoPersonagem(ImageIO.read(new File(p.getCaminhoImagem() + "Frente.png")));
                    inf.exibirTela(p);
                } catch (IOException ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnPersonagem8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uc.salvarPeronsagem(new Personagem8(uc.getJogador()));
                } catch (Exception ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnInfo8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Personagem p = new Personagem8(0);
                    p.setFotoPersonagem(ImageIO.read(new File(p.getCaminhoImagem() + "Frente.png")));
                    inf.exibirTela(p);
                } catch (IOException ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnPersonagem9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uc.salvarPeronsagem(new Personagem9(uc.getJogador()));
                } catch (Exception ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnInfo9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Personagem p = new Personagem9(0);
                    p.setFotoPersonagem(ImageIO.read(new File(p.getCaminhoImagem() + "Frente.png")));
                    inf.exibirTela(p);
                } catch (IOException ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnPersonagem10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uc.salvarPeronsagem(new Personagem10(uc.getJogador()));
                } catch (Exception ex) {
                    Logger.getLogger(escolhaPersonagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnInfo10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Personagem p = new Personagem10(0);
                    p.setFotoPersonagem(ImageIO.read(new File(p.getCaminhoImagem() + "Frente.png")));
                    inf.exibirTela(p);
                } catch (IOException ex) {
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
        getContentPane().setBackground(Jogo.getInstance().getCorFundo());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaPersonagens = new javax.swing.JTextArea();
        btnContinuar = new javax.swing.JButton();
        btnMudaJogador = new javax.swing.JButton();
        btnDesfaz = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        personagem1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnPersonagem2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnPersonagem3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnPersonagem5 = new javax.swing.JButton();
        btnPersonagem4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnPersonagem7 = new javax.swing.JButton();
        btnPersonagem6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnPersonagem10 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnPersonagem9 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnPersonagem8 = new javax.swing.JButton();
        btnInfo1 = new javax.swing.JButton();
        btnInfo2 = new javax.swing.JButton();
        btnInfo3 = new javax.swing.JButton();
        btnInfo4 = new javax.swing.JButton();
        btnInfo5 = new javax.swing.JButton();
        btnInfo6 = new javax.swing.JButton();
        btnInfo10 = new javax.swing.JButton();
        btnInfo9 = new javax.swing.JButton();
        btnInfo8 = new javax.swing.JButton();
        btnInfo7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtAreaPersonagens.setColumns(20);
        txtAreaPersonagens.setRows(5);
        jScrollPane1.setViewportView(txtAreaPersonagens);

        btnContinuar.setText("CONTINUAR >");

        btnMudaJogador.setText("Mudar Jogador");

        btnDesfaz.setText("Desfazer Escolha");

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        personagem1.setText("ESCOLHER");
        personagem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personagem1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p1/p1Frente.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        btnPersonagem2.setText("ESCOLHER");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p2/p2Frente.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        btnPersonagem3.setText("ESCOLHER");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p3/p3Frente.png"))); // NOI18N
        jLabel3.setText("jLabel2");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p4/p4Frente.png"))); // NOI18N
        jLabel4.setText("jLabel2");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p5/p5Frente.png"))); // NOI18N
        jLabel5.setText("jLabel2");

        btnPersonagem5.setText("ESCOLHER");

        btnPersonagem4.setText("ESCOLHER");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p7/p7Frente.png"))); // NOI18N
        jLabel6.setText("jLabel2");

        btnPersonagem7.setText("ESCOLHER");

        btnPersonagem6.setText("ESCOLHER");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p6/p6Frente.png"))); // NOI18N
        jLabel7.setText("jLabel2");

        btnPersonagem10.setText("ESCOLHER");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p10/p10Frente.png"))); // NOI18N
        jLabel8.setText("jLabel2");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p9/p9Frente.png"))); // NOI18N
        jLabel9.setText("jLabel2");

        btnPersonagem9.setText("ESCOLHER");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/p8/p8Frente.png"))); // NOI18N
        jLabel10.setText("jLabel2");

        btnPersonagem8.setText("ESCOLHER");

        btnInfo1.setText("INFO");
        btnInfo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfo1ActionPerformed(evt);
            }
        });

        btnInfo2.setText("INFO");

        btnInfo3.setText("INFO");

        btnInfo4.setText("INFO");

        btnInfo5.setText("INFO");

        btnInfo6.setText("INFO");

        btnInfo10.setText("INFO");

        btnInfo9.setText("INFO");

        btnInfo8.setText("INFO");

        btnInfo7.setText("INFO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(personagem1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPersonagem2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPersonagem3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPersonagem4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPersonagem5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPersonagem6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPersonagem7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnPersonagem8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnPersonagem9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPersonagem10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInfo2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInfo3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInfo4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInfo5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInfo6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInfo7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInfo8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInfo9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInfo10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPersonagem6)
                            .addComponent(btnPersonagem7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPersonagem4)
                            .addComponent(btnPersonagem5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(personagem1)
                            .addComponent(btnPersonagem2)
                            .addComponent(btnPersonagem3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPersonagem9)
                            .addComponent(btnPersonagem10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPersonagem8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInfo9)
                        .addComponent(btnInfo10))
                    .addComponent(btnInfo8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInfo6)
                        .addComponent(btnInfo7))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInfo4)
                        .addComponent(btnInfo5))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInfo1)
                        .addComponent(btnInfo2)
                        .addComponent(btnInfo3)))
                .addGap(36, 36, 36))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDesfaz, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 581, Short.MAX_VALUE)
                        .addComponent(btnMudaJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinuar)
                    .addComponent(btnMudaJogador)
                    .addComponent(btnDesfaz))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void personagem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personagem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_personagem1ActionPerformed

    private void btnInfo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInfo1ActionPerformed

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
    private javax.swing.JButton btnInfo1;
    private javax.swing.JButton btnInfo10;
    private javax.swing.JButton btnInfo2;
    private javax.swing.JButton btnInfo3;
    private javax.swing.JButton btnInfo4;
    private javax.swing.JButton btnInfo5;
    private javax.swing.JButton btnInfo6;
    private javax.swing.JButton btnInfo7;
    private javax.swing.JButton btnInfo8;
    private javax.swing.JButton btnInfo9;
    private javax.swing.JButton btnMudaJogador;
    private javax.swing.JButton btnPersonagem10;
    private javax.swing.JButton btnPersonagem2;
    private javax.swing.JButton btnPersonagem3;
    private javax.swing.JButton btnPersonagem4;
    private javax.swing.JButton btnPersonagem5;
    private javax.swing.JButton btnPersonagem6;
    private javax.swing.JButton btnPersonagem7;
    private javax.swing.JButton btnPersonagem8;
    private javax.swing.JButton btnPersonagem9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton personagem1;
    private javax.swing.JTextArea txtAreaPersonagens;
    // End of variables declaration//GEN-END:variables

    @Override
    public void exibirProxTela() {
        ep.exibirTela();
    }

}
