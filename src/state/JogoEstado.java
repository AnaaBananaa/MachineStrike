/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

/**
 *
 * @author Aners
 */
public abstract class JogoEstado {
    
    public abstract void proxEstado();
    
    public abstract void acao( int x, int y);
    
    public void escolha(int e){
                //vai fazer nada
    }
    
}
