/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory.FabricaAtaque;

import java.util.List;
import model.Personagem;

/**
 *
 * @author Aners
 */
public interface Ataque {
    void ataque(Personagem p, int ataque, Personagem pSelecionado);
}
