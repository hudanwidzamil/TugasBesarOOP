import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * GamePanel
 */
public class GamePanel extends JPanel {
    public class PlantButton extends JButton{
        int x;
        int y;
        String type;
        boolean transparent;
        
        public PlantButton(int x, int y){
            super();
            this.x = x;
            this.y = y;
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
            this.x = x;
            this.y = y;
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
                super.setIcon(new ImageIcon("images\\plants\\peashooter_small.gif"));    
            } else if(type.equals("F")) {
                super.setIcon(new ImageIcon("images\\plants\\Fume-shroom_small.png"));
            }else{
                // type.equals("S")
                super.setIcon(null);
            }
            
            gridTransparency();
        }
    }
    List<PlantButton> grid;
    String onSelect;
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