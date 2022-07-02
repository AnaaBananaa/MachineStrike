/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import Builder.mapa.BuilderMapa;
import Observer.ObservadorMapaJogo;
import Singleton.PersonagensJogo;
import abstractFactory.FabricaAtaque.Ataque;
import abstractFactory.FabricaAtaque.FabricaAtaque;
import abstractFactory.FabricaAtaque.FabricaAtaqueBaixo;
import abstractFactory.FabricaAtaque.FabricaAtaqueCima;
import abstractFactory.FabricaAtaque.FabricaAtaqueDireita;
import abstractFactory.FabricaAtaque.FabricaAtaqueEsquerda;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import model.Personagem;
import model.mapa.MapaGenerico;
import state.JogoDisponivel;
import state.JogoEstado;
import view.mapaJogo;

/**
 *
 * @author Aners
 */
public class ControladorJogo {

    private List<Observer.ObservadorMapaJogo> obss = new ArrayList<>();
    private List<String> mapa = new ArrayList<>();
    private List<Personagem> personagens = new ArrayList<>();
    private Personagem personagemSelecionado;
    private boolean habilitaBotaoMatar;
    private boolean habilitaBotaoRotacionar;
    private boolean habilitaBotaoMover;
    private int turno = 0;
    private boolean isTurnoJogador1;
    private boolean carregouTudo;
    private JogoEstado estado;

    public ControladorJogo() {
        this.estado = new JogoDisponivel(this);
    }

    public void setEstado(JogoEstado estado) {
        this.estado = estado;
    }

    public void anexar(ObservadorMapaJogo obs) {
        this.obss.add(obs);
    }

    public List<MapaGenerico> getMapa() {
        return PersonagensJogo.getInstance().getMapa();
    }

    public List<Personagem> getPersonagem() {
        return PersonagensJogo.getInstance().getPersonagens();
    }

    public Personagem getPeca(int x, int y) {
        int xAux = x / 64;
        int yAux = y / 64;
        for (Personagem p : getPersonagem()) {
            if ((p.getX()) == xAux && (p.getY()) == yAux) {
                setHabilitaBotaoMatar(true);
                setHabilitaBotaoMover(true);
                setHabilitaBotaoRotacionar(true);
                atualizarBotoes();
                return p;
            }
        }
        return null;
    }

    public void validaPosicao(Personagem pAux, int x, int y) {
        x = x / 64;
        y = y / 64;
        if (pAux.getJogador() == 1) {
            if (y >= 6) {
                for (Personagem p : getPersonagem()) {
                    if (p.equals(pAux)) {
                        p.setX(x);
                        p.setY(y);
                        adicionaEmTela(p);
                    }
                }
            }
        } else if (pAux.getJogador() == 2) {
            if (y <= 3) {
                for (Personagem p : getPersonagem()) {
                    if (p.equals(pAux)) {
                        p.setX(x);
                        p.setY(y);
                        adicionaEmTela(p);
                    }
                }
            }
        }
    }

    private void adicionaEmTela(Personagem p) {
        obss.forEach(obs -> {
            obs.adicionaEmTela(p);
        });
    }

    public void atualizacoes(boolean b) {
        carregouTudo = !b;
        atualizaCombo();
    }

    private void atualizaCombo() {
        obss.forEach(obs -> {
            obs.carregaCombo();
        });
    }

    private void atualizarBotoes() {
        obss.forEach(obs -> {
            obs.habilitaBotoes();
        });
    }

    private void atualizaLabels(Personagem p, int x, int y) {
        obss.forEach(obs -> {
            obs.atualizaLabel(p, x, y);
        });
    }

    public void desenhaMapa(mapaJogo aThis) {
    }

    public void escolhePersonagem(int num) {
        estado.escolha(num);
    }

    public boolean validaTurno() {
        return turno <= 2;
    }

    public void notificaMensagem(String mensagem) {
        obss.forEach(obs -> {
            obs.enviaMensagem(mensagem);
        });
    }

    public void atacaPersonagem(FabricaAtaque fb, Personagem personagemAtacado) {
        turno = +1;
        Ataque ataqueFabrica;
        int ataque = personagemSelecionado.getForcaAtaque();
        System.out.println(ataque);
        ataqueFabrica = fb.atacarPersonagem();
        System.out.println(personagemAtacado.getVida());
        personagemAtacado.setVida(ataqueFabrica.ataque(personagemAtacado, ataque));
        System.out.println(personagemAtacado.getVida());
        desabilitaBotoes();
    }

    public void movePersonagem(int x, int y) {
        int xAux = x / 64;
        int yAux = (y / 64) * 8;
        if (getPeca(x, y) == null) {
            getPersonagem().stream().filter(p -> (p.equals(personagemSelecionado))).map(p -> {
                atualizaLabels(personagemSelecionado, xAux, yAux);
                p.setX(xAux);
                return p;
            }).forEachOrdered(p -> {
                p.setY(y / 64);
            });
            if (turno < 2) {
                turno++;
            }
            desabilitaBotoes();
        } else {
            notificaMensagem("Já existe um personagem nesta posição");
            desabilitaBotoes();
            personagemSelecionado = null;
        }
    }

    public void desabilitaBotoes() {
        setHabilitaBotaoMatar(false);
        setHabilitaBotaoMover(false);
        setHabilitaBotaoRotacionar(false);
        atualizarBotoes();
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<Personagem> personagens) {
        this.personagens = personagens;
    }

    public boolean getHabilitaBotaoMatar() {
        return habilitaBotaoMatar;
    }

    public void setHabilitaBotaoMatar(boolean habilitaBotaoMatar) {
        this.habilitaBotaoMatar = habilitaBotaoMatar;
    }

    public boolean getHabilitaBotaoRotacionar() {
        return habilitaBotaoRotacionar;
    }

    public void setHabilitaBotaoRotacionar(boolean habilitaBotaoRotacionar) {
        this.habilitaBotaoRotacionar = habilitaBotaoRotacionar;
    }

    public boolean getHabilitaBotaoMover() {
        return habilitaBotaoMover;
    }

    public void setHabilitaBotaoMover(boolean habilitaBotaoMover) {
        this.habilitaBotaoMover = habilitaBotaoMover;
    }

    public Personagem getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(Personagem personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }

    public boolean isCarregouTudo() {
        return carregouTudo;
    }

    public void setCarregouTudo(boolean carregouTudo) {
        this.carregouTudo = carregouTudo;
    }

    public void rotacionar() throws Exception {
        personagemSelecionado.getFotoPersonagem();
        String imagem = personagemSelecionado.getCaminhoImagem() + "Direita.png";
        BufferedImage fotoPersonagem = null;
        try {
            fotoPersonagem = ImageIO.read(new File(imagem));
        } catch (IOException ex) {
            Logger.getLogger(ControladorJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        personagemSelecionado.setFotoPersonagem(fotoPersonagem);
        Personagem p = personagemSelecionado.clonar();
        personagemSelecionado.setFrente(p.getEsquerda());
        personagemSelecionado.setEsquerda(p.getCostas());
        personagemSelecionado.setCostas(p.getDireita());
        personagemSelecionado.setDireita(p.getFrente());
        atualizaImagem(personagemSelecionado);
        desabilitaBotoes();
    }

    public void atualizaImagem(Personagem p) {
        obss.forEach(obs -> {
            obs.atualizaImagem(p);
        });
    }

    public void acao(int x, int y) {
        this.estado.acao(x, y);
    }
}
