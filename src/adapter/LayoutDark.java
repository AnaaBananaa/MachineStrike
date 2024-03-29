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
public class LayoutDark {

    private Color corFundo;
    private Color corBotao;
    private Color corFonte;

    public Color getCorFundo() {
        return corFundo;
    }

    public void setCorFundo(Color corFundo) {
        this.corFundo = corFundo;
    }

    public Color getCorBotao() {
        return corBotao;
    }

    public void setCorBotao(Color corBotao) {
        this.corBotao = corBotao;
    }

    public Color getCorFonte() {
        return corFonte;
    }

    public void setCorFonte(Color corFonte) {
        this.corFonte = corFonte;
    }

    public void atribuiCor() {
        if (corFundo.getBlue() > 150) {
            Jogo.getInstance().setCorFonte(Color.BLACK);
        }
        Jogo.getInstance().setCorFundo(corFundo);
        Jogo.getInstance().setCorBotoes(corBotao);
        Jogo.getInstance().setCorFonte(corFonte);
    }

}
