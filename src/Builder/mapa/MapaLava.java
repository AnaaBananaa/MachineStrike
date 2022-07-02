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
public class MapaLava extends BuilderMapa {

    @Override
    public void construirPontosDeVida(int ponto) {
        super.construirPontosDeVida(-2);
    }

    @Override
    public void construirPontosAtaque(int ponto) {
        super.construirPontosAtaque(2);
    }

    @Override
    public void imagemMapa(Image img) {
        super.imagemMapa(img);
    }

}
