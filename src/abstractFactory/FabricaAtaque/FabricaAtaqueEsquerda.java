/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory.FabricaAtaque;

import model.Personagem;

/**
 *
 * @author Aners
 */
public class FabricaAtaqueEsquerda extends FabricaAtaque{

    @Override
    public Ataque atacarPersonagem() {
        return new AtaqueEsquerda();
    }
    
}
