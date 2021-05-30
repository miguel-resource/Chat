package Connection;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable{

    private int puerto;
    private String msg;

    public Client(int puerto, String msg){
        this.puerto = puerto;
        this.msg = msg;
    }

    @Override
    public void run() {
        final String HOST =  "127.0.0.1";


        DataInputStream input;
        DataOutputStream output;

        try {
            Socket socket = new Socket(HOST, puerto);

            output = new DataOutputStream(socket.getOutputStream());

            output.writeUTF(msg);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
