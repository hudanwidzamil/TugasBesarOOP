import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * PlantSelector
 * @author Muhamad Hudan Widzamil 18218003
 */
public class PlantSelector extends JPanel{
    JButton peashooter;
    JButton fumeshroom;
    JButton shovel;
    
    public PlantSelector(GamePanel gpanel){
        Icon psIcon = new ImageIcon("..\\images\\cards\\card_peashooter.png");
        Icon fsIcon = new ImageIcon("..\\images\\cards\\card_fumeshroom.png");
        Icon shIcon = new ImageIcon("..\\images\\cards\\card_shovel.jpg");
        peashooter = new JButton(psIcon);
        fumeshroom = new JButton(fsIcon);
        shovel = new JButton(shIcon);

        showCardOnly(peashooter);
        showCardOnly(fumeshroom);
        showCardOnly(shovel);

        add(peashooter);
        add(fumeshroom);
        add(shovel);

        peashooter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    gpanel.gridTransparency();
                    gpanel.onSelect = "P";
            }
        });
        fumeshroom.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    gpanel.gridTransparency();
                    gpanel.onSelect = "F";
            }
        });

        shovel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    gpanel.gridTransparency();
                    gpanel.onSelect = "none";
            }
        });
        // setPreferredSize(new Dimension(180,180));
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        setOpaque(false);
    }
    public void showCardOnly(JButton button){
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
    }
    
}