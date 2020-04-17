import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * PlantSelector
 */
public class PlantSelector extends JPanel{
    JButton peashooter;
    JButton fumeshroom;
    
    public PlantSelector(GamePanel gpanel){
        Icon psIcon = new ImageIcon("images\\cards\\card_peashooter.png");
        Icon fsIcon = new ImageIcon("images\\cards\\card_freezepeashooter.png");
        peashooter = new JButton(psIcon);
        fumeshroom = new JButton(fsIcon);
        
        peashooter.setFocusPainted(false);
        peashooter.setBorderPainted(false);
        peashooter.setContentAreaFilled(false);
        peashooter.setOpaque(false);

        fumeshroom.setFocusPainted(false);
        fumeshroom.setBorderPainted(false);
        fumeshroom.setContentAreaFilled(false);
        fumeshroom.setOpaque(false);
        
        add(peashooter);
        add(fumeshroom);
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
        setPreferredSize(new Dimension(180,180));
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        
    }
    
    
}