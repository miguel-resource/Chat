import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    private JLabel etiqueta;
    private JTextField tfNickname, tfCorreo;
    private JButton btnAceptar, btnCancelar;

    private JPanel panel, pnlBotones;

    private MenuInterface listener;

    public MenuPanel(){
        super.setLayout(new FlowLayout());

        ////////////COMPONENTES////////////////////
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));

        pnlBotones = new JPanel();
        pnlBotones.setLayout(new GridLayout(1,2,10,100));

        etiqueta = new JLabel("Nickname:");
        etiqueta.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
        panel.add(etiqueta);

        tfNickname = new JTextField();
        tfNickname.setHorizontalAlignment(JTextField.CENTER);
        tfNickname.setFont(new Font("Fira Code Light", Font.PLAIN, 15));
        panel.add(tfNickname);

        etiqueta = new JLabel("Correo electrónico:");
        etiqueta.setFont(new Font("Fira Code Light", Font.PLAIN, 14));
        panel.add(etiqueta);

        tfCorreo = new JTextField();
        tfCorreo.setHorizontalAlignment(JTextField.CENTER);
        tfNickname.setFont(new Font("Fira Code Light", Font.PLAIN, 15));
        panel.add(tfCorreo);

        btnAceptar = new JButton("Conectar");
        btnAceptar.setFont(new Font("Fira Code Light", Font.PLAIN, 11));
        pnlBotones.add(btnAceptar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Fira Code Light", Font.PLAIN, 11));
        pnlBotones.add(btnCancelar);

        //ACCIONES DE LOS BOTONES
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.conectar();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.cancelar();
            }
        });

        super.add(panel);
        super.add(pnlBotones);
        super.setVisible(true);
    }

    public void setListener(MenuInterface listener) {
        this.listener = listener;
    }

    public String getTfNickname() {
        return tfNickname.getText();
    }

    public String getTfCorreo() {
        return tfCorreo.getText();
    }
}
