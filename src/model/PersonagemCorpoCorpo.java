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
public class PersonagemCorpoCorpo extends Personagem{

    public PersonagemCorpoCorpo(int jogador, int alcance, int movimentacao, int forcaAtaque, int vida, int frente, int costas, int esquerda, int direita, int custoVP, String nome, int x, int y) {
        super(jogador, alcance, movimentacao, forcaAtaque, vida, frente, costas, esquerda, direita, custoVP, nome, x, y);
    }

    @Override
    public Personagem ataqueDaClasse(Personagem pAtact, int posicao) {
        return pAtact;
    }

    @Override
    public String getCaminhoImagem() {
        return "";
    }
    
}
