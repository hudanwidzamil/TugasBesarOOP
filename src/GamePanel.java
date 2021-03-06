import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * GamePanel
 * @author Muhamad Hudan Widzamil 18218003
 */
public class GamePanel extends JPanel {
    public class PlantButton extends JButton{
        Point p;
        String type;
        boolean transparent;
        
        public PlantButton(int x, int y){
            super();
            p = new Point(x, y);
            this.type = "none";
            transparent = false;
            transparencySwitch();
            addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                        changeButton();
                }
            });
        }
        public PlantButton(int x, int y, String type){
            super(type);
            p = new Point(x, y);
            this.type = type;
            transparent = false;
            transparencySwitch();
            addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                        changeButton();
                }
            });
        } 
        public void transparencySwitch() {
            setFocusPainted(transparent);
            setBorderPainted(transparent);
            setContentAreaFilled(transparent);
            setOpaque(transparent);
            transparent = ! transparent;
        }

        public void changeButton(){
            this.type = onSelect;
            if (type.equals("P")) {
                setIcon(new ImageIcon("..\\images\\plants\\peashooter_small.gif"));    
            } else if(type.equals("F")) {
                setIcon(new ImageIcon("..\\images\\plants\\Fume-shroom_small.png"));
            }else{
                // type.equals("none")
                setIcon(null);
            }
            selectedPos = p;
            
            gridTransparency();
        }
    }
    List<PlantButton> grid;
    String onSelect;
    Point selectedPos;

    public GamePanel(){
        this.grid = new ArrayList<PlantButton>();
        setLayout(new GridLayout(4, 9));
        setPreferredSize(new Dimension(720,320));
        setOpaque(false);

        PlantButton temp;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 9; x++) {
                temp = new PlantButton(x,y);
                grid.add(temp);
                this.add(temp);
            }
        }
        
    }

    public void gridTransparency(){
        for (PlantButton button : grid) {
            button.transparencySwitch();
        }
    }
}