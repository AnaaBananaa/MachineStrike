/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;

import Builder.mapa.BuilderMapa;
import Builder.mapa.GeradorMapa;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Aners
 */
public class Preview extends JPanel {
    
    private BuilderMapa b = null;
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        GeradorMapa gm = new GeradorMapa(b);
        gm.construir();
        int aux = 0;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                g.drawImage(b.getMapa().get(aux).getImg(), x * 64, y * 64, 64, 64, this);
                aux += 1;
            }
        }
    }

    public void desenhaPreviewMapa(BuilderMapa mapa) {
        b = mapa;
    }

}
