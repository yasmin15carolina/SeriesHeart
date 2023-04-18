/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.Database;
import classes.FavoritesSeries;
import classes.User;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JList;

/**
 *
 * @author yasmi
 */
public class Chats extends javax.swing.JPanel {

    /**
     * Creates new form Chats
     */
    public Chats() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();

        jScrollPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jScrollPane1FocusLost(evt);
            }
        });
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollPane1MousePressed(evt);
            }
        });
        jScrollPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jScrollPane1ComponentMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jScrollPane1ComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1ComponentMoved

    private void jScrollPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MousePressed
        try {
            // TODO add your handling code here:
            getLikes();
        } catch (SQLException ex) {
            Logger.getLogger(Chats.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Chats.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jScrollPane1MousePressed

    private void jScrollPane1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jScrollPane1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1FocusLost

    //pega os likes os likes do usuario do banco de dados
    public void getLikes() throws SQLException, IOException {
        String sql = "SELECT liked,profilePicture,username FROM `like` INNER JOIN user ON liked=user.id WHERE userId=" + userLogged.id;
        likes = db.Select(sql);
        System.out.println(likes);
        jScrollPane1.removeAll();

        //likes.first();
        while (likes.next()) {
            //verifica se o like é reciproco
            String q = "SELECT 1 FROM `like` WHERE userId=" + likes.getInt("liked") + " AND `liked`=" + userLogged.id;
            ResultSet l = db.Select(q);
            if (l.next()) {
                System.out.println("1");
                ChatPreview cp = new ChatPreview();
                cp.setSize(new Dimension(550, 90));
                cp.setLocation(x, y);

                cp.pic = likes.getBinaryStream("profilePicture");
                cp.userId = userLogged.id;
                cp.username1 = userLogged.username;
                cp.userId2 = likes.getInt("liked");
                cp.username2 = likes.getString("username");
                cp.getChat();

                jScrollPane1.add(cp);
                jScrollPane1.revalidate();
                jScrollPane1.repaint();
                y += 90;

            }
        }
        x = 0;
        y = 0;
    }

    //List jPane = new ArrayList<java.>();
    ResultSet likes = null;
    User userLogged = null;
    Database db = new Database();
    int x = 0, y = 0;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}