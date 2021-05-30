import javax.swing.*;

public class PrincipalFrame1 extends JFrame {

    private MenuPanel pnlMenu;
    private ChatFrame1 chatFrame;

    public PrincipalFrame1(){
        super("Cuenta");
        super.setDefaultCloseOperation(3);
        super.setSize(280, 180);

        pnlMenu = new MenuPanel();
        super.add(pnlMenu);

        pnlMenu.setListener(new MenuInterface() {
            @Override
            public void conectar() {
                if (pnlMenu.getTfNickname().equals("") || pnlMenu.getTfCorreo().equals("")){
                    JOptionPane.showMessageDialog(null, "Ingrese correctamente todos los datos");
                }else{
                    System.out.println("Entro");

                    chatFrame = new ChatFrame1(pnlMenu.getTfNickname());

                    PrincipalFrame1.super.setVisible(false);
                    chatFrame.setVisible(true);
                }
            }

            @Override
            public void cancelar() {
                System.exit(0);
            }
        });

        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new PrincipalFrame1();
    }

    public String getNickname(){
        return pnlMenu.getTfNickname();
    }
}
