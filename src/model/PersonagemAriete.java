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
public class PersonagemAriete extends Personagem{

    public PersonagemAriete(int jogador, int alcance, int movimentacao, int forcaAtaque, int vida, int frente, int costas, int esquerda, int direita, int custoVP, String nome, int x, int y) {
        super(jogador, alcance, movimentacao, forcaAtaque, vida, frente, costas, esquerda, direita, custoVP, nome, x, y);
    }
    
    @Override
    public Personagem ataqueDaClasse(Personagem pAtact, int posicao) {
        boolean podeMoverX = pAtact.getX() < 7 && pAtact.getX() > 0;
        boolean podeMoverY = pAtact.getY() < 7 && pAtact.getY() > 0;

        //Aríete
        switch (posicao) {
            case 1:
                if (podeMoverX) {
                    pAtact.setX(pAtact.getX() + 1);
                }
                
                //Verifica se o ataque está vindo da direita
                break;
            case 2:
                if (podeMoverX) {
                    pAtact.setX(pAtact.getX() - 1);
                }
                
                //Verifica se o ataque está vindo por cima
                break;
            case 3:
                if (podeMoverY) {
                    pAtact.setY(pAtact.getY() + 1);
                }
                
                //Verifica se o ataque está vindo por Baixo
                break;
            case 4:
                if (podeMoverY) {
                    pAtact.setY(pAtact.getY() - 1);
                }   break;
            default:
                pAtact = null;
                break;
        }
        return pAtact;
    }

    @Override
    public String getCaminhoImagem() {
        return "";
    }

    @Override
    public String nomeClasse() {
        return "Aríete";
    }
    
}
