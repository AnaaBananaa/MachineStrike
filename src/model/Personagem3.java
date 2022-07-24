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
public class Personagem3 extends PersonagemCorpoCorpo{
    
    public Personagem3(int jogador) {
        super(jogador, 2, 2, 4, 10, 1, 0, -1, -1, 7, "Frostclaw", 100, 100);
    }
    
    @Override
    public String getCaminhoImagem() {
        return "src\\images\\p3\\p3";
    }
}
