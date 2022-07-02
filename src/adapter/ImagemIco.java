/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author Aners
 */
public class ImagemIco {

    public ImageIcon converte(Image p) {
        return new ImageIcon(new ImageIcon(p).getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));

    }

}
