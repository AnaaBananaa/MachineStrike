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
            int xAux = x / 64;
            int yAux = y / 64;
            if (c.verificaLimites(yAux * 64, xAux * 64, 3) == 3) {
                c.getPersonagemSelecionado().setPermiteMover(false);
                c.movePersonagem(c.getPersonagemSelecionado(), xAux, yAux);
                c.setJogadas(c.getJogadas() + 1);
                c.setMoveu(false);
            } else {
                if (c.verificaSprint(yAux * 64, xAux * 64, 3) == 3) {
                    c.movePersonagem(c.getPersonagemSelecionado(), xAux, yAux);
                    c.setJogadas(2);
                    c.setMoveu(false);
                    c.setAtacou(false);
                    c.notificaMensagem("Você utilizou o sprint");
                } else {
                    c.notificaMensagem("O campo escolhido está fora dos limites do personagem");
                    c.setPersonagemSelecionado(null);
                }
                c.desabilitaBotoes();
            }
        } else {
            c.notificaMensagem("Já existe um personagem nesta posição");
            c.desabilitaBotoes();
            c.setPersonagemSelecionado(null);
        }
        c.limpaTela();
        proxEstado();
    }

}
