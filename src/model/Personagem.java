/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;

/**
 *
 * @author Aners
 */
public abstract class Personagem implements Cloneable {

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

    public Personagem() {
    }

    public Personagem(int alcance, int movimentacao, int forcaAtaque, int vida, int frente, int costas, int esquerda, int direita, int custoVP, String nome, int x, int y) {
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
    }

    public abstract String getCaminhoImagem();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getForcaAtaque() {
        return forcaAtaque;
    }

    public void setForcaAtaque(int forca) {
        this.forcaAtaque = forca;
    }

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

    public int getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(int movimentacao) {
        this.movimentacao = movimentacao;
    }

    public int getFrente() {
        return frente;
    }

    public void setFrente(int frente) {
        this.frente = frente;
    }

    public int getCostas() {
        return costas;
    }

    public void setCostas(int costas) {
        this.costas = costas;
    }

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

    public Image getFotoPersonagem() {
        return fotoPersonagem;
    }

    public void setFotoPersonagem(Image fotoPersonagem) {
        this.fotoPersonagem = fotoPersonagem;
    }

    public Personagem clonar() throws Exception {
        return (Personagem) super.clone();
    }

    @Override
    public String toString() {
        return nome + "Player " + jogador + "\n";
    }

}
