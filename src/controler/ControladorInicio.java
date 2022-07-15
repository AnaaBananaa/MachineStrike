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
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;

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
        Font font = null;
        if(b){
            AdapterBackground ab = new AdapterDark();
            font = new Font("Verdana", Font.BOLD, 20);
            ab.salvarLayout(new Color(104, 104, 104), font);
        }else{
            AdapterBackground ab = new AdapterDefault();
            font = new Font("Verdana", Font.BOLD, 10);
            ab.salvarLayout(new Color(243, 243, 243), font);
        }
        UIManager.put("Button.font", font);
    }
    
    public void exibir(){
        for(ObservadorInicio obs : obss){
            obs.exibirTela();
        }
    }
}
