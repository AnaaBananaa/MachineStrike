/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state.Personagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.imageio.ImageIO;
import model.Personagem;

/**
 *
 * @author Aners
 */
public class PersonagemRotacionaEsquerda extends PersonagemEstado {

    private Personagem p;

    public PersonagemRotacionaEsquerda(Personagem p) {
        this.p = p;
    }

    @Override
    public void proxEstado() {
        p.setEstado(new PersonagemRotacionaCostas(p));
    }

    @Override
    public void rotacionar() {
        try {
            p.getFotoPersonagem();
            String imagem = p.getCaminhoImagem() + "Costas.png";
            BufferedImage fotoPersonagem = null;
            fotoPersonagem = ImageIO.read(new File(imagem));
            p.setFotoPersonagem(fotoPersonagem);
            Personagem pAux = p.clonar();
            p.setFrente(pAux.getEsquerda());
            p.setEsquerda(pAux.getCostas());
            p.setCostas(pAux.getDireita());
            p.setDireita(pAux.getFrente());
            proxEstado();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(PersonagemRotacionaEsquerda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
