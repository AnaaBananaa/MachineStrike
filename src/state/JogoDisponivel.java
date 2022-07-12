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
public class JogoDisponivel extends JogoEstado {

    private ControladorJogo c;
    private int escolha;
    private int jogador;

    public JogoDisponivel(ControladorJogo c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Disponivel";
    }

    @Override
    public void proxEstado() {
        if (c.isTurnoJogador() == c.getPersonagemSelecionado().getJogador()) {
            switch (escolha) {
                case 1 ->
                    c.setEstado(new JogoMovendo(c));
                case 2 ->
                    c.setEstado(new JogoAtacando(c));
                case 3 ->
                    c.setEstado(new JogoRotacionando(c));
                case 4 ->
                    c.setEstado(new JogoSobrecargaAtacar(c));
                case 5 ->
                    c.setEstado(new JogoSobrecargaMover(c));
                default -> {
                }
            }
        } else {
            c.notificaMensagem("O personagem selecionado não faz parte do turno");
            c.desabilitaBotoes();
            c.setPersonagemSelecionado(null);
        }

    }

    @Override
    public void acao(int x, int y) {
    }

    @Override
    public void escolha(int e) {
        this.escolha = e;
        proxEstado();
    }

}
