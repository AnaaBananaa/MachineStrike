/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import Observer.ObservadorMapaJogo;
import Singleton.Jogo;
import abstractFactory.FabricaAtaque.Ataque;
import abstractFactory.FabricaAtaque.FabricaAtaque;
import abstractFactory.FabricaAtaque.FabricaAtaqueBaixo;
import abstractFactory.FabricaAtaque.FabricaAtaqueCima;
import abstractFactory.FabricaAtaque.FabricaAtaqueDireita;
import abstractFactory.FabricaAtaque.FabricaAtaqueEsquerda;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Personagem;
import model.mapa.MapaGenerico;
import state.JogoAtacando;
import state.JogoDisponivel;
import state.JogoEstado;
import visitor.CalculaGanhador;
import visitor.CalculaQtdPersonagem;

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
    private boolean ganhou;
    private boolean carregouTudo;
    private JogoEstado estado;
    private boolean moveu;
    private boolean atacou;
    private int jogadas;

    public ControladorJogo() {
        this.estado = new JogoDisponivel(this);
        moveu = true;
        atacou = true;
    }

    public Personagem getPeca(int x, int y) {
        if (!ganhou) {
            int xAux = x / 64;
            int yAux = y / 64;
            for (Personagem p : getPersonagem()) {
                if ((p.getX()) == xAux && (p.getY()) == yAux) {
                    if (jogadas == 2) {
                        setHabilitaBotaoSobrecargaAtacar(jogadas == 2);
                        setHabilitaBotaoSobrecargaMover(jogadas == 2);
                    } else {
                        setHabilitaBotaoMatar((p.isPermiteAtacar() && atacou) && jogadas < 2);
                        setHabilitaBotaoMover(p.isPermiteMover() || moveu);
                    }
                    setHabilitaBotaoRotacionar(true);
                    atualizarBotoes();
                    return p;
                }
            }
            return null;
        } else {
            notificaMensagem("Jogo acabou");
            return null;
        }
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

    public void atacaPersonagem(Personagem pAtact, int x, int y) throws Exception {
        int posicao = x / 64 + (y / 64) * 8;
        int danoAtaqueMapa = getMapa().get(posicao).getDanoAtaque();
        Personagem p = null;
        FabricaAtaque fb = null;
        int xAux = x / 64;
        int yAux = y / 64;
        if (verificaLimitesAtaque(yAux * 64, xAux * 64, 3) == 3) {
            if (pAtact != null) {
                if (personagemSelecionado.getJogador() == pAtact.getJogador()) {
                    notificaMensagem("O personagem escolhido é do jogador " + personagemSelecionado.getJogador());
                    personagemSelecionado.setPermiteAtacar(true);
                } else {
                    try {
                        if ((personagemSelecionado.getX() < pAtact.getX()) && (personagemSelecionado.getAlcance() >= pAtact.getX() - personagemSelecionado.getX())) {
                            p = personagemSelecionado.ataqueDaClasse(pAtact.clonar(), 1);
                            fb = new FabricaAtaqueEsquerda();

                        } else if ((personagemSelecionado.getX() > pAtact.getX()) && (personagemSelecionado.getAlcance() >= personagemSelecionado.getX() - pAtact.getX())) {
                            p = personagemSelecionado.ataqueDaClasse(pAtact.clonar(), 2);
                            fb = new FabricaAtaqueDireita();

                        } else if ((personagemSelecionado.getY() < pAtact.getY()) && (personagemSelecionado.getAlcance() >= pAtact.getY() - personagemSelecionado.getY())) {
                            p = personagemSelecionado.ataqueDaClasse(pAtact.clonar(), 3);
                            fb = new FabricaAtaqueCima();

                        } else if ((personagemSelecionado.getY() > pAtact.getY()) && (personagemSelecionado.getAlcance() >= personagemSelecionado.getY() - pAtact.getY())) {
                            p = personagemSelecionado.ataqueDaClasse(pAtact.clonar(), 4);
                            fb = new FabricaAtaqueBaixo();
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(JogoAtacando.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (p == null) {
                        notificaMensagem("O jogador selecionado não se encontra no alcance de ataque");
                    } else {
                        Ataque ataqueFabrica;
                        int ataque = personagemSelecionado.getForcaAtaque() + danoAtaqueMapa;
                        ataqueFabrica = fb.atacarPersonagem();
                        ataqueFabrica.ataque(pAtact, ataque, personagemSelecionado);
                        boolean temPersonagem = false;
                        for (Personagem ps : Jogo.getInstance().getPersonagens()) {
                            if ((ps.getX() == p.getX()) && (ps.getY() == p.getY())) {
                                temPersonagem = true;
                            }
                        }
                        if (!temPersonagem) {
                            movePersonagem(pAtact, p.getX(), p.getY());
                        }
                        notificaMensagem("O personagem " + pAtact.getNome() + " foi atacado! Sua vida atual é: " + pAtact.getVida());
                        validaGanhador();
                        setJogadas(getJogadas() + 3);
                        personagemSelecionado.setPermiteAtacar(false);
                        setJogadas(2);
                        setMoveu(false);
                        setAtacou(false);
                        if (isHabilitaBotaoSobrecargaAtacar()) {
                            personagemSelecionado.setVida(personagemSelecionado.getVida() - 2);
                            notificaMensagem("Seu personagem perdeu 2 pontos de vida por conta da sobrecarga");
                        }
                    }
                }
            } else {
                notificaMensagem("Jogador a ser atacado não foi selecionado");
                personagemSelecionado.setPermiteAtacar(true);
            }
        } else {
            notificaMensagem("O jogador selecionado não se encontra no alcance de ataque");
        }
        limpaTela();
        desabilitaBotoes();
    }

    public void movePersonagem(Personagem personagem, int x, int y) {
        getPersonagem().stream().filter(p -> (p.equals(personagem))).map(p -> {
            atualizaLabels(personagem, x, y * 8);
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

    private void limpaMortos(int x, int y) {
        obss.forEach(obs -> {
            obs.limpaMorto(x, y);
        });
    }

    public void acao(int x, int y) {
        if (personagemSelecionado != null) {
            this.estado.acao(x, y);
        } else {
            this.estado.acao(x, y);
        }
    }

    public void validaGanhador() throws Exception {
        Jogo.getInstance().setMortos(new ArrayList<>());
        List<Personagem> pMortos = new ArrayList<>();
        for (Personagem p : Jogo.getInstance().getPersonagens()) {
            if (p.getVida() <= 0) {
                Jogo.getInstance().addMortos(p.clonar());
                limpaMortos(p.getX() * 64, p.getY() * 64);
                pMortos.add(p);
            }
        }
        Jogo.getInstance().getPersonagens().removeAll(pMortos);
        CalculaGanhador ganhador = new CalculaGanhador();
        CalculaQtdPersonagem cp = new CalculaQtdPersonagem();
        Jogo.getInstance().accept(ganhador);
        Jogo.getInstance().acceptVivos(cp);
        if (Jogo.getInstance().isMenosPersonagens()) {
            if (cp.getIogadores1() >= 1 && cp.getJogadores2() == 0) {
                notificaMensagem("O jogador 1 ganhou o jogo!");
            } else if (cp.getJogadores2() >= 1 && cp.getIogadores1() == 0) {
                notificaMensagem("O jogador 2 ganhou o jogo!");
            }
        } else {
            if (ganhador.ganhador() == 1) {
                notificaMensagem("O jogador 1 ganhou o jogo!");
                desabilitaBotoes();
            } else if (ganhador.ganhador() == 2) {
                notificaMensagem("O jogador 2 ganhou o jogo!");
                desabilitaBotoes();
            }
        }
        atualizaPontos(ganhador.pontosGanhador1(), ganhador.pontosGanhador2());
    }

    public void atualizaPontos(int j1, int j2) {
        obss.forEach(obs -> {
            obs.atualizaPontos(j1, j2);
        });
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
        return Jogo.getInstance().getMapa();
    }

    public List<Personagem> getPersonagem() {
        return Jogo.getInstance().getPersonagens();
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
        List<Integer> posicoesX = new ArrayList<>();
        List<Integer> posicoesY = new ArrayList<>();
        List<Integer> posicoesDiagonalX = new ArrayList<>();
        List<Integer> posicoesDiagonalY = new ArrayList<>();
        int[][] matrizDiagonal = {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};
        for (Personagem p : Jogo.getInstance().getPersonagens()) {
            if (p != personagemSelecionado) {
                if (p.getY() == personagemSelecionado.getY()) {
                    if (p.getX() >= personagemSelecionado.getX() && p.getX() <= personagemSelecionado.getX() + personagemSelecionado.getMovimentacao()) {
                        for (int i = p.getX(); i <= 7; i++) {
                            posicoesX.add(i * 64);
                        }
                    } else if (p.getX() <= personagemSelecionado.getX() && p.getX() >= personagemSelecionado.getX() - personagemSelecionado.getMovimentacao()) {
                        for (int i = p.getX(); i >= 0; i--) {
                            posicoesX.add(i * 64);
                        }
                    }
                } else if (p.getX() == personagemSelecionado.getX()) {
                    if (p.getY() >= personagemSelecionado.getY() && p.getY() <= personagemSelecionado.getY() + personagemSelecionado.getMovimentacao()) {
                        for (int i = p.getY(); i <= 7; i++) {
                            posicoesY.add(i * 64);
                        }
                    } else if (p.getY() <= personagemSelecionado.getY() && p.getY() >= personagemSelecionado.getY() - personagemSelecionado.getMovimentacao()) {
                        for (int i = p.getY(); i >= 0; i--) {
                            posicoesY.add(i * 64);
                        }
                    }
                } else if ((p.getY() >= personagemSelecionado.getY() && p.getY() <= personagemSelecionado.getY() + personagemSelecionado.getMovimentacao() / 2) && (p.getX() >= personagemSelecionado.getX() && p.getX() <= personagemSelecionado.getX() + personagemSelecionado.getMovimentacao() / 2)) {
                    int auxX = p.getX();
                    int auxY = p.getY();
                    for (int i = p.getY(); i <= 7; i++) {
                        if ((auxX >= 0 && auxX <= 7) && (auxY >= 0 && auxY <= 7)) {
                            matrizDiagonal[auxX][auxY] = 1;
                            auxX += 1;
                            auxY += 1;
                        }
                    }
                } else if ((p.getY() <= personagemSelecionado.getY() && p.getY() >= personagemSelecionado.getY() - personagemSelecionado.getMovimentacao() / 2) && (p.getX() <= personagemSelecionado.getX() && p.getX() >= personagemSelecionado.getX() - personagemSelecionado.getMovimentacao() / 2)) {
                    int auxX = p.getX();
                    int auxY = p.getY();
                    for (int i = p.getY(); i >= 8 - p.getY(); i--) {
                        if ((auxX >= 0 && auxX <= 7) && (auxY >= 0 && auxY <= 7)) {
                            matrizDiagonal[auxX][auxY] = 1;
                            auxX -= 1;
                            auxY -= 1;
                        }
                    }
                } else if ((p.getY() >= personagemSelecionado.getY() && p.getY() <= personagemSelecionado.getY() + personagemSelecionado.getMovimentacao() / 2) && (p.getX() <= personagemSelecionado.getX() && p.getX() >= personagemSelecionado.getX() - personagemSelecionado.getMovimentacao() / 2)) {
                    int auxX = p.getX();
                    int auxY = p.getY();
                    for (int i = p.getY(); i <= 7; i++) {
                        if ((auxX >= 0 && auxX <= 7) && (auxY >= 0 && auxY <= 7)) {
                            matrizDiagonal[auxX][auxY] = 1;
                            auxX -= 1;
                            auxY += 1;
                        }
                    }
                } else if ((p.getY() <= personagemSelecionado.getY() && p.getY() >= personagemSelecionado.getY() - personagemSelecionado.getMovimentacao() / 2) && (p.getX() >= personagemSelecionado.getX() && p.getX() <= personagemSelecionado.getX() + personagemSelecionado.getMovimentacao() / 2)) {
                    int auxX = p.getX();
                    int auxY = p.getY();
                    for (int i = p.getY(); i >= 8 - p.getY(); i--) {
                        if ((auxX >= 0 && auxX <= 7) && (auxY >= 0 && auxY <= 7)) {
                            matrizDiagonal[auxX][auxY] = 1;
                            auxX += 1;
                            auxY -= 1;
                        }
                    }
                }
            }
        }

        int auxX = x / 64;
        int auxY = y / 64;
        if (getPeca(x, y)
                == null) {
            if (y == pY) {
                if (((x >= pX && x <= pX + pMovimento) || (x <= pX && x >= pX - pMovimento)) && !posicoesX.contains(x)) {
                    return posicao;
                }
            } else if (x == pX) {
                if (((y >= pY && y <= pY + pMovimento) || (y <= pY && y >= pY - pMovimento)) && !posicoesY.contains(y)) {
                    return posicao;
                }
            } else if (((y >= pY && y <= pY + pMovimento / 2) && (x >= pX && x <= pX + pMovimento / 2)) && (matrizDiagonal[auxX][auxY] == 0)) {
                return posicao;
            } else if (((y <= pY && y >= pY - pMovimento / 2) && (x <= pX && x >= pX - pMovimento / 2)) && (matrizDiagonal[auxX][auxY] == 0)) {
                return posicao;
            } else if (((y >= pY && y <= pY + pMovimento / 2) && (x <= pX && x >= pX - pMovimento / 2)) && (matrizDiagonal[auxX][auxY] == 0)) {
                return posicao;
            } else if (((y <= pY && y >= pY - pMovimento / 2) && (x >= pX && x <= pX + pMovimento / 2)) && (matrizDiagonal[auxX][auxY] == 0)) {
                return posicao;
            }
        }

        return -1;
    }

    public int verificaLimitesAtaque(int y, int x, int posicao) {
        int pX = personagemSelecionado.getX() * 64;
        int pY = personagemSelecionado.getY() * 64;
        int pMovimento = personagemSelecionado.getAlcance() * 64;
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

    public int verificaSprint(int y, int x, int posicao) {
        int pX = personagemSelecionado.getX() * 64;
        int pY = personagemSelecionado.getY() * 64;
        int pMovimento = personagemSelecionado.getMovimentacao() * 64;
        List<Integer> posicoesDiagonalX = new ArrayList<>();
        List<Integer> posicoesDiagonalY = new ArrayList<>();
        int[][] matrizDiagonal = {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}};
        for (Personagem p : Jogo.getInstance().getPersonagens()) {
            if (p != personagemSelecionado) {
                if (p.getY() == personagemSelecionado.getY()) {
                    if (p.getX() >= personagemSelecionado.getX() && p.getX() <= personagemSelecionado.getX() + personagemSelecionado.getMovimentacao()) {
                        int auxX = p.getX();
                        int auxY = p.getY();
                        for (int i = p.getX(); i <= 7; i++) {
                            matrizDiagonal[auxX][auxY] = 1;
                            auxX += 1;
                        }
                    } else if (p.getX() <= personagemSelecionado.getX() && p.getX() >= personagemSelecionado.getX() - personagemSelecionado.getMovimentacao()) {
                        int auxX = p.getX();
                        int auxY = p.getY();
                        for (int i = p.getX(); i >= 0; i--) {
                            matrizDiagonal[auxX][auxY] = 1;
                            auxX -= 1;
                        }
                    }
                } else if (p.getX() == personagemSelecionado.getX()) {
                    if (p.getY() >= personagemSelecionado.getY() && p.getY() <= personagemSelecionado.getY() + personagemSelecionado.getMovimentacao()) {
                        int auxX = p.getX();
                        int auxY = p.getY();
                        for (int i = p.getY(); i <= 7; i++) {
                            matrizDiagonal[auxX][auxY] = 1;
                            auxY += 1;
                        }
                    } else if (p.getY() <= personagemSelecionado.getY() && p.getY() >= personagemSelecionado.getY() - personagemSelecionado.getMovimentacao()) {
                        int auxX = p.getX();
                        int auxY = p.getY();
                        for (int i = p.getY(); i >= 0; i--) {
                            matrizDiagonal[auxX][auxY] = 1;
                            auxY -= 1;
                        }
                    }
                } else if ((p.getY() >= personagemSelecionado.getY() && p.getY() <= personagemSelecionado.getY() + personagemSelecionado.getMovimentacao() / 2) && (p.getX() >= personagemSelecionado.getX() && p.getX() <= personagemSelecionado.getX() + personagemSelecionado.getMovimentacao() / 2)) {
                    int auxX = p.getX();
                    int auxY = p.getY();
                    for (int i = p.getY(); i <= 7; i++) {
                        if ((auxX >= 0 && auxX <= 7) && (auxY >= 0 && auxY <= 7)) {
                            matrizDiagonal[auxX][auxY] = 1;
                            auxX += 1;
                            auxY += 1;
                        }
                    }
                } else if ((p.getY() <= personagemSelecionado.getY() && p.getY() >= personagemSelecionado.getY() - personagemSelecionado.getMovimentacao() / 2) && (p.getX() <= personagemSelecionado.getX() && p.getX() >= personagemSelecionado.getX() - personagemSelecionado.getMovimentacao() / 2)) {
                    int auxX = p.getX();
                    int auxY = p.getY();
                    for (int i = p.getY(); i >= 0; i--) {
                        if ((auxX >= 0 && auxX <= 7) && (auxY >= 0 && auxY <= 7)) {
                            matrizDiagonal[auxX][auxY] = 1;
                            auxX -= 1;
                            auxY -= 1;
                        }
                    }
                } else if ((p.getY() >= personagemSelecionado.getY() && p.getY() <= personagemSelecionado.getY() + personagemSelecionado.getMovimentacao() / 2) && (p.getX() <= personagemSelecionado.getX() && p.getX() >= personagemSelecionado.getX() - personagemSelecionado.getMovimentacao() / 2)) {
                    int auxX = p.getX();
                    int auxY = p.getY();
                    for (int i = p.getY(); i <= 7; i++) {
                        if ((auxX >= 0 && auxX <= 7) && (auxY >= 0 && auxY <= 7)) {
                            matrizDiagonal[auxX][auxY] = 1;
                            auxX -= 1;
                            auxY += 1;
                        }
                    }
                } else if ((p.getY() <= personagemSelecionado.getY() && p.getY() >= personagemSelecionado.getY() - personagemSelecionado.getMovimentacao() / 2) && (p.getX() >= personagemSelecionado.getX() && p.getX() <= personagemSelecionado.getX() + personagemSelecionado.getMovimentacao() / 2)) {
                    int auxX = p.getX();
                    int auxY = p.getY();
                    for (int i = p.getY(); i >= 0; i--) {
                        if ((auxX >= 0 && auxX <= 7) && (auxY >= 0 && auxY <= 7)) {
                            matrizDiagonal[auxX][auxY] = 1;
                            auxX += 1;
                            auxY -= 1;
                        }
                    }
                }
            }
        }
        int auxX = x / 64;
        int auxY = y / 64;

        if (getPeca(x, y)
                == null) {
            if (y == pY) {
                if (((x == pX + pMovimento + 64) || (x == pX - pMovimento - 64)) && (matrizDiagonal[auxX][auxY] == 0)) {
                    return posicao;
                }
            }
            if (x == pX) {
                if (((y == pY + pMovimento + 64) || (y == pY - pMovimento - 64)) && (matrizDiagonal[auxX][auxY] == 0)) {
                    return posicao;
                }
            } else if ((y >= pY && y <= pY + 64 + pMovimento / 2) && (x >= pX && x <= pX + 64 + pMovimento / 2) && (matrizDiagonal[auxX][auxY] == 0)) {
                return posicao;
            } else if ((y <= pY && y >= pY - 64 - pMovimento / 2) && (x <= pX && x >= pX - 64 - pMovimento / 2) && (matrizDiagonal[auxX][auxY] == 0)) {
                return posicao;
            } else if ((y >= pY && y <= pY + 64 + pMovimento / 2) && (x <= pX && x >= pX - 64 - pMovimento / 2) && (matrizDiagonal[auxX][auxY] == 0)) {
                return posicao;
            } else if ((y <= pY && y >= pY - 64 - pMovimento / 2) && (x >= pX && x <= pX + 64 + pMovimento / 2) && (matrizDiagonal[auxX][auxY] == 0)) {
                return posicao;
            }
        }
        return -1;
    }

    public boolean isMoveu() {
        return moveu;
    }

    public void setMoveu(boolean moveu) {
        this.moveu = moveu;
    }

    public boolean isAtacou() {
        return atacou;
    }

    public void setAtacou(boolean atacou) {
        this.atacou = atacou;
    }

    public int getJogadas() {
        return jogadas;
    }

    public void setJogadas(int jogadas) {
        this.jogadas = jogadas;
    }

    public void alteraTurno() {
        if (isTurnoJogador() == 1) {
            setTurnoJogador(2);
        } else {
            setTurnoJogador(1);
        }
        for (Personagem p : Jogo.getInstance().getPersonagens()) {
            p.setPermiteAtacar(true);
            p.setPermiteMover(true);
        }
        moveu = true;
        atacou = true;
        jogadas = 0;
        notificaMensagem("Vez do jogador " + isTurnoJogador());
        desabilitaBotoes();
    }

}
