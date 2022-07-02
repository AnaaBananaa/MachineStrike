/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder.mapa;

import java.awt.Image;
import model.mapa.MapaGenerico;
import visitor.VisitaMapa;

/**
 *
 * @author Aners
 */
public abstract class BuilderMapa {

    private MapaGenerico mapa;

    public void construirPontosAtaque(int ponto) {
        mapa.setDanoAtaque(0);
    }

    public void construirPontosDeVida(int ponto) {
        mapa.setDanoVida(0);
    }

    public void imagemMapa(Image img) {
        mapa.setImg(img);
    }

    public MapaGenerico getMapa() {
        return mapa;
    }

    public void reset() {
        this.mapa = new MapaGenerico();
    }

}
