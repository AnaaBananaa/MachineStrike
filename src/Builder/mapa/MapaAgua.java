/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder.mapa;

import java.awt.Image;

/**
 *
 * @author Aners
 */
public class MapaAgua extends BuilderMapa {

    @Override
    public void construirPontosAtaque(int ponto) {
        super.construirPontosAtaque(-1);
    }

    @Override
    public void imagemMapa(Image img) {
        super.imagemMapa(img); //To change body of generated methods, choose Tools | Templates.
    }
    
}
