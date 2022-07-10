/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder.mapa;

import java.util.ArrayList;
import java.util.List;
import model.mapa.MapaGenerico;
import model.mapa.MapaGrama;

/**
 *
 * @author Aners
 */
public class Mapa5 extends BuilderMapa {

    private List<MapaGenerico> mapa = new ArrayList<>();

    @Override
    public List<MapaGenerico> getMapa() {
        return mapa;
    }

    @Override
    public void constroiMapa() {
        for (int i = 0; i < 64; i++) {
            mapa.add(new MapaGrama());
        }
    }

}
