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

        this.add(panel);
        this.setSize(800, 600);
        
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
     
    }
 
    public static void main(String[] args) {
        new GameFrame();
    }
    
}