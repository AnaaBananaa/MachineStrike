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
public class CalculaQtdPersonagem implements VisitorPersonagem {

    private int aux = 0;
    private int aux2 = 0;
    
    @Override
    public void visit(Personagem p) {
        if (p.getJogador() == 1) {
            aux += 1;
        }else{
            aux2 += 1;
        }
    }

    public int getIogadores1() {
        return aux;
    }

    public int getJogadores2() {
        return aux2;
    }
    
}
