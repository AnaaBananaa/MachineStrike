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
public class JogoSobrecargaAtacar extends JogoEstado {

    private ControladorJogo c;

    JogoSobrecargaAtacar(ControladorJogo c) {
        this.c = c;
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
            c.getPersonagemSelecionado().setVida(c.getPersonagemSelecionado().getVida() - 2);
            c.setHabilitaBotaoSobrecargaAtacar(false);
            c.notificaMensagem("Seu personagem perdeu 2 pontos de vida por conta da sobrecarga");
            proxEstado();
        } catch (Exception ex) {
            Logger.getLogger(JogoSobrecargaAtacar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
