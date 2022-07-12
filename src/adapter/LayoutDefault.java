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
public class LayoutDefault {
    
    public void salvaTema(String corPadrao, Font fonte){
        PersonagensJogo.getInstance().setFonte(fonte);
        PersonagensJogo.getInstance().setCorFundo(corPadrao);
    }
    
}
