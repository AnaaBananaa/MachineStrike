/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.util.List;
import model.Personagem;

/**
 *
 * @author Aners
 */
public interface ObservadorEscolhaPersonagem {

    public void exibirTela();
    public void mostrarPersonagem(List<Personagem> p);
    public void exibirProxTela();
    public void mostrarMensagem(String mensagem);
}
