/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import Singleton.PersonagensJogo;
import java.awt.Font;

/**
 *
 * @author Aners
 */
public class LayoutDark {
    
    private String corFundo;
    private Font fonte;

    public String getCorFundo() {
        return corFundo;
    }

    public void setCorFundo(String corFundo) {
        this.corFundo = corFundo;
    }

    public Font getFonte() {
        return fonte;
    }

    public void setFonte(Font fonte) {
        this.fonte = fonte;
    }
    
    public void validaFonte(){
        if(fonte.getSize() > 16){
            fonte = new Font(fonte.getFontName(), fonte.getStyle(), 16);
        }
        PersonagensJogo.getInstance().setFonte(fonte);
        PersonagensJogo.getInstance().setCorFundo(corFundo);
    }
    
    
}
