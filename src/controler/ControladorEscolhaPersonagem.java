/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import Command.AddPersonagemCommand;
import Command.CommandInvoker;
import Observer.ObservadorEscolhaPersonagem;
import java.util.ArrayList;
import java.util.List;
import model.Personagem;
import Singleton.PersonagensJogo;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Aners
 */
public class ControladorEscolhaPersonagem {

    private List<ObservadorEscolhaPersonagem> obss = new ArrayList<>();
    private ControladorJogo controladorJogo = new ControladorJogo();
    private int aux1 = 0;
    private int aux2 = 0;
    private int jogador = 1;
    CommandInvoker ci = new CommandInvoker();
    Personagem p;

    public void anexar(ObservadorEscolhaPersonagem obs) {
        this.obss.add(obs);
    }

    public void exibir() {
        for (ObservadorEscolhaPersonagem obs : obss) {
            obs.exibirTela();
        }
    }

    public void salvarPeronsagem(Personagem pEscolhido) throws Exception {
        PersonagensJogo.getInstance().getPersonagens().forEach(ps -> {
            if (ps.getJogador() == 1) {
                aux1 = ps.getCustoVP();
            } else {
                aux2 = ps.getCustoVP();
            }
        });
        if (aux1 + aux2 <= 20) {
            p = pEscolhido;
            inverter();
            ci.add(new AddPersonagemCommand(p));
            ci.execute();
            exibirPersonagens();
        } else {
            enviarMensagem("Os personagens já foram escolhidos, por favor siga com a escolha do mapa");
        }
    }

    public void exibirPersonagens() {
        for (ObservadorEscolhaPersonagem obs : obss) {
            obs.mostrarPersonagem(PersonagensJogo.getInstance().getPersonagens());
        }
    }

    private void enviarMensagem(String mensagem) {
        for (ObservadorEscolhaPersonagem obs : obss) {
            obs.mostrarMensagem(mensagem);
        }
    }

    public void desfazerEscolha() {
        if (PersonagensJogo.getInstance().getPersonagens().size() > 0) {
            ci.undo();
            exibirPersonagens();
        } else {
            enviarMensagem("Não há mais personagens para remover!");
        }
    }

    public void mudarJogador() {
        if (jogador == 1) {
            jogador = 2;
        } else {
            jogador = 1;
        }
    }

    public void inverter() throws Exception {
        BufferedImage img = null;
        if (jogador == 1) {
            if (aux1 < 10) {
                aux1 += 1;
                img = ImageIO.read(new File(p.getCaminhoImagem() + "Costas.png"));
                p.setFotoPersonagem(img);
            } else {
                enviarMensagem("Os personagens do jogador 1 já foram escolhidos, mude de jogador");
            }
        } else {
            if (aux1 < 10) {
                aux2 += 1;
                img = ImageIO.read(new File(p.getCaminhoImagem() + "Frente.png"));
                p.setFotoPersonagem(img);
            } else {
                enviarMensagem("Os personagens do jogador 2 já foram escolhidos, mude de jogador");
            }
        }
    }

    public void verificaPersonagem() {
        if(aux1 >= 1 && aux2 >= 1){
            abreTela();
        }else{
            enviarMensagem("Escolha os personagens antes de seguir");
        }
    }

    private void abreTela() {
        for (ObservadorEscolhaPersonagem obs : obss) {
            obs.exibirProxTela();
        }
    }

    public int getJogador() {
        return jogador;
    }

    public void setJogador(int jogador) {
        this.jogador = jogador;
    }
    
}
