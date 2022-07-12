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
public class Personagem9 extends PersonagemPuxar{
    
    public Personagem9(int jogador) {
        super(jogador, 1, 2, 2, 4, 1, -1, 0, 2, 1, "Personagem 9", 100, 100);
    }
    
    @Override
    public String getCaminhoImagem() {
        return "src\\images\\p9\\p9";
    }
    
}
