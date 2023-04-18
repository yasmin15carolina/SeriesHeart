/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author yasmi
 */
public class FavoritesSeries {
    public int id;
    public int serieId;
    public int userId;

    public FavoritesSeries(int id, int userId, int serieId) {
        this.id = id;
        this.serieId = serieId;
        this.userId = userId;
    }
    public FavoritesSeries(int serieId, int userId) {
        this.id = id;
        this.serieId = serieId;
        this.userId = userId;
    }
    
}
