/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import Builder.mapa.BuilderMapa;
import Builder.mapa.GeradorMapa;
import Builder.mapa.MapaGrama;
import Command.AddMapaCommand;
import Command.CommandInvoker;
import Observer.ObservadorEscolhaMapa;
import Singleton.PersonagensJogo;
import java.util.ArrayList;
import java.util.List;
import model.mapa.MapaGenerico;

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
    
    public void salvarMapa(int numero) {
        List<String> configMapa = new ArrayList<>();
        if (numero == 1) {
            BuilderMapa mg = new MapaGrama();
            GeradorMapa gm = new GeradorMapa(mg);
            gm.construir();
            List<MapaGenerico> mapa = new ArrayList<>();
            for (int i = 0; i < 64; i++) {
                mapa.add(mg.getMapa());
            }
            ci.add(new AddMapaCommand(mapa));
            ci.execute();
        }
    }
    
    public void atualizaMensagem(String mensagem) {
        for (ObservadorEscolhaMapa obs : obss) {
            obs.mostrarMensagem(mensagem);
        }
    }
    
    public void verificaTela() {
        if (!PersonagensJogo.getInstance().getMapa().isEmpty()) {
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
