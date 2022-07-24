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
public class Personagem8 extends PersonagemPuxar{
    
    public Personagem8(int jogador) {
        super(jogador, 3, 2, 3, 7, 1, -1, 0, 0, 3, "Snapmaw", 100, 100);
    }
    
    @Override
    public String getCaminhoImagem() {
        return "src\\images\\p8\\p8";
    }
    
}
