/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.Database;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author yasmi
 */
public class ChatPreview extends javax.swing.JPanel {

    /**
     * Creates new form ChatPreview
     */
    public ChatPreview() {
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

        profile = new javax.swing.JLabel();
        profile1 = new javax.swing.JLabel();
        btnGoToChat = new javax.swing.JButton();
        lastMessage = new javax.swing.JLabel();

        profile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        profile1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        profile1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profile1MouseClicked(evt);
            }
        });

        btnGoToChat.setText(">>");
        btnGoToChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToChatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 370, Short.MAX_VALUE)
                .addComponent(btnGoToChat, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(77, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnGoToChat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lastMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void profile1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_profile1MouseClicked

    private void btnGoToChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToChatActionPerformed
        // TODO add your handling code here:
        Chat chat = new Chat(username1);
        chat.setVisible(true);
        chat.setDefaultCloseOperation(chat.DISPOSE_ON_CLOSE);
        chat.userId = userId;
        chat.otherId = userId2;
        chat.getPreviousMessages(getPreviousMessages());
        chat.show();
        btnGoToChat.setBackground(new Color(187, 187, 187));
    }//GEN-LAST:event_btnGoToChatActionPerformed

    //formata a imagem do banco de dados para a label
    public ImageIcon ResizeImage(InputStream pic) throws IOException {
        Image img = ImageIO.read(pic);
        img = img.getScaledInstance(profile.getWidth(), profile.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imgcon = new ImageIcon(img);
        profile.setIcon(imgcon);

        return imgcon;
    }

    public void getChat() throws IOException {
        profile.setSize(80, 80);
        profile.setIcon(ResizeImage(pic));
        String sql = "SELECT * FROM `messages` WHERE "
                + "(`from`=" + userId2 + " OR `from`=" + userId
                + ") AND (`to`=" + userId + " OR `to`=" + userId2 + ") "
                + "ORDER BY `messages`.id DESC";
        System.out.println(sql);
        try {
            ResultSet messages = db.Select(sql);
            if (messages.first()) {
                messages.first();
                String message = "";
                if (messages.getInt("from") == userId) {
                    message += username1 + ": ";
                } else {
                    message += username2 + ": ";
                    if (!messages.getBoolean("readMsg")) {
                        btnGoToChat.setBackground(new Color(0, 255, 51));
                    }
                }
                message += messages.getString("message");
                lastMessage.setText(message);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChatPreview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getPreviousMessages() {
        String sql = "SELECT * FROM `messages` WHERE "
                + "(`from`=" + userId2 + " OR `from`=" + userId
                + ") AND (`to`=" + userId + " OR `to`=" + userId2 + ")";
        ResultSet messages = null;
        String message = "";
        try {
            messages = db.Select(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ChatPreview.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (messages.next()) {

                if (messages.getInt("from") == userId) {
                    message += username1 + ": ";
                } else {
                    message += username2 + ": ";
                }
                message += messages.getString("message") + "\n";
            }
            messages.last();
            db.Update("UPDATE `messages` SET `readMsg` = '1' WHERE `from` = '" + userId2 + "' AND `to` = '" + userId + "'");
            return message;
        } catch (SQLException ex) {
            Logger.getLogger(ChatPreview.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    int userId;
    int userId2;
    String username1;
    String username2;
    InputStream pic;
    Database db = new Database();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoToChat;
    private javax.swing.JLabel lastMessage;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel profile1;
    // End of variables declaration//GEN-END:variables
}