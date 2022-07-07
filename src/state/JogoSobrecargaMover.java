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
public class JogoSobrecargaMover extends JogoEstado{

    private ControladorJogo c;

    public JogoSobrecargaMover(ControladorJogo c) {
        this.c = c;
        this.c.notificaMensagem("Escolha uma posição para mover o personagem selecionado");
    }
    
    @Override
    public void proxEstado() {
        c.setEstado(new JogoDisponivel(c));
    }

    @Override
    public void acao(int x, int y) {
        c.setHabilitaBotaoSobrecargaMover(false);
        c.movePersonagem(x, y);
        this.c.notificaMensagem("Seu personagem perdeu 2 pontos de vida por conta da sobrecarga");
        proxEstado();
    }
    
}
