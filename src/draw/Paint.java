/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;

import Singleton.Jogo;
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
        List<MapaGenerico> mapaJogo = Jogo.getInstance().getMapa();
        int aux = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                g.drawImage(mapaJogo.get(aux).getImg(),x * 64, y * 64, 64, 64, this);
                aux += 1;
            }
        }
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
}
