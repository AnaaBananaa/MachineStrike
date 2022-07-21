/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import controler.ControladorJogo;

/**
 *
 * @author Aners
 */
public class JogoRotacionando extends JogoEstado {

    private ControladorJogo c;

    public JogoRotacionando(ControladorJogo c) {
        this.c = c;
    }

    @Override
    public void proxEstado() {
        c.setEstado(new JogoDisponivel(c));
    }

    @Override
    public void acao(int x, int y) {
        c.getPersonagemSelecionado().rotacionar();
        c.atualizaImagem(c.getPersonagemSelecionado());
        c.desabilitaBotoes();
        
        proxEstado();
    }
}
