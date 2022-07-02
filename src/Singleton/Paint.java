/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import Builder.mapa.BuilderMapa;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;
import model.mapa.MapaGenerico;

/**
 *
 * @author Aners
 */
public class Paint extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        List<MapaGenerico> mapaJogo = PersonagensJogo.getInstance().getMapa();
        int aux = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                g.drawImage(mapaJogo.get(aux).getImg(),x * 64, y * 64, 64, 64, this);
                aux = +1;
            }
            aux = +1;

        }
    }

    public void desenharMapa(int escolha) {
        Graphics g = this.getGraphics();

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

    public void desenharMapaEscolhido(List<String> mapa) {
        Graphics g = this.getGraphics();

        int y = 0;
        int x = 0;
        int aux = 0;
        for (String map : mapa) {
            aux += 1;
            if (aux % 8 == 0) {
                x += 64;
            } else {
                y += 64;
                x = 0;
            }
            Color cor = Color.decode(map);
            g.setColor(cor);
            g.fill3DRect(x, y, 64, 64, true);

        }
    }

}
