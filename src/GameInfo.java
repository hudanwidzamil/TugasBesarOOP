import java.awt.*;
import javax.swing.*;
import java.util.Random;
/**
 * GameInfo
 * @author Muhamad Hudan Widzamil 18218003
 */
public class GameInfo extends JPanel implements Runnable{
    JLabel sunflower;
    Integer sfpts;
    JLabel message;

    Random addsf = new Random();

    public GameInfo(){
        sfpts = 100;
        sunflower = new JLabel("     "+Integer.toString(sfpts));
        sunflower.setForeground(Color.WHITE);
        message = new JLabel(" ");
        message.setForeground(Color.WHITE);
        add(new JLabel(new ImageIcon("..\\images\\sun.png")));
        add(sunflower);
        add(message);
        setPreferredSize(new Dimension(800,100));
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        setOpaque(false);
    }
    public void run() {
        int addedsf;
        while (true) {
            try{
                Thread.sleep(2500);
                addedsf=addsf.nextInt((100 - 25) + 1) + 25;  
                sfpts+=addedsf;
                sunflower.setText("     "+Integer.toString(sfpts));
                message.setText("                      Ditambahkan "+Integer.toString(addedsf)+" sunflower points");
                Thread.sleep(500);
                message.setText(" ");
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
             
        }
        
    }
    
}