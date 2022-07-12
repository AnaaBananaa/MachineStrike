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
public class JogoSobrecargaMover extends JogoEstado {

    private ControladorJogo c;

    public JogoSobrecargaMover(ControladorJogo c) {
        this.c = c;
        if (c.isTurnoJogador() == c.getPersonagemSelecionado().getJogador()) {
            this.c.notificaMensagem("Escolha uma posição para mover o personagem selecionado");
        } else {
            c.notificaMensagem("O personagem selecionado não faz parte do turno");
            c.desabilitaBotoes();
            c.setPersonagemSelecionado(null);
            proxEstado();
        }
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
                this.c.notificaMensagem("Seu personagem perdeu 2 pontos de vida por conta da sobrecarga");
            } else {
                c.notificaMensagem("O campo escolhido está fora dos limites do personagem");
                c.desabilitaBotoes();
                c.setPersonagemSelecionado(null);
                c.limpaTela();
            }
        } else {
            c.notificaMensagem("Já existe um personagem nesta posição");
            c.desabilitaBotoes();
            c.setPersonagemSelecionado(null);
        }
        proxEstado();
    }

}
