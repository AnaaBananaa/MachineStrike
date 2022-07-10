/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder.mapa;

/**
 *
 * @author Aners
 */
public class GeradorMapa {

    private BuilderMapa mapa;

    public GeradorMapa(BuilderMapa mapa) {
        this.mapa = mapa;
    }

    public void construir() {
        mapa.constroiMapa();
        mapa.reset();
    }

}
