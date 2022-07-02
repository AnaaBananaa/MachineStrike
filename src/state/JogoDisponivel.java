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
public class JogoDisponivel extends JogoEstado {
    
    private ControladorJogo c;
    private int escolha;
    
    public JogoDisponivel(ControladorJogo c) {
        this.c = c;
    }
    
    @Override
    public String toString() {
        return "Disponivel";
    }
    
    @Override
    public void proxEstado() {
        switch (escolha) {
            case 1 -> c.setEstado(new JogoMovendo(c));
            case 2 -> c.setEstado(new JogoAtacando(c));
            case 3 -> c.setEstado(new JogoRotacionando(c));
            default -> {
            }
        }
    }

    @Override
    public void acao(int x, int y) {
        System.out.println("state.JogoDisponivel.acao()");
    }

    @Override
    public void escolha(int e) {
        this.escolha = e;
        proxEstado();
    }
    
}
