/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state.Personagem;

import model.Personagem;

/**
 *
 * @author Aners
 */
public abstract class PersonagemEstado {
    
    private Personagem personagem;

    public abstract void proxEstado();
    
    public abstract void rotacionar();

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
    
}
