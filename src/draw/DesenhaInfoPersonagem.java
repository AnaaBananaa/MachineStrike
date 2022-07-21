/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;

import Singleton.Jogo;
import composite.PersonagemJogo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Aners
 */
public class DesenhaInfoPersonagem {

    public JPanel populaDadosPersonagem(PersonagemJogo p) {
        JLabel l = new JLabel();
        JLabel lClasse = new JLabel();
        JLabel lVida = new JLabel();
        JLabel lAtaque = new JLabel();
        JLabel lPV = new JLabel();
        JLabel lPontos = new JLabel();
        JLabel lMovimento = new JLabel();
        l.setIcon(new ImageIcon(new ImageIcon(p.getFotoPersonagem()).getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT)));
        l.setBounds(50, 30, 64, 64);
        l.setForeground(Jogo.getInstance().getCorFonte());
        lClasse.setForeground(Jogo.getInstance().getCorFonte());
        lVida.setForeground(Jogo.getInstance().getCorFonte());
        lAtaque.setForeground(Jogo.getInstance().getCorFonte());
        lPV.setForeground(Jogo.getInstance().getCorFonte());
        lMovimento.setForeground(Jogo.getInstance().getCorFonte());
        lPontos.setForeground(Jogo.getInstance().getCorFonte());
        lClasse.setText(p.nomeClasse());
        lClasse.setBounds(50, 10, 100, 20);
        lVida.setText("Vida: " + p.getVida());
        lVida.setBounds(20, 100, 100, 20);
        lAtaque.setText("Ataque: " + p.getForcaAtaque());
        lAtaque.setBounds(20, 120, 100, 20);
        lPV.setText("Pontos de Vitória: " + p.getCustoVP());
        lPV.setBounds(20, 140, 130, 20);
        lMovimento.setText("Movimentação: " + p.getMovimentacao());
        lMovimento.setBounds(20, 160, 130, 20);
        lPontos.setText("Frente: " + p.getFrente() + " Costas: " + p.getCostas() + " Lados: " + p.getEsquerda());
        lPontos.setBounds(20, 180, 200, 20);
        JPanel panel = new JPanel();
        panel.add(l);
        panel.add(lClasse);
        panel.add(lVida);
        panel.add(lPontos);
        panel.add(lMovimento);
        panel.add(lAtaque);
        panel.add(lPV);
        return panel;
    }

    public JPanel populaDadosPersonagens(PersonagemJogo p, int x, int y) {
        JLabel l = new JLabel();
        JLabel lVida = new JLabel();
        JLabel lAtaque = new JLabel();
        JLabel lPV = new JLabel();
        JLabel lPosicoes = new JLabel();
        l.setIcon(new ImageIcon(new ImageIcon(p.getFotoPersonagem()).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
        l.setBounds(10, 0, 40, 40);
        l.setForeground(Jogo.getInstance().getCorFonte());
        lPosicoes.setForeground(Jogo.getInstance().getCorFonte());
        lVida.setForeground(Jogo.getInstance().getCorFonte());
        lAtaque.setForeground(Jogo.getInstance().getCorFonte());
        lPV.setForeground(Jogo.getInstance().getCorFonte());
        lPosicoes.setText("(" + p.getX() + " ," + p.getY() + ")");
        lPosicoes.setBounds(0, 45, 64, 20);
        lVida.setText("HP: " + p.getVida() + " Atc: "+ p.getForcaAtaque());
        lVida.setBounds(0, 65, 64, 20);
        lAtaque.setText("PV: " + p.getCustoVP());
        lAtaque.setBounds(10, 85, 64, 15);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(x, y, 64, 100);
        panel.add(l);
        panel.add(lPosicoes);
        panel.add(lVida);
        panel.add(lAtaque);
        return panel;
    }
}
