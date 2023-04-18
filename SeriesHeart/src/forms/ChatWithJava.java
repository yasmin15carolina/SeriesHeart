/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import static javax.swing.JOptionPane.*;

/**
 *
 * @author yasmi
 */
public class ChatWithJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String name = showInputDialog(null, "Digite o seu nome", "", PLAIN_MESSAGE);

        Chat chat = new Chat(name);
        chat.setVisible(true);
        chat.show();
    }

}
