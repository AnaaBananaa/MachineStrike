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
        c.movePersonagem(x, y);
        proxEstado();
    }
    
    
    
}
