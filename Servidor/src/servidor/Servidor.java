package servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;

public class Servidor {

    public static void main(String[] args) {
        String receivedMessage;

        ArrayList<PrintStream> clientes = new ArrayList();

        try {
            ServerSocket server = new ServerSocket(5000);
            Socket socket;

            while (true) {
                socket = server.accept();
                //guarda o endereço do cliente
                clientes.add(new PrintStream(socket.getOutputStream()));
                Mensagem message = new Mensagem(socket, clientes);

                /* System.out.println("Connected");
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(isr);

                while ((receivedMessage = br.readLine()) != null) {

                    System.out.println(receivedMessage);

                };*/
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
