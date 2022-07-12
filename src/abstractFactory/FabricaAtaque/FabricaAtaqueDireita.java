/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory.FabricaAtaque;

/**
 *
 * @author Aners
 */
public class FabricaAtaqueDireita extends FabricaAtaque {

    @Override
    public Ataque atacarPersonagem() {
        return new AtaqueDireita();
    }

    
}
