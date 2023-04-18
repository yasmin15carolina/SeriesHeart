/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yasmi
 */
public class Mensagem {

    private Socket s;
    private ArrayList<PrintStream> clientes;

    public void setClientes(ArrayList<PrintStream> clientes) {
        this.clientes = clientes;
    }

    public Mensagem(Socket s, ArrayList<PrintStream> clientes) {
        this.s = s;
        this.clientes = clientes;

        Thraed();
    }

    private void Thraed() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String message = "";

                try {
                    InputStreamReader isr = new InputStreamReader(s.getInputStream());
                    BufferedReader br = new BufferedReader(isr);

                    while ((message = br.readLine()) != null) {

                        System.out.println(message);

                        sendMessage(message);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Mensagem.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        t.start();
    }

    private void sendMessage(String message) {
        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i).println(message);
            clientes.get(i).flush();
        }
    }
}