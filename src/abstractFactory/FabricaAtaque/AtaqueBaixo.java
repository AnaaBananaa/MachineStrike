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
public class AtaqueBaixo implements Ataque {

    @Override
    public int ataque(Personagem p, int ataque) {
        if (p.getJogador() == 1) {
            return p.getVida() - (ataque - p.getCostas());
        } else {
            return p.getVida() - (ataque - p.getFrente());
        }
    }

}
