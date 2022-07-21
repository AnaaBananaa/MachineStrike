/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import model.Personagem;

/**
 *
 * @author Aners
 */
public class CalculaGanhador implements VisitorPersonagem {

    private int jogador1;
    private int jogador2;

    public CalculaGanhador() {
        this.jogador1 = 0;
        this.jogador2 = 0;
    }
    
    @Override
    public void visit(Personagem p) {
        if (p.getJogador() == 1) {
            jogador1 += p.getCustoVP();
        } else if (p.getJogador() == 2) {
            jogador2 += p.getCustoVP();
        }
    }

    public int ganhador() {
        if (jogador2 >= 7) {
            return 1;
        } else if (jogador1 >= 7) {
            return 2;
        } else {
            return 0;
        }
    }
    
    public int pontosGanhador1(){
        return jogador1;
    }
    
    public int pontosGanhador2(){
        return jogador2;
    }

}
