/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder.mapa;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Aners
 */
public class MapaGrama extends BuilderMapa{

    @Override
    public void imagemMapa(Image img) {
        try {
            img = ImageIO.read(new File("src\\images\\grama.png"));
        } catch (IOException ex) {
            Logger.getLogger(MapaGrama.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.imagemMapa(img);
        
    }
    
    
}
