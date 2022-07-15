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

    private int custoPV;
    
    @Override
    public void visit(Personagem p) {
        custoPV += p.getCustoVP();
    }

    public boolean menosPersonagens() {
        if(custoPV / 2 > 7){
            return false;
        }else{
            return true;
        }
    }
    
    
}
