/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import abstractFactory.FabricaAtaque.FabricaAtaque;
import composite.PersonagemJogo;
import draw.DesenhaInfoPersonagem;
import java.awt.Image;
import javax.swing.JPanel;
import state.Personagem.PersonagemEstado;
import state.Personagem.PersonagemRotacionaCostas;
import state.Personagem.PersonagemRotacionaFrente;
import visitor.VisitorPersonagem;

/**
 *
 * @author Aners
 */
public abstract class Personagem extends PersonagemJogo implements Cloneable {

    /* Atributos de movimentacao */
    private int x;
    private int y;

    private int alcance; //Atributo que mostra de qual distancia o jogador pode atacar outro
    private int movimentacao;//Atriburo que mostra quantas casas o personagem pode mover

    /* Atributos de ação (Ataque, defesa)  */
    private int forcaAtaque; // Atributo do valor do ataque do personagem
    private int vida; // Atributo do HP do personagem
    private int frente; // Atributo representando a frente
    private int costas; // Atributo representando as costas
    private int esquerda; // Atributo representando a esquerda
    private int direita; // A tributo representando a direita

    /* Atributos de controle */
    private int jogador;
    private int custoVP;
    private String nome;
    private Image fotoPersonagem;
    private PersonagemEstado estado;
    private boolean permiteMover = true;
    private boolean permiteAtacar = true;
    private FabricaAtaque fabrica;

    public Personagem() {
    }

    public Personagem(int jogador, int alcance, int movimentacao, int forcaAtaque, int vida, int frente, int costas, int esquerda, int direita, int custoVP, String nome, int x, int y) {
        this.jogador = jogador;
        this.alcance = alcance;
        this.movimentacao = movimentacao;
        this.forcaAtaque = forcaAtaque;
        this.vida = vida;
        this.frente = frente;
        this.costas = costas;
        this.esquerda = esquerda;
        this.direita = direita;
        this.custoVP = custoVP;
        this.nome = nome;
        this.x = x;
        this.y = y;
        if (this.jogador == 1) {
            this.estado = new PersonagemRotacionaCostas(this);
        } else {
            this.estado = new PersonagemRotacionaFrente(this);
        }

    }
    public abstract Personagem ataqueDaClasse(Personagem pAtact, int posicao);
    public abstract String getCaminhoImagem();
    @Override
    public abstract String nomeClasse();

    public void rotacionar() {
        this.estado.rotacionar();
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getForcaAtaque() {
        return forcaAtaque;
    }

    public void setForcaAtaque(int forca) {
        this.forcaAtaque = forca;
    }

    @Override
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    @Override
    public int getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(int movimentacao) {
        this.movimentacao = movimentacao;
    }

    @Override
    public int getFrente() {
        return frente;
    }

    public void setFrente(int frente) {
        this.frente = frente;
    }

    @Override
    public int getCostas() {
        return costas;
    }

    public void setCostas(int costas) {
        this.costas = costas;
    }

    @Override
    public int getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(int esquerda) {
        this.esquerda = esquerda;
    }

    public int getDireita() {
        return direita;
    }

    public void setDireita(int direita) {
        this.direita = direita;
    }

    public int getJogador() {
        return jogador;
    }

    public void setJogador(int jogador) {
        this.jogador = jogador;
    }

    @Override
    public int getCustoVP() {
        return custoVP;
    }

    public void setCustoVP(int custoVP) {
        this.custoVP = custoVP;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Image getFotoPersonagem() {
        return fotoPersonagem;
    }

    public void setFotoPersonagem(Image fotoPersonagem) {
        this.fotoPersonagem = fotoPersonagem;
    }

    public Personagem clonar() throws Exception {
        return (Personagem) super.clone();
    }

    public PersonagemEstado getEstado() {
        return estado;
    }

    public void setEstado(PersonagemEstado estado) {
        this.estado = estado;
    }

    public boolean isPermiteMover() {
        return permiteMover;
    }

    public void setPermiteMover(boolean permiteMover) {
        this.permiteMover = permiteMover;
    }

    public boolean isPermiteAtacar() {
        return permiteAtacar;
    }

    public void setPermiteAtacar(boolean permiteAtacar) {
        this.permiteAtacar = permiteAtacar;
    }

    @Override
    public String toString() {
        return "O personagem "+ nome + " foi adicionado aos personagens do jogador " + jogador + "\n";
    }

    public FabricaAtaque getFabrica() {
        return fabrica;
    }

    public void setFabrica(FabricaAtaque fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public JPanel getDados(){
        DesenhaInfoPersonagem info = new DesenhaInfoPersonagem();
        return info.populaDadosPersonagem(this);
    }

    public void accept(VisitorPersonagem visitor) {
        visitor.visit(this);
    }

}
