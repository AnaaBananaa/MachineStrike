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
public class Personagem7 extends PersonagemAriete{
    
    public Personagem7(int jogador) {
        super(jogador, 1, 2, 2, 5, 1, -1, 0, 0, 2, "Plowhorn", 100, 100);
    }
    
    @Override
    public String getCaminhoImagem() {
        return "src\\images\\p7\\p7";
    }
    
}
