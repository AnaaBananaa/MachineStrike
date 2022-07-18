/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Aners
 */
public class AdapterDark implements AdapterBackground {

    private LayoutDark adaptado = new LayoutDark();

    @Override
    public void salvarLayout(Color cor, Color corFonte, Color corBotao) {
        adaptado.setCorFundo(cor);
        adaptado.setCorBotao(corBotao);
        adaptado.setCorFonte(corFonte);
        adaptado.atribuiCor();
    }

}
