/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.mapa;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Aners
 */
public class MapaAgua extends MapaGenerico {

    public MapaAgua() {
        super.setDanoAtaque(-1);
        super.setDanoVida(0);
        try {
            super.setImg(ImageIO.read(new File("src\\images\\agua.png")));
        } catch (IOException ex) {
            System.out.println("Erro ao ler imagem");
        }
    }

}
