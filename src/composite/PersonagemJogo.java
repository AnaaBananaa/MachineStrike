/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Aners
 */
public abstract class PersonagemJogo {
    
    public abstract JPanel getDados();

    public Image getFotoPersonagem(){
        return null;
    }

    public String nomeClasse(){
        return null;
    }

    public int getVida(){
    return 0;
    }

    public int getForcaAtaque(){return 0;}

    public int getCustoVP(){return 0;}

    public int getMovimentacao(){return 0;}

    public int getFrente(){return 0;}

    public int getCostas(){return 0;}

    public int getEsquerda(){return 0;}
    
    public int getX(){return 0;}
    
    public int getY(){return 0;}
    
}
