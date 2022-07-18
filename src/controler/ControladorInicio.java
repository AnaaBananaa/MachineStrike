/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import Observer.ObservadorInicio;
import adapter.AdapterBackground;
import adapter.AdapterDark;
import adapter.AdapterDefault;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aners
 */
public class ControladorInicio {
    
    private List<ObservadorInicio> obss = new ArrayList<>();
    private ControladorEscolhaPersonagem uc = new ControladorEscolhaPersonagem();
    
    public void anexar(ObservadorInicio obs){
        this.obss.add(obs);
    }
    
    public void darkMode(boolean b){
        if(b){
            AdapterBackground ab = new AdapterDark();
            ab.salvarLayout(new Color(104, 104, 104), Color.WHITE, new Color(51, 51, 51));
        }else{
            AdapterBackground ab = new AdapterDefault();
            ab.salvarLayout(new Color(245, 245, 237), Color.BLACK, new Color(207, 207, 200));
        }
    }
    
    public void exibir(){
        for(ObservadorInicio obs : obss){
            obs.exibirTela();
        }
    }
}
