/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import model.Personagem;
import model.mapa.MapaGenerico;
import visitor.VisitorPersonagem;

/**
 *
 * @author Aners
 */
public class PersonagensJogo {

    private static PersonagensJogo instance;
    private List<Personagem> personagens = new ArrayList<>();
    private List<Personagem> mortos = new ArrayList<>();
    private List<MapaGenerico> mapa = new ArrayList<>();
    private Color corFundo;
    private Font fonte;

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

    public List<MapaGenerico> getMapa() {
        return mapa;
    }

    public void setMapa(List<MapaGenerico> mapa) {
        this.mapa = mapa;
    }

    public Color getCorFundo() {
        return corFundo;
    }

    public void setCorFundo(Color corFundo) {
        this.corFundo = corFundo;
    }

    public Font getFonte() {
        return fonte;
    }

    public void setFonte(Font fonte) {
        this.fonte = fonte;
    }

    public void accept(VisitorPersonagem visitor) {
        for (Personagem item : getMortos()) {
            item.accept(visitor);
        }
    }
    
     public void acceptTodos(VisitorPersonagem visitor) {
        for (Personagem item : getPersonagens()) {
            item.accept(visitor);
        }
    }
    public List<Personagem> getMortos() {
        return mortos;
    }

    public void setMortos(List<Personagem> mortos) {
        this.mortos = mortos;
    }
    
    public void addMortos(Personagem p) {
        this.mortos.add(p);
    }

}
