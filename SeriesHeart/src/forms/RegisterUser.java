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
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author yasmi
 */
public class RegisterUser extends javax.swing.JPanel {

    /**
     * Creates new form RegisterUser
     */
    public RegisterUser() {
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

        ProfileLabel = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        UserPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ConfirmUserPassword = new javax.swing.JPasswordField();
        userBirthDate = new datechooser.beans.DateChooserCombo();
        jLabel4 = new javax.swing.JLabel();
        SelectPicture = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        picture = new javax.swing.JLabel();
        txtState = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescr = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();

        ProfileLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ProfileLabel.setText("Seu Perfil");

        jLabel7.setText("Cidade:");

        jLabel2.setText("Username:");

        jLabel8.setText("Estado:");

        jLabel3.setText("Senha:");

        jLabel9.setText("Descrição:");

        userBirthDate.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12),
                    new java.awt.Color(187, 187, 187),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    userBirthDate.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
        public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
            userBirthDateOnSelectionChange(evt);
        }
    });

    jLabel4.setText("Confirmar senha:");

    SelectPicture.setText("selecionar foto de perfil");
    SelectPicture.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            SelectPictureActionPerformed(evt);
        }
    });

    jLabel5.setText("Nome:");

    picture.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

    txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusLost(java.awt.event.FocusEvent evt) {
            txtUsernameFocusLost(evt);
        }
    });

    jLabel6.setText("Nascimento:");

    txtDescr.setColumns(20);
    txtDescr.setRows(5);
    jScrollPane1.setViewportView(txtDescr);

    jLabel1.setText("Email:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SelectPicture)
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ProfileLabel)
                        .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(139, 139, 139))
        .addGroup(layout.createSequentialGroup()
            .addGap(9, 9, 9)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel1)
                .addComponent(jLabel3)
                .addComponent(jLabel2)
                .addComponent(jLabel8)
                .addComponent(jLabel9)
                .addComponent(jLabel5)
                .addComponent(jLabel4)
                .addComponent(jLabel6)
                .addComponent(jLabel7))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(txtUsername)
                .addComponent(UserPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addComponent(ConfirmUserPassword)
                .addComponent(txtFullName, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(txtCity, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(txtState)
                .addComponent(jScrollPane1)
                .addComponent(userBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtEmail))
            .addContainerGap(59, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(7, 7, 7)
            .addComponent(ProfileLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(picture, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(SelectPicture)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(UserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ConfirmUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel6)
                .addComponent(userBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(12, 12, 12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7)
                .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8)
                .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(46, 46, 46))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void SelectPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectPictureActionPerformed
        imgPath = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            picture.setIcon(ResizeImage(path));
            imgPath = path;
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Data");
        }

    }//GEN-LAST:event_SelectPictureActionPerformed

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        UsernameAvailable();
    }//GEN-LAST:event_txtUsernameFocusLost

    private void userBirthDateOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_userBirthDateOnSelectionChange
        System.out.println(userBirthDate.getSelectedDate().getTime());
    }//GEN-LAST:event_userBirthDateOnSelectionChange
    //Edita as informações do usuário

    public void editProfile() throws FileNotFoundException, SQLException, IOException {
        InputStream pic = userLogged.picture;
        if (UsernameAvailable()) {
            if (UserPassword.getText() == null ? ConfirmUserPassword.getText() == null : UserPassword.getText().equals(ConfirmUserPassword.getText())) {
                if (FormReadyToUpdate()) {
                    userLogged = new User(
                            userLogged.id,
                            txtUsername.getText(),
                            UserPassword.getText(),
                            txtEmail.getText(),
                            txtFullName.getText(),
                            userBirthDate.getSelectedDate().getTime(),
                            txtDescr.getText(),
                            txtCity.getText(),
                            txtState.getText(),
                            pic
                    );
                    if (!(imgPath == "")) {
                        userLogged.picture = new FileInputStream(new File(imgPath));
                        db.UpdateUser(userLogged);
                    } else {
                        db.UpdateUserNoPic(userLogged);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!\nA senha e o nome de usuário devem ter pelo menos 6 carateres.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "As senhas não conferem!");
            }
        }
    }

    public boolean FormReadyToInsert() {
        boolean b = false;
        /*System.out.println("IMG:    " + imgPath);
        System.out.println(txtUsername.getText().length() > 5);
        System.out.println(UserPassword.getText().length() > 5);
        System.out.println(txtFullName.getText().length() > 1);
        System.out.println(txtDescr.getText().length() > 1);
        System.out.println(txtCity.getText().length() > 1);
        System.out.println(txtState.getText().length() > 1);
        System.out.println(txtEmail.getText().length() > 5);
        System.out.println(imgPath != "");*/
        if (txtUsername.getText().length() > 5 && UserPassword.getText().length() > 5 && txtFullName.getText().length() > 1
                && txtDescr.getText().length() > 1 && txtCity.getText().length() > 1 && txtState.getText().length() > 1
                && txtEmail.getText().length() > 5) {
            if (imgPath != "") {
                b = true;
            }

        }
        return b;
    }

    public boolean FormReadyToUpdate() {
        boolean b = false;
        if (txtUsername.getText().length() > 5 && UserPassword.getText().length() > 5 && txtFullName.getText().length() > 1
                && txtDescr.getText().length() > 1 && txtCity.getText().length() > 1 && txtState.getText().length() > 1
                && txtEmail.getText().length() > 5) {
            b = true;
        }
        return b;
    }

    //Adiciona usuario no banco de dados
    public boolean RegisterNewUser() {
        boolean bool = true;
        if (UsernameAvailable()) {
            if (UserPassword.getText() == null ? ConfirmUserPassword.getText() == null : UserPassword.getText().equals(ConfirmUserPassword.getText())) {
                if (FormReadyToInsert()) {
                    User newUser = new User(txtUsername.getText(), UserPassword.getText(), txtEmail.getText(), txtFullName.getText(), userBirthDate.getSelectedDate().getTime(), txtDescr.getText(), txtCity.getText(), txtState.getText());

                    Database db = new Database();

                    try {
                        newUser.picture = new FileInputStream(new File(imgPath));
                        db.insertUser(newUser);
                    } catch (SQLException ex) {
                        Logger.getLogger(RegisterUserPage.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(RegisterUserPage.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!\nA senha e o nome de usuário devem ter pelo menos 6 carateres.");
                    bool = false;
                    User newUser = new User(txtUsername.getText(), UserPassword.getText(), txtEmail.getText(), txtFullName.getText(), userBirthDate.getSelectedDate().getTime(), txtDescr.getText(), txtCity.getText(), txtState.getText());

                    newUser.printUser();
                }

            } else {
                JOptionPane.showMessageDialog(null, "As senhas não conferem!");
                bool = false;
            }
        }
        return bool;
    }

    public ImageIcon ResizeImage(InputStream pic) throws IOException {
        Image img = ImageIO.read(pic);
        img = img.getScaledInstance(picture.getWidth(), picture.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imgcon = new ImageIcon(img);
        // picture.setIcon(imgcon);

        return imgcon;
    }

    public ImageIcon ResizeImage(String imgPath) {
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(picture.getWidth(), picture.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

    //preenche os componentes com os dados do usuário
    public void setUserProfile() throws IOException, SQLException {
        if (userLogged != null) {
            System.out.println(userLogged.id);
            ResultSet rs = db.Select("SELECT * FROM user WHERE id=" + userLogged.id);
            if (rs.next()) {
                userLogged = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("uPassword"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getDate("birth"),
                        rs.getString("descri"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getBinaryStream("profilePicture")
                );

                txtUsername.setText(userLogged.username);
                UserPassword.setText(userLogged.password);
                ConfirmUserPassword.setText(userLogged.password);
                txtEmail.setText(userLogged.email);
                txtFullName.setText(userLogged.fullName);
                Calendar c = Calendar.getInstance();
                c.setTime(userLogged.birth);
                userBirthDate.setSelectedDate(c);
                txtCity.setText(userLogged.city);
                txtState.setText(userLogged.state);
                txtDescr.setText(userLogged.descri);

                picture.setIcon(ResizeImage(userLogged.picture));

            }
        }
    }

    @SuppressWarnings("empty-statement")
    public boolean UsernameAvailable() {
        boolean b = true;
        try {
            System.out.println("SELECT 1 FROM user WHERE username='" + txtUsername.getText() + "'");
            ResultSet rs = db.Select("SELECT 1 FROM user WHERE username='" + txtUsername.getText() + "'");

            //System.out.println(userLogged.username + txtUsername.getText());
            if (rs.next()) {
                // if (userLogged.username == null ? txtUsername.getText() != null : !userLogged.username.equals(txtUsername.getText())) {
                if (userLogged == null) {
                    JOptionPane.showMessageDialog(null, "nome de usuário indisponivel");
                    b = false;
                } else if (userLogged.username == null ? txtUsername.getText() != null : !userLogged.username.equals(txtUsername.getText())) {
                    System.out.println(userLogged.username);
                    System.out.println(txtUsername.getText());
                    JOptionPane.showMessageDialog(null, "nome de usuário indisponivel");
                    b = false;
                    txtUsername.setText(userLogged.username);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        };
        return b;
    }

    Database db = new Database();
    User userLogged = null;
    String imgPath = "";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ConfirmUserPassword;
    private javax.swing.JLabel ProfileLabel;
    private javax.swing.JButton SelectPicture;
    private javax.swing.JPasswordField UserPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel picture;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextArea txtDescr;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtUsername;
    private datechooser.beans.DateChooserCombo userBirthDate;
    // End of variables declaration//GEN-END:variables
}