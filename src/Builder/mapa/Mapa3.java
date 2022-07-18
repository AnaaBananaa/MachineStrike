/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder.mapa;

import java.util.ArrayList;
import java.util.List;
import model.mapa.MapaAgua;
import model.mapa.MapaGenerico;
import model.mapa.MapaGrama;
import model.mapa.MapaLava;

/**
 *
 * @author Aners
 */
public class Mapa3 extends BuilderMapa {

    private List<MapaGenerico> mapa = new ArrayList<>();

    @Override
    public List<MapaGenerico> getMapa() {
        return mapa;
    }

    @Override
    public void constroiMapa() {
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());

        mapa.add(new MapaAgua());
        mapa.add(new MapaAgua());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaAgua());
        mapa.add(new MapaGrama());
        mapa.add(new MapaLava());
        mapa.add(new MapaGrama());

        mapa.add(new MapaGrama());
        mapa.add(new MapaAgua());
        mapa.add(new MapaGrama());
        mapa.add(new MapaLava());
        mapa.add(new MapaGrama());
        mapa.add(new MapaAgua());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());

        mapa.add(new MapaAgua());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaAgua());
        mapa.add(new MapaGrama());
        mapa.add(new MapaLava());
        mapa.add(new MapaGrama());
        mapa.add(new MapaLava());

        mapa.add(new MapaLava());
        mapa.add(new MapaLava());
        mapa.add(new MapaLava());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaAgua());
        mapa.add(new MapaAgua());
        mapa.add(new MapaGrama());

        mapa.add(new MapaAgua());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaAgua());
        mapa.add(new MapaGrama());
        mapa.add(new MapaLava());

        mapa.add(new MapaGrama());
        mapa.add(new MapaLava());
        mapa.add(new MapaGrama());
        mapa.add(new MapaAgua());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaAgua());
        mapa.add(new MapaAgua());

        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
        mapa.add(new MapaGrama());
    }

}
