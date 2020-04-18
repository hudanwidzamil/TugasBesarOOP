import java.awt.*;
import javax.swing.*;

/**
 * GameInfo
 */
public class GameInfo extends JPanel implements Runnable{
    JLabel sunflower;
    int sfpts;
    public GameInfo(){
        sfpts = 0;
        sunflower = new JLabel(Integer.toString(sfpts));
        sunflower.setForeground(Color.WHITE);
        add(new JLabel(new ImageIcon("images\\sun.png")));
        add(sunflower);
        setPreferredSize(new Dimension(100,100));
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        setOpaque(false);
    }
    public void run() {
        while (true) {
            try{
                Thread.sleep(3000);
                sfpts+=10;  
                sunflower.setText(Integer.toString(sfpts));
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
             
        }
        
    }
    
}