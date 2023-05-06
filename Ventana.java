import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Ventana extends JFrame {
    private JPanel panel1;
    private JButton botonPanel1;
    private JLabel etiquetaPanel1;
    private JPanel panel2;
    private JLabel etiquetapanel2;
    private JPanel panel3;
    private JComboBox<String> ComboBoxpanel3;
    private JPanel panel4;
    private GridLayout layout;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(800 , 600);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);

        //1
      panel1 = new JPanel();
      panel1.setBackground(Color.CYAN);
      panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
      botonPanel1 = new JButton("PRESIONAME!!!");
      panel1.add(botonPanel1);
      etiquetaPanel1 = new JLabel(".....");
      panel1.add(etiquetaPanel1);
      botonPanel1.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
              etiquetaPanel1.setText("HOLA presionaste el boton del panel 1... !!");
          }
      });

      this.getContentPane().add(panel1,0);

        //2
        panel2 = new JPanel();
        String urlimagen = "https://freepngimg.com/thumb/java/85390-java-language-text-programming-logo-programmer-thumb.png";

        panel2.setBackground(Color.MAGENTA);
        panel2.setLayout(new FlowLayout());
        //Cargar la imagen de internet

        try {
            URL url = new URL(urlimagen);
            Image imagen = ImageIO.read(url);
            ImageIcon  imagenIcon = new ImageIcon(imagen);

            etiquetapanel2 = new JLabel(imagenIcon);
            panel2.add(etiquetapanel2);
            this.getContentPane().add(panel2,1);

        }catch (MalformedURLException me){
            System.out.println("URL no valida");
        }catch (Exception e){
            System.out.println("Error al cargar la imagen");
        }


        //3
        panel3 = new JPanel();
        panel3.setBackground(Color.green);
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        String[] elementos = {"opcion 1","opcion 2","opcion 3","opcion4"};
        ComboBoxpanel3 = new JComboBox<>(elementos);
        ComboBoxpanel3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource().toString());
                System.out.println(ComboBoxpanel3.getSelectedIndex());

            }
        });
        panel3.add(ComboBoxpanel3);
        this.getContentPane().add(panel3,2);

        //4
        panel4 = new JPanel();
        panel4.setBackground(Color.orange);
        this.getContentPane().add(panel4,3);



        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);

    }
}
