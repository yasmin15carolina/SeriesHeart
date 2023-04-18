/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.Database;
import classes.User;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author yasmi
 */
public class RegisterUserPage extends javax.swing.JFrame {

    public RegisterUserPage() {
        initComponents();
        this.setLocationRelativeTo(null);

        chooseSeries.setVisible(false);
        btnFinish.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerUser1 = new forms.RegisterUser();
        btnRegisterUser = new javax.swing.JButton();
        chooseSeries = new forms.ChooseSeries();
        btnFinish = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        btnRegisterUser.setText("Cadastrar Usuário");
        btnRegisterUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterUserActionPerformed(evt);
            }
        });

        btnFinish.setText("Concluir");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chooseSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registerUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnRegisterUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFinish)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooseSeries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerUser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegisterUser)
                    .addComponent(btnFinish))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterUserActionPerformed
        //Registra o usuario no banco de dados
        if (registerUser1.RegisterNewUser()) {
            this.setSize(550, 550);
            //Usar select pra pegar o id do novo usuario
            Database db = new Database();

            ResultSet rs = null;
            try {
                rs = db.Select("SELECT MAX(id) FROM user");
            } catch (SQLException ex) {
                Logger.getLogger(RegisterUserPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while (rs.next()) {
                    userId = rs.getInt("MAX(id)");
                    System.out.println(userId);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterUserPage.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Abre um novo panel para escolher as series favoritas
            //initComponents();
            try {
                chooseSeries.getDBGenres();
            } catch (SQLException ex) {
                Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            chooseSeries.setVisible(true);
            chooseSeries.setLocation(0, 0);
            chooseSeries.userId = userId;
            chooseSeries.Research("SELECT * FROM serie ORDER BY title ASC");

            btnFinish.locate(btnRegisterUser.getX(), btnRegisterUser.getY());
            btnFinish.setVisible(true);
            btnRegisterUser.setVisible(false);
        }
    }//GEN-LAST:event_btnRegisterUserActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed

        Database db = new Database();
        try {
            ResultSet rs = db.Select("SELECT * FROM user WHERE id=" + userId);
            if (rs.next()) {
                User user;
                user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("uPassword"),
                        rs.getString("fullname"),
                        rs.getString("email"),
                        rs.getDate("birth"),
                        rs.getString("descri"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getBinaryStream("profilePicture")
                );
                if (chooseSeries.DefineFavorites()) {
                    mainForm mf = new mainForm();
                    mf.userLogged = user;
                    this.setVisible(false);
                    mf.setVisible(true);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterUserPage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnFinishActionPerformed

    public void SendUserToSelectSeries() {
        registerUser1.setVisible(false);
        chooseSeries.Research("SELECT * FROM serie ORDER BY title ASC");
        chooseSeries.setVisible(true);
        chooseSeries.userId = userId;

        btnFinish.locate(btnRegisterUser.getX(), btnRegisterUser.getY());
        btnFinish.setVisible(true);
        btnRegisterUser.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterUserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterUserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterUserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterUserPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterUserPage().setVisible(true);

            }
        });
    }
    public int userId = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnRegisterUser;
    private forms.ChooseSeries chooseSeries;
    private forms.RegisterUser registerUser1;
    // End of variables declaration//GEN-END:variables
}
