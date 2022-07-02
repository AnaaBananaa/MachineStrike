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
public class Personagem2 extends Personagem{

    public Personagem2() {
        super(1, 2, 2, 4, 1, -1, 0, 2, 1, "Personagem 2", 100, 100);
    }
    
    @Override
    public String getCaminhoImagem() {
        return "src\\images\\p2\\p2";
    }
    
    
    
}
