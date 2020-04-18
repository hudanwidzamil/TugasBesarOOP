import java.awt.*;
import javax.swing.*;


/**
 * GameFrame
 */
public class GameFrame extends JFrame {
    JPanel panel;
    GamePanel gpanel;
    GameInfo ginfo;
    PlantSelector pstor;
    
    public GameFrame(){
        super("(not)Plant vs Zombies");
        
        
        panel = new JPanel();
        gpanel = new GamePanel();
        ginfo = new GameInfo();
        pstor = new PlantSelector(gpanel);
        
        panel.add(ginfo);
        panel.add(gpanel);
        panel.add(pstor);

        JLabel background = new JLabel(new ImageIcon("images\\mainBG.png"), JLabel.CENTER);
        panel.add(background);

        panel.setLayout(null);
        panel.setSize(800, 600);
        background.setBounds(0, 0, 800, 600);
        ginfo.setBounds(0, 0, 100, 100);
        gpanel.setBounds(80, 100, 720, 320);
        pstor.setBounds(250,400,500,200);

        add(panel);
        setSize(800, 600);   
        setVisible(true);
        setResizable(false);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
     
    }
 
    public static void main(String[] args)  {
        new GameFrame();
    }
    
}