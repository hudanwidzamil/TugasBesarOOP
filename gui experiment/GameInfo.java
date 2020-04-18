import java.awt.*;
import javax.swing.*;

/**
 * GameInfo
 */
public class GameInfo extends JPanel{
    JLabel sunflower;
    int sfpts;
    public GameInfo(){
        sfpts = 0;
        sunflower = new JLabel(Integer.toString(sfpts));
        add(new JLabel(new ImageIcon("images\\sun.png")));
        add(sunflower);
        setPreferredSize(new Dimension(100,100));
        setOpaque(false);
    }
    
}