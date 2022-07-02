/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import model.mapa.MapaGenerico;

/**
 *
 * @author Aners
 */
public interface VisitaMapa {
    
    	void visit(MapaGenerico mapa) throws Exception;
    
}
