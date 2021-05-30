package Connection;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.util.Observable;

public class Server extends Observable implements Runnable {

    private int puerto;

    public Server(int puerto){
        this.puerto = puerto;
    }

    @Override
    public void run() {
        ServerSocket server = null;
        Socket socket = null;
        DataInputStream input;
        DataOutputStream output;

        try {
            server = new ServerSocket(puerto);
            System.out.println("Servidor iniciado...");



            while (true){ //Servidor siempre escuchando
                socket   = server.accept();

                System.out.println("Cliente conectado");
                input = new DataInputStream(socket.getInputStream());

                String mensaje = input.readUTF();
                System.out.println(mensaje);

                //Observable
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();

                socket.close();
                System.out.println("Cliente desconectado...");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
