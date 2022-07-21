/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Singleton.Jogo;
import model.Personagem;

/**
 *
 * @author Aners
 */
public class AddPersonagemCommand implements Command {

	private Personagem dados;

	public AddPersonagemCommand(Personagem dados) {
		this.dados = dados;
	}

    @Override
    public void execute() {                
        Jogo.getInstance().addPersonagem(dados);
    }

    @Override
    public void undo() {
        Jogo.getInstance().getPersonagens().remove(dados);
    }

    @Override
    public void redo() {
        Jogo.getInstance().addPersonagem(dados);
    }
}