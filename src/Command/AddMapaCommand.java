/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Builder.mapa.BuilderMapa;
import Singleton.Jogo;
import java.util.List;
import model.mapa.MapaGenerico;

/**
 *
 * @author Aners
 */
public class AddMapaCommand implements Command {

    private final List<MapaGenerico> dados;

    public AddMapaCommand(List<MapaGenerico> dados) {
        this.dados = dados;
    }

    @Override
    public void execute() {
        Jogo.getInstance().addMapa(dados);
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
