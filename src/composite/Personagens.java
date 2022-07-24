/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

import draw.DesenhaInfoPersonagem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Aners
 */
public class Personagens extends PersonagemJogo {

    @Override
    public JPanel getDados() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(880, 220);
        int auxX = 0;
        int auxY = 0;
        DesenhaInfoPersonagem inf = new DesenhaInfoPersonagem();
        for (PersonagemJogo p : membros) {
            panel.add(inf.populaDadosPersonagens(p, auxX, auxY));
            auxX += 64;
            if (auxX >= 640) {
                auxY += 100;
                auxX = 0;
            }
        }
        return panel;
    }

    private List<PersonagemJogo> membros = new ArrayList<>();

    public void add(PersonagemJogo membro) {
        membros.add(membro);
    }

    public void remove(PersonagemJogo membro) {
        membros.remove(membro);
    }

    public PersonagemJogo getPersonagens(int index) {
        return membros.get(index);
    }

}
