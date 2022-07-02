/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import Builder.mapa.BuilderMapa;
import java.util.ArrayList;
import java.util.List;
import model.Personagem;
import model.mapa.MapaGenerico;
import visitor.VisitaMapa;

/**
 *
 * @author Aners
 */
public class PersonagensJogo {

    private static PersonagensJogo instance;
    private List<Personagem> personagens = new ArrayList<>();
    private List<MapaGenerico> mapa = new ArrayList<>();
    private BuilderMapa mapaEscolhido;

    public synchronized static PersonagensJogo getInstance() {
        if (instance == null) {
            instance = new PersonagensJogo();
        }

        return instance;
    }

    public void addPersonagem(Personagem p) {
        personagens.add(p);
    }

    public void addMapa(List<MapaGenerico> hexa) {
        mapa.addAll(hexa);
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<Personagem> personagens) {
        this.personagens = personagens;
    }

    public void accept(VisitaMapa visitor) throws Exception {
        for (MapaGenerico item : mapa) {
            item.accept(visitor);
        }
    }

    public List<MapaGenerico> getMapa() {
        return mapa;
    }

    public void setMapa(List<MapaGenerico> mapa) {
        this.mapa = mapa;
    }

    public BuilderMapa getMapaEscolhido() {
        return mapaEscolhido;
    }

    public void setMapaEscolhido(BuilderMapa mapaEscolhido) {
        this.mapaEscolhido = mapaEscolhido;
    }

}
