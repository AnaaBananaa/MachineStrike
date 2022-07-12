/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.mapa;

import java.awt.Image;

/**
 *
 * @author Aners
 */
public class MapaGenerico {

    private int danoAtaque;
    private int danoVida;
    private Image img;

    public MapaGenerico() {
    }

    public int getDanoAtaque() {
        return danoAtaque;
    }

    public void setDanoAtaque(int danoAtaque) {
        this.danoAtaque = danoAtaque;
    }

    public int getDanoVida() {
        return danoVida;
    }

    public void setDanoVida(int danoVida) {
        this.danoVida = danoVida;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

}
