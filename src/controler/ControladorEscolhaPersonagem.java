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
import Singleton.Jogo;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import visitor.CalculaPersonagens;

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
        if (jogador == 1) {
            aux1 += pEscolhido.getCustoVP();
        } else {
            aux2 += pEscolhido.getCustoVP();
        }

        if (aux1 <= 10 && pEscolhido.getJogador() == 1) {
            p = pEscolhido;
            inverter();
            ci.add(new AddPersonagemCommand(p));
            ci.execute();
            exibirPersonagens();
        } else if (aux2 <= 10 && pEscolhido.getJogador() == 2) {
            p = pEscolhido;
            inverter();
            ci.add(new AddPersonagemCommand(p));
            ci.execute();
            exibirPersonagens();
        } else {
            enviarMensagem("O limite de personagens foi atingido");
        }
    }

    public void exibirPersonagens() {
        for (ObservadorEscolhaPersonagem obs : obss) {
            obs.mostrarPersonagem(Jogo.getInstance().getPersonagens());
        }
    }

    private void enviarMensagem(String mensagem) {
        for (ObservadorEscolhaPersonagem obs : obss) {
            obs.mostrarMensagem(mensagem);
        }
    }

    public void desfazerEscolha() {
        if (Jogo.getInstance().getPersonagens().size() > 0) {
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
            img = ImageIO.read(new File(p.getCaminhoImagem() + "Costas.png"));
            p.setFotoPersonagem(img);
            Personagem pAux = p.clonar();
            p.setEsquerda(pAux.getDireita());
            p.setDireita(pAux.getEsquerda());
            p.setFrente(pAux.getCostas());
            p.setCostas(pAux.getFrente());
        } else {
            img = ImageIO.read(new File(p.getCaminhoImagem() + "Frente.png"));
            p.setFotoPersonagem(img);
        }
    }

    public void verificaPersonagem() {
        if (aux1 >= 1 && aux2 >= 1) {
            CalculaPersonagens cp = new CalculaPersonagens();
            Jogo.getInstance().accept(cp);
            Jogo.getInstance().setMenosPersonagens(cp.menosPersonagens());
            abreTela();
        } else {
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
