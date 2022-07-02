/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import Observer.ObservadorInicio;
import java.util.ArrayList;
import java.util.List;
import view.escolhaPersonagem;

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
    
    public void exibir(){
        for(ObservadorInicio obs : obss){
            obs.exibirTela();
        }
    }
}
