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
public class CalculaPersonagens implements VisitorPersonagem {

    private int custoPV, custoPV2;

    @Override
    public void visit(Personagem p) {
        if (p.getJogador() == 1) {
            custoPV += p.getCustoVP();
        }else{
            custoPV2 += p.getCustoVP();
        }
    }

    public boolean menosPersonagens() {
        if (custoPV < 7 && custoPV2 < 7) {
            return true;
        } else {
            return false;
        }
    }

}
