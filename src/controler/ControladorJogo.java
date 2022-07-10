/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import Observer.ObservadorMapaJogo;
import Singleton.PersonagensJogo;
import abstractFactory.FabricaAtaque.Ataque;
import abstractFactory.FabricaAtaque.FabricaAtaque;
import java.util.ArrayList;
import java.util.List;
import model.Personagem;
import model.mapa.MapaGenerico;
import state.JogoDisponivel;
import state.JogoEstado;

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
    private boolean habilitaBotaoSobrecargaAtacar;
    private boolean habilitaBotaoSobrecargaMover;
    private int turnoJogador = 1;
    private boolean carregouTudo;
    private JogoEstado estado;

    public ControladorJogo() {
        this.estado = new JogoDisponivel(this);
    }

    public Personagem getPeca(int x, int y) {
        int xAux = x / 64;
        int yAux = y / 64;
        for (Personagem p : getPersonagem()) {
            if ((p.getX()) == xAux && (p.getY()) == yAux) {
                setHabilitaBotaoMatar(p.isPermiteAtacar());
                setHabilitaBotaoMover(p.isPermiteMover());
                setHabilitaBotaoSobrecargaAtacar(!p.isPermiteAtacar());
                setHabilitaBotaoSobrecargaMover(!p.isPermiteMover());
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

    public void escolhePersonagem(int num) {
        estado.escolha(num);
    }

    public void notificaMensagem(String mensagem) {
        obss.forEach(obs -> {
            obs.enviaMensagem(mensagem);
        });
    }

    public void atacaPersonagem(FabricaAtaque fb, Personagem personagemAtacado) {
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
        getPersonagem().stream().filter(p -> (p.equals(personagemSelecionado))).map(p -> {
            atualizaLabels(personagemSelecionado, x, y * 8);
            p.setX(x);
            return p;
        }).forEachOrdered(p -> {
            p.setY(y);
        });
        desabilitaBotoes();

        limpaTela();
    }

    public void limpaTela() {
        obss.forEach(obs -> {
            obs.limpaTela();
        });
    }

    public void desabilitaBotoes() {
        setHabilitaBotaoMatar(false);
        setHabilitaBotaoMover(false);
        setHabilitaBotaoRotacionar(false);
        setHabilitaBotaoSobrecargaAtacar(false);
        setHabilitaBotaoSobrecargaMover(false);
        atualizarBotoes();
    }

    public void atualizaImagem(Personagem p) {
        obss.forEach(obs -> {
            obs.atualizaImagem(p);
        });
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

    public void acao(int x, int y) {
        this.estado.acao(x, y);
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

    public boolean isHabilitaBotaoSobrecargaAtacar() {
        return habilitaBotaoSobrecargaAtacar;
    }

    public void setHabilitaBotaoSobrecargaAtacar(boolean habilitaBotaoSobrecargaAtacar) {
        this.habilitaBotaoSobrecargaAtacar = habilitaBotaoSobrecargaAtacar;
    }

    public boolean isHabilitaBotaoSobrecargaMover() {
        return habilitaBotaoSobrecargaMover;
    }

    public void setHabilitaBotaoSobrecargaMover(boolean habilitaBotaoSobrecargaMover) {
        this.habilitaBotaoSobrecargaMover = habilitaBotaoSobrecargaMover;
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

    public int isTurnoJogador() {
        return turnoJogador;
    }

    public void setTurnoJogador(int turnoJogador) {
        this.turnoJogador = turnoJogador;
    }

    public int verificaLimites(int y, int x, int posicao) {
        int pX = personagemSelecionado.getX() * 64;
        int pY = personagemSelecionado.getY() * 64;
        int pMovimento = personagemSelecionado.getMovimentacao() * 64;
        if (y == pY) {
            if ((x >= pX && x <= pX + pMovimento) || (x <= pX && x >= pX - pMovimento)) {
                return posicao;
            }
        }
        if (x == pX) {
            if ((y >= pY && y <= pY + pMovimento) || (y <= pY && y >= pY - pMovimento)) {
                return posicao;
            }
        }
        return -1;
    }
    
    public int verificaSprint(int y, int x, int posicao){
        int pX = personagemSelecionado.getX() + 1 * 64;
        int pY = personagemSelecionado.getY() + 1 * 64;
        int pMovimento = personagemSelecionado.getMovimentacao() * 64;
        if (y == pY) {
            if ((x == pX + pMovimento) || (x == pX - pMovimento)) {
                return posicao;
            }
        }
        if (x == pX) {
            if ((y == pY + pMovimento) || (y == pY - pMovimento)) {
                return posicao;
            }
        }
        return -1;
    }

}
