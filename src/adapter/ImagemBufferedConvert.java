/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import java.io.File;

/**
 *
 * @author Aners
 */
public class ImagemBufferedConvert extends ImagemBuffered implements Imagem{

    @Override
    public void converterImagem(File file) throws Exception{
        super.converter(file);
    }


    
}