
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame<Image> extends JFrame{
    ImageIcon icon = new ImageIcon(getClass().getResource("./assets/icon.png"));


    public MyFrame(){

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setResizable(false);
        this.setTitle("Dice Game!");
        this.setIconImage(icon.getImage());
        this.add(new MyPanel());
        this.setVisible(true);
    }


}