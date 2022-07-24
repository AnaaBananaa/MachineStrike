/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory.FabricaAtaque;

import java.util.ArrayList;
import java.util.List;
import model.Personagem;

/**
 *
 * @author Aners
 */
public class AtaqueCima implements Ataque {

    @Override
    public void ataque(Personagem p, int ataque, Personagem pSelecionado) {
        if (ataque - p.getCostas() <= 0) {
            pSelecionado.setVida(pSelecionado.getVida() - 1);
            p.setVida(p.getVida() - 1);
        } else {
            p.setVida(p.getVida() - (ataque - p.getCostas()));
        }
    }

}
