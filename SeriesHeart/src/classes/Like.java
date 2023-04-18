/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.InputStream;

/**
 *
 * @author yasmi
 */
public class Like {

    public int id;
    public int userId;
    public int likedId;
    public String username;
    public String likedUsername;
    public InputStream picture;

    public Like(int id, int userId, int likedId, String username, String likedUsername, InputStream picture) {
        this.id = id;
        this.userId = userId;
        this.likedId = likedId;
        this.username = username;
        this.likedUsername = likedUsername;
        this.picture = picture;
    }

}
