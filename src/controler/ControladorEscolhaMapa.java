/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import Builder.mapa.BuilderMapa;
import Builder.mapa.GeradorMapa;
import Command.AddMapaCommand;
import Command.CommandInvoker;
import Observer.ObservadorEscolhaMapa;
import Singleton.Jogo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aners
 */
public class ControladorEscolhaMapa {

    private List<Observer.ObservadorEscolhaMapa> obss = new ArrayList<>();
    CommandInvoker ci = new CommandInvoker();

    public void anexar(ObservadorEscolhaMapa obs) {
        this.obss.add(obs);
    }

    public void salvarMapa(BuilderMapa b) {
            BuilderMapa mg = b;
            GeradorMapa gm = new GeradorMapa(mg);
            gm.construir();
            ci.add(new AddMapaCommand(mg.getMapa()));
            ci.execute();
    }

    public void atualizaMensagem(String mensagem) {
        for (ObservadorEscolhaMapa obs : obss) {
            obs.mostrarMensagem(mensagem);
        }
    }

    public void verificaTela() {
        if (!Jogo.getInstance().getMapa().isEmpty()) {
            abreTela();
        } else {
            atualizaMensagem("Selecione um mapa antes de seguir");
        }
    }

    private void abreTela() {
        for (ObservadorEscolhaMapa obs : obss) {
            obs.exibirProxTela();
        }
    }

}
