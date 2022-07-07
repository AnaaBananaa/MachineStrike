/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import controler.ControladorJogo;
import model.Personagem;

/**
 *
 * @author Aners
 */
public class JogoMovendo extends JogoEstado {

    private ControladorJogo c;

    JogoMovendo(ControladorJogo c) {
        this.c = c;
        this.c.notificaMensagem("Escolha uma posição para mover o personagem selecionado");
    }

    @Override
    public void proxEstado() {
        c.setEstado(new JogoDisponivel(c));
    }

    @Override
    public void acao(int x, int y) {
        if (c.getPeca(x, y) == null) {
            c.getPersonagemSelecionado().setPermiteMover(false);
            c.movePersonagem(x, y);
        } else {
            c.notificaMensagem("Já existe um personagem nesta posição");
            c.desabilitaBotoes();
            c.setPersonagemSelecionado(null);
        }
        c.setHabilitaBotaoSobrecargaMover(true);
        proxEstado();
    }

}
