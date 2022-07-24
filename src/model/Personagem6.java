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
public class Personagem6 extends PersonagemAriete{
    
    public Personagem6(int jogador) {
        super(jogador, 1, 2, 1, 4, 1, 0, -1, -1, 1, "Grazer", 100, 100);
    }
    
    @Override
    public String getCaminhoImagem() {
        return "src\\images\\p6\\p6";
    }
    
}
