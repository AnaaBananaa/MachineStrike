/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import Singleton.PersonagensJogo;
import model.mapa.MapaGenerico;

/**
 *
 * @author Aners
 */
public class VisitaMapaConcreto implements VisitaMapa {

    @Override
    public void visit(MapaGenerico mapa) throws Exception {
        if (mapa.equals(PersonagensJogo.getInstance().getMapaEscolhido())) {
            pontosVida = mapa.getDanoVida();
            pontosAtaque = mapa.getDanoAtaque();
        }
    }
    private int pontosVida;
    private int pontosAtaque;

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getPontosAtaque() {
        return pontosAtaque;
    }

    public void setPontosAtaque(int pontosAtaque) {
        this.pontosAtaque = pontosAtaque;
    }

}
