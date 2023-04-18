package forms;

import java.sql.ResultSet;
import classes.Database;
import classes.FavoritesSeries;
import classes.User;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MatchPanel extends javax.swing.JPanel {

    public MatchPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profile = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtUser = new javax.swing.JLabel();
        txtBirthDate = new javax.swing.JLabel();
        txtState = new javax.swing.JLabel();
        txtMatch = new javax.swing.JLabel();
        txtCity = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descri = new javax.swing.JTextPane();
        btnPrevious = new javax.swing.JButton();
        btnLike = new javax.swing.JButton();

        profile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtName.setText("nome");

        txtUser.setText("usuario");

        txtBirthDate.setText("aniversario");

        txtState.setText("Estado");

        txtMatch.setText("Match:");

        txtCity.setText("Cidade ");

        btnNext.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnNext.setText("»");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        descri.setEditable(false);
        jScrollPane1.setViewportView(descri);

        btnPrevious.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnPrevious.setText("«");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnLike.setBackground(new java.awt.Color(102, 102, 102));
        btnLike.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        btnLike.setText("♥");
        btnLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLikeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(txtMatch))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnPrevious)
                        .addGap(18, 18, 18)
                        .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNext)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(txtUser))
                            .addComponent(txtName)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtBirthDate)
                                    .addGap(60, 60, 60))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCity)
                                        .addComponent(txtState))
                                    .addGap(82, 82, 82)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(btnLike)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(txtMatch)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(btnNext)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrevious)
                        .addGap(41, 41, 41)))
                .addComponent(txtUser)
                .addGap(18, 18, 18)
                .addComponent(txtName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBirthDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtState)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCity)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLike, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        try {
            matchs.next();
            setValues();

            if (matchs.isLast()) {
                btnNext.setEnabled(false);
            }

            btnPrevious.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(MatchPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MatchPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        try {
            matchs.previous();
            setValues();
            if (matchs.isFirst()) {
                btnPrevious.setEnabled(false);
            }
            btnNext.setEnabled(true);
        } catch (SQLException ex) {
            Logger.getLogger(MatchPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MatchPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLikeActionPerformed
        // TODO add your handling code here:
        String query;
        try {
            if (btnLike.getForeground() == Color.WHITE) {
                btnLike.setForeground(Color.RED);
                query = "INSERT INTO `like`(`userId`,`liked`) VALUES (" + userLogged.id + "," + matchs.getInt("matchId") + ")";
                db.insert(query);
            } else {
                btnLike.setForeground(Color.WHITE);
                query = "DELETE FROM `like` WHERE userId=" + userLogged.id + " AND liked=" + matchs.getInt("matchId");
                db.insert(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatchPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnLikeActionPerformed

    public void ResearchMatch() throws SQLException, IOException {

        String sql = "SELECT "
                + " userFav.id,userFav.userId,userFav.serieId,user2.id,user2.userId,user2.serieId, "
                + " round(100*(COUNT(user2.userId)/5),2) porcentagem , u.id as matchId,u.username,u.fullname,u.birth,"
                + "u.state,u.city,u.descri,u.profilePicture "
                + "FROM "
                + " favorites userFav "
                + "INNER JOIN "
                + " favorites user2 ON userFav.serieId = user2.serieId "
                + "INNER JOIN "
                + " user u ON user2.userId = u.id "
                + "WHERE "
                + " userFav.userId = " + userLogged.id + " AND user2.userId != userFav.userId "
                + "GROUP by "
                + " user2.userId "
                + "ORDER BY "
                + " porcentagem  Desc";
        System.out.println(sql);
        matchs = db.Select(sql);

        if (matchs.next()) {
            matchs.first();

            setValues();
            btnPrevious.setEnabled(false);
            if (matchs.isLast()) {
                btnNext.setEnabled(false);
            } else {
                btnNext.setEnabled(true);
            }
        }

    }
    //formata a imagem do banco de dados para a label

    public ImageIcon ResizeImage(InputStream pic) throws IOException {
        Image img = ImageIO.read(pic);
        img = img.getScaledInstance(profile.getWidth(), profile.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imgcon = new ImageIcon(img);
        profile.setIcon(imgcon);

        return imgcon;
    }

    //Determina os valores dos campos
    public void setValues() throws SQLException, IOException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        txtMatch.setText("MATCH: " + matchs.getString("porcentagem") + "%");
        txtUser.setText(matchs.getString("u.username"));
        txtName.setText(matchs.getString("u.fullname"));
        txtBirthDate.setText("Aniversario: " + df.format(matchs.getDate("u.birth")));
        txtState.setText("Estado: " + matchs.getString("u.state"));
        txtCity.setText("Cidade: " + matchs.getString("u.city"));
        descri.setText(matchs.getString("u.descri"));

        InputStream pic = matchs.getBinaryStream("profilePicture");
        profile.setIcon(ResizeImage(pic));

        String sql = "SELECT * FROM `like` INNER JOIN user ON `liked`=" + matchs.getInt("matchId") + " WHERE userId=" + userLogged.id;
        System.out.println(sql);
        ResultSet likes = db.Select(sql);
        if (likes.first()) {
            btnLike.setForeground(Color.RED);
        } else {
            btnLike.setForeground(Color.WHITE);
        }
    }

    ResultSet matchs = null;
    User userLogged = null;
    Database db = new Database();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLike;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JTextPane descri;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel txtBirthDate;
    private javax.swing.JLabel txtCity;
    private javax.swing.JLabel txtMatch;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtState;
    private javax.swing.JLabel txtUser;
    // End of variables declaration//GEN-END:variables
}
