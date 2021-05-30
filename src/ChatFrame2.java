import Connection.Client;
import Connection.Server;
import ds.desktop.notify.DesktopNotify;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

public class ChatFrame2 extends JFrame implements Observer {

    private JTextArea jTextArea;
    private JTextField jTextField;
    private JButton btnEnviar;
    private JScrollPane jScrollPane;
    private JPanel panel;

    private Server server;

    private Thread thread;
    private LocalDateTime localTime;

    public ChatFrame2(String nickname){
        super("WhatsCloneXD");
        super.setDefaultCloseOperation(3);
        super.setSize(480, 380);
        super.setLayout(new FlowLayout());

        //////////////COMPONENTES/////////////////////
        jScrollPane = new JScrollPane();
        panel = new JPanel();
        panel.setLayout(new GridLayout(1,3,10,0));

        jTextArea = new JTextArea();
        jTextArea.setColumns(40);
        jTextArea.setRows(20);
        jScrollPane.setViewportView(jTextArea);
        jTextArea.setBackground(new Color(252,196,196));
        super.add(jTextArea);

        jTextField = new JTextField();
        jTextField.setColumns(22);

        super.add(jTextField);

        btnEnviar = new JButton("Enviar");
        btnEnviar.setFont(new Font("Fira Code Light", Font.PLAIN, 12));
        super.add(btnEnviar);

        /////////SERVER//////////
        server = new Server(6000);
        server.addObserver(this);
        thread = new Thread(server);
        thread.start();


        //////Acciones////
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Envio algo el chat#2");

                localTime = LocalDateTime.now();
                String horas = String.valueOf(localTime.getHour());
                String minutos = String.valueOf(localTime.getMinute());


                String mensaje = "["+nickname+"] "+horas+":"+minutos+" : "+
                        jTextField.getText() + "\n";

                jTextField.setText("");


                jTextArea.append(mensaje);

                Client cliente = new Client(5000, mensaje);
                Thread thread = new Thread(cliente);
                thread.start();
            }
        });

        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(false);
        super.add(panel);
    }

    @Override
    public void update(Observable observable, Object o) {
        jTextArea.append((String) o);
    }
}
