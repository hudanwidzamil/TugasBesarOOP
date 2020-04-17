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
        add(new JLabel("SELECT"));
        peashooter = new JButton("Peashooter");
        fumeshroom = new JButton("Fumeshroom");
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
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
    }
    
    
}