/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import model.Personagem;

/**
 *
 * @author Aners
 */
public interface ObservadorMapaJogo {
    void exibirTela();
    void carregaCombo();
    void habilitaBotoes();
    void enviaMensagem(String mensagem);
    void adicionaEmTela(Personagem p);
    void atualizaLabel(Personagem p, int x, int y);
    void atualizaImagem(Personagem p);
}
