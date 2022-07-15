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
public class AdapterDefault implements AdapterBackground{
    
    private LayoutDefault adaptado = new LayoutDefault();

    @Override
    public void salvarLayout(Color cor, Font font) {
        adaptado.salvaTema(cor, font);
    }
    
}
