/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import abstractFactory.FabricaAtaque.FabricaAtaqueBaixo;
import abstractFactory.FabricaAtaque.FabricaAtaqueCima;
import abstractFactory.FabricaAtaque.FabricaAtaqueDireita;
import abstractFactory.FabricaAtaque.FabricaAtaqueEsquerda;
import controler.ControladorJogo;
import model.Personagem;

/**
 *
 * @author Aners
 */
public class JogoAtacando extends JogoEstado{
    
    private ControladorJogo c;

    public JogoAtacando(ControladorJogo c) {
        this.c = c;
        if (c.getPersonagemSelecionado().getJogador() == 1) {
                c.notificaMensagem("Escolha um personagem do jogador " + 2);
            } else {
                c.notificaMensagem("Escolha um personagem do jogador " + 1);
            }
    }

    @Override
    public void proxEstado() {
        c.setEstado(new JogoDisponivel(c));
    }

    @Override
    public void acao(int x, int y) {
        c.notificaMensagem("O alcance de ataque do personagem é " + c.getPersonagemSelecionado().getAlcance());
        Personagem pSelect = c.getPersonagemSelecionado();
        Personagem pAtact = c.getPeca(x, y);
        int posicao = x/64 + (y/64) * 8;
        int danoAtaqueMapa = c.getMapa().get(posicao).getDanoAtaque();
        int danoVidaMapa = c.getMapa().get(posicao).getDanoAtaque();
        if (pAtact != null) {
            if (pSelect.getJogador() == pAtact.getJogador()) {
                c.notificaMensagem("O personagem escolhido é do jogador " + pSelect.getJogador());
            } else {
                if ((pSelect.getX() < pAtact.getX()) && (pSelect.getAlcance() <= pAtact.getX() - pSelect.getX())) {
                    c.atacaPersonagem(new FabricaAtaqueEsquerda(), pAtact);
                    //Verifica se o ataque está vindo da direita
                } else if ((pSelect.getX() > pAtact.getX()) && (pSelect.getAlcance() <= pSelect.getX() - pAtact.getX())) {
                    c.atacaPersonagem(new FabricaAtaqueDireita(), pAtact);

                    //Verifica se o ataque está vindo por cima
                } else if ((pSelect.getY() < pAtact.getY()) && (pSelect.getAlcance() <= pAtact.getY() - pSelect.getY())) {
                    c.atacaPersonagem(new FabricaAtaqueCima(), pAtact);

                    //Verifica se o ataque está vindo por Baixo
                } else if ((pSelect.getY() < pAtact.getY()) && (pSelect.getAlcance() <= pSelect.getY() - pAtact.getY())) {
                    c.atacaPersonagem(new FabricaAtaqueBaixo(), pAtact);

                } else {
                    c.notificaMensagem("O jogador selecionado não se encontra no alcance de ataque");
                    pAtact = null;
                }
            }
        } else {
            c.notificaMensagem("Jogador a ser atacado não foi selecionado");
        }
        proxEstado();
    }
    
}
