/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author yasmi
 */
public class Database {
    private static Connection con;
    //variaves 
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String pass="";
    private static final String url="jdbc:mysql://localhost:3306/seriesheart";

    public Database() {
        conector();
    }
    
    public void conector() {
        // Reseteamos a null la conexion a la bd
        con=null;
        try{
            Class.forName(driver);
            // Conectando ao banco de dados
            con= (Connection) DriverManager.getConnection(url, user, pass);
            // Se a conexão der certo
            if (con!=null){
                System.out.println("Conexão establecida");
            }
        }
        // Se a conexão nao der certo
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Erro de conexão" + e);
        }
    }
    
    public void insert(String sql) throws SQLException{
            PreparedStatement stmt = null;
        
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
    }
    
    public void insertUser(User newUser) throws SQLException, FileNotFoundException{
        
        PreparedStatement stmt = con.prepareStatement("INSERT INTO user (`username`, `fullname`, `uPassword`, `birth`, `state`, `city`, `descri`,profilePicture,email) "
               + "VALUES ( ?,?,?,?,?,?,?,?,? )");
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        stmt.setString(1, newUser.username);
        stmt.setString(2, newUser.fullName);
        stmt.setString(3, newUser.password);
        stmt.setString(4, format.format(newUser.birth));
        stmt.setString(5, newUser.state);
        stmt.setString(6, newUser.city); 
        stmt.setString(7, newUser.descri); 
        stmt.setBlob(8,newUser.picture);
        stmt.setString(9,newUser.email);
        
        stmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Você foi cadastrado com sucesso!\nO próximo passo é escolher suas 5 séries favoritas");
    }
    
    public void UpdateUser(User userLogged) throws SQLException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

       /*String sql ="UPDATE user set `username`='"+userLogged.username+
                 "', `fullname` = '"+userLogged.fullName+"', `uPassword` = '"+userLogged.password+"', `birth` = '"+
                 format.format(userLogged.birth)+"', `state` = '"+userLogged.state+"', `city` = '"+userLogged.city+
                 "', `descri` = '" +userLogged.descri + "' profilePicture = ? WHERE id = "+userLogged.id;
         
        */
       String sql ="UPDATE user set `username` = ? ,`fullname` = ?, `uPassword`= ? , `birth` = ?,"
               + " `state` = ?, `city` = ?, `descri` = ? ,profilePicture = ? , email = ? WHERE id = ?" ;
       System.out.println(sql);
       PreparedStatement stmt = con.prepareStatement(sql);
               
        
        
        stmt.setString(1, userLogged.username);
        stmt.setString(2, userLogged.fullName);
        stmt.setString(3, userLogged.password);
        stmt.setString(4, format.format(userLogged.birth));
        stmt.setString(5, userLogged.state);
        stmt.setString(6, userLogged.city); 
        stmt.setString(7, userLogged.descri); 
        stmt.setBlob(8,userLogged.picture);
        stmt.setString(9, userLogged.email);
        stmt.setInt(10, userLogged.id); 

         System.out.println(stmt.toString());

        stmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Salvo");
    }
    
    public void UpdateUserNoPic(User userLogged) throws SQLException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

       /*String sql ="UPDATE user set `username`='"+userLogged.username+
                 "', `fullname` = '"+userLogged.fullName+"', `uPassword` = '"+userLogged.password+"', `birth` = '"+
                 format.format(userLogged.birth)+"', `state` = '"+userLogged.state+"', `city` = '"+userLogged.city+
                 "', `descri` = '" +userLogged.descri + "' profilePicture = ? WHERE id = "+userLogged.id;
         
        */
       String sql ="UPDATE user set `username` = ? ,`fullname` = ?, `uPassword`= ? , `birth` = ?,"
               + " `state` = ?, `city` = ?, `descri` = ?, email = ?  WHERE id = ?" ;
       System.out.println(sql);
       PreparedStatement stmt = con.prepareStatement(sql);
               
        
        
        stmt.setString(1, userLogged.username);
        stmt.setString(2, userLogged.fullName);
        stmt.setString(3, userLogged.password);
        stmt.setString(4, format.format(userLogged.birth));
        stmt.setString(5, userLogged.state);
        stmt.setString(6, userLogged.city); 
        stmt.setString(7, userLogged.descri); 
        stmt.setString(8, userLogged.email);
        stmt.setInt(9, userLogged.id); 
         System.out.println(stmt.toString());

        stmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Salvo");
    }
    
    public ResultSet Select(String query) throws SQLException{
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet table = null;
        table = stmt.executeQuery();
        
        return table;
    }
    
    public void Update(String sql) throws SQLException{
        PreparedStatement stmt = null;
        
        stmt = con.prepareStatement(sql);
        stmt.executeUpdate();
    }
}
