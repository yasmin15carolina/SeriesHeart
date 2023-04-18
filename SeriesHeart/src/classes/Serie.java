/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author yasmi
 */
public class Serie {
        public int id;
        public String title;
        public String descri;
        public Date premiere;
        public String genre;
        public InputStream picture;

    public Serie(int id, String title, String descri, Date premiere, String genre) {
        this.id = id;
        this.title = title;
        this.descri = descri;
        this.premiere = premiere;
        this.genre = genre;
    }
        
        
}
