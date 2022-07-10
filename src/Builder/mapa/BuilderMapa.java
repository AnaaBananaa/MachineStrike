/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder.mapa;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import model.mapa.MapaGenerico;

/**
 *
 * @author Aners
 */
public abstract class BuilderMapa {

    private List<MapaGenerico> mapa;
    
    public void constroiMapa(){
    }

    public void reset() {
        this.mapa = new ArrayList<>();
    }

    public List<MapaGenerico> getMapa() {
        return mapa;
    }

    public void addMapa(List<MapaGenerico> mapa) {
        this.mapa = mapa;
    }
    
}
