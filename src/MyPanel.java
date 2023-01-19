import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;



public class MyPanel extends JPanel{
    private JButton l_btn = new JButton("Roll");
    private JButton a_btn = new JButton("Reset");

    private JLabel title = new JLabel("Dice Game !");
    private JLabel vs = new JLabel("VS");

    private JTextField textField1 = new JTextField("Score: 0");
    private JTextField textField2 = new JTextField("Score: 0");
    
    private JTextArea giocatore1 = new JTextArea("Player1");
    private JTextArea giocatore2 = new JTextArea("Player2");
    
    private final Font font = new Font("Broadway", Font.PLAIN, 15);
    private final Font font_label = new Font("Broadway", Font.PLAIN, 15);
    private final Font font_title = new Font("Broadway", Font.PLAIN, 70);
    private final Font font_vs = new Font("Broadway", Font.PLAIN, 50);
    

    private JLabel win_text = new JLabel();
    private JLabel p_dice = new JLabel();
    private JLabel c_dice = new JLabel();

    private ImageIcon image_icon_p = getNewImage(1);
    private ImageIcon image_icon_c = getNewImage(1);

    private int random_num_p = 0;
    private int random_num_c = 0;


    private int sum_p = 0;
    private int sum_c = 0;
    Random r = new Random();


    private final int ELEMENT_WIDTH = 100;
    private final int ELEMENT_HEIGHT = 20; 
    

    public MyPanel(){
        this.setupImage();
        this.setLayout(null);
        this.setBackground(Color.decode("#CCFF00"));
        this.setupTextFields();
        this.setupTextAreas();
        this.setupJLabel();
        this.setupButtons();
    }

    
    private void setupButtons() {
        a_btn.setBackground(Color.LIGHT_GRAY);
        l_btn.setBackground(Color.GREEN);
        a_btn.setFont(font);
        l_btn.setFont(font);

        this.add(a_btn);
        this.add(l_btn);
        

        a_btn.setBounds(205, 380, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        l_btn.setBounds(205, 360, ELEMENT_WIDTH, ELEMENT_HEIGHT);


        a_btn.addActionListener(evt -> resetGame());
        l_btn.addActionListener(e -> lancio());
    }

    private void resetGame() {
        textField1.setText("Punti: 0");
        textField2.setText("Punti: 0");
        sum_p = 0;
        sum_c = 0;
        win_text.setText("");
    }

    private void setupTextFields() {
        textField2.setEditable(false);
        textField2.setBounds(50, 380, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        textField2.setFont(font);

        textField1.setEditable(false);
        textField1.setBounds(350, 380, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        textField1.setFont(font);

        this.add(textField1);
        this.add(textField2);
    }

    private void setupTextAreas() {
        giocatore1.setBounds(50, 400, ELEMENT_WIDTH, ELEMENT_HEIGHT);
        giocatore2.setBounds(350, 400, ELEMENT_WIDTH, ELEMENT_HEIGHT);
       
        giocatore1.setFont(font);
        giocatore2.setFont(font);

        giocatore1.setBackground(Color.ORANGE);
        giocatore2.setBackground(Color.ORANGE);

        this.add(giocatore1);
        this.add(giocatore2);
    }

    public void setupJLabel() {

        title.setBounds(20, 30, 500, 100);
        title.setFont(font_title);
        this.add(title);

        vs.setBounds(215,170,500,100);
        vs.setFont(font_vs);
        this.add(vs);
        win_text.setBounds(205,300, 500,ELEMENT_HEIGHT);
        win_text.setFont(font_label);
        this.add(win_text);

    }

    private ImageIcon getNewImage(int points) {
        java.net.URL imageUrl = this.getClass().getResource("./assets/" + points +".png");
        return new ImageIcon(imageUrl);
    }

    public void setupImage() {
        
        p_dice.setIcon(image_icon_p);
        p_dice.setBounds(40, 150, 128, 128);
        c_dice.setIcon(image_icon_c);
        c_dice.setBounds(335, 150, 128, 128);

        this.add(c_dice);
        this.add(p_dice);
    }
    
    public void lancio(){
        random_num_p = r.nextInt(1,6);
        random_num_c = r.nextInt(1,6);
        this.win();

        textField2.setText("Punti: "+sum_p);
        image_icon_p = getNewImage(random_num_p);
        this.setupImage();

        textField1.setText("Punti: "+sum_c);
        image_icon_c = getNewImage(random_num_c);
        this.setupImage();
    }

    public void win(){
        if (random_num_c > random_num_p){
            sum_c+=1;
            win_text.setText(giocatore2.getText() + " Won!");
            //System.out.println("C win");

        }
        else if(random_num_c < random_num_p){
            sum_p+=1;
            win_text.setText(giocatore1.getText() + " Won!");
            //System.out.println("P win");

        }
        else{
            win_text.setText("       Draw!");

            //System.out.println("Pari");
        }
        
    }
}

