/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state.Personagem;

import controler.ControladorJogo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import model.Personagem;

/**
 *
 * @author Aners
 */
public class PersonagemRotacionaCostas extends PersonagemEstado {

    private Personagem p;

    public PersonagemRotacionaCostas(Personagem p) {
        this.p = p;
    }

    @Override
    public void proxEstado() {
        p.setEstado(new PersonagemRotacionaDireita(p));
    }

    @Override
    public void rotacionar() {
        try {
            p.getFotoPersonagem();
            String imagem = p.getCaminhoImagem() + "Direita.png";
            BufferedImage fotoPersonagem = null;
            fotoPersonagem = ImageIO.read(new File(imagem));
            p.setFotoPersonagem(fotoPersonagem);
            Personagem pAux = p.clonar();
            p.setFrente(pAux.getEsquerda());
            p.setEsquerda(pAux.getCostas());
            p.setCostas(pAux.getDireita());
            p.setDireita(pAux.getFrente());
        } catch (Exception ex) {
            Logger.getLogger(PersonagemRotacionaCostas.class.getName()).log(Level.SEVERE, null, ex);
        }
        proxEstado();
    }

}
