/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import controler.ControladorJogo;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Personagem;

/**
 *
 * @author Aners
 */
public class JogoAtacando extends JogoEstado {

    private ControladorJogo c;

    public JogoAtacando(ControladorJogo c) {
        this.c = c;
        if (c.getPersonagemSelecionado().getJogador() == 1) {
            c.notificaMensagem("O alcance de ataque do personagem é " + c.getPersonagemSelecionado().getAlcance() + " Escolha um personagem do jogador " + 2);
        } else {
            c.notificaMensagem("O alcance de ataque do personagem é " + c.getPersonagemSelecionado().getAlcance() + " Escolha um personagem do jogador " + 1);
        }
    }

    @Override
    public void proxEstado() {
        c.setEstado(new JogoDisponivel(c));
    }

    @Override
    public void acao(int x, int y) {
        try {
            Personagem pAtact = c.getPeca(x, y);
            c.atacaPersonagem(pAtact, x, y);
            proxEstado();
        } catch (Exception ex) {
            Logger.getLogger(JogoAtacando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
