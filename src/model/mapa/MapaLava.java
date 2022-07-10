/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.mapa;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Aners
 */
public class MapaLava extends MapaGenerico{

    public MapaLava() {
        super.setDanoAtaque(-2);
        super.setDanoVida(0);
        try {
            super.setImg(ImageIO.read(new File("src\\images\\lava.png")));
        } catch (IOException ex) {
            System.out.println("Erro ao ler imagem");
        }
    }
    
}
