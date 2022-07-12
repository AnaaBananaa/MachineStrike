/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Aners
 */
public class Personagem2 extends PersonagemCorpoCorpo{

    public Personagem2(int jogador) {
        super(jogador, 1, 4, 1, 3, 1, -1, 0, 0, 1, "Lea", 100, 100);
    }
    
    @Override
    public String getCaminhoImagem() {
        return "src\\images\\p2\\p2";
    }
    
    
    
}
