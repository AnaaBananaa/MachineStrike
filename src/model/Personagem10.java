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
public class Personagem10 extends PersonagemPuxar{
    
    public Personagem10(int jogador) {
        super(jogador, 3, 2, 4, 10, 0, -1, 1, 1, 6, "Tico liro", 100, 100);
    }
    
    @Override
    public String getCaminhoImagem() {
        return "src\\images\\p10\\p10";
    }
    
}
