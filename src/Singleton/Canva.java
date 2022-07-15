/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import Builder.mapa.BuilderMapa;
import Builder.mapa.GeradorMapa;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Aners
 */
public class Canva extends JPanel {

    public Canva() {
        this.setBackground(new Color(0, 0, 0, 0));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public void desenha() {
        Graphics g = this.getGraphics();
        g.drawOval(0, 0, 100, 100);

    }

    public void desenhaLinhas(int i) {
        Graphics g = this.getGraphics();
        int aux = 0;
        int x = 0;
        int y = 384;
        if (i == 1) {
            for (int j = 0; j <= 16; j++) {
                if (j == 8) {
                    x = 0;
                    y = 448;
                } else {
                    g.drawRect(x, y, 64, 64);
                    x += 64;
                }
            }
        } else if (i == 2) {
            y = 0;
            for (int j = 0; j <= 16; j++) {
                if (j == 8) {
                    x = 0;
                    y = 64;
                } else {
                    g.drawRect(x, y, 64, 64);
                    x += 64;
                }
            }
        }
    }

    public void desenhaLimites(List<JLabel> label) {
        Graphics g = this.getGraphics();
        g.setColor(Color.WHITE);
        for (JLabel l : label) {
            g.drawOval(l.getX() + 5, l.getY() + 5, 54, 54);
        }
    }

    public void desenhaSprint(List<JLabel> label) {
        Graphics g = this.getGraphics();
        Color white = new Color(255, 255, 255, 100);
        g.setColor(white);
        for (JLabel l : label) {
            g.fillOval(l.getX() + 10, l.getY() + 10, 44, 44);
        }
    }

    public void limpar() {
        repaint();
    }

}
