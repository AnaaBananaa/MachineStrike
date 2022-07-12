/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import java.awt.Font;

/**
 *
 * @author Aners
 */
public class AdapterDark implements AdapterBackground{

    private LayoutDark adaptado;
    
    @Override
    public void salvarLayout(String cor, Font font) {
        adaptado.setCorFundo(cor);
        adaptado.setFonte(font);
        adaptado.validaFonte();
    }
    
}
