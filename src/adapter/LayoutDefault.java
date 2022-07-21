/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import Singleton.Jogo;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Aners
 */
public class LayoutDefault {

    public void salvaTema(Color corPadrao, Color corFonte, Color corBotao) {
        Jogo.getInstance().setCorFonte(corFonte);
        Jogo.getInstance().setCorBotoes(corBotao);
        Jogo.getInstance().setCorFundo(corPadrao);
    }

}
