package StickmanDraw;
import java.awt.*;
import java.awt.event.*;

public class Stickman extends Frame{
    Stickman(String s){
        super(s);
        setBounds(0,0,500,300);
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 30));
    
        int x = getWidth() / 2 - 50; 
        int y = getHeight() / 2 - 110;
        g.drawOval(x, y, 100, 100);  // Голова
    
        g.drawLine(x + 50, y + 100, x + 50, y + 200);  // Тело
    
        g.drawLine(x, y + 120, x + 100, y + 120);  // Левая рука
        g.drawLine(x + 50, y + 120, x + 50, y + 180); // Правая рука
        
        g.drawLine(x + 50, y + 200, x, y + 250);  // Левая нога
        g.drawLine(x + 50, y + 200, x + 100, y + 250);  // Правая нога
    }

    public static void main(String[] args){
        Stickman stickman = new Stickman("Stickman");
        stickman.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent ev) {
                    System.exit(0);
                }
            }
        );
        stickman.repaint();
    }
}
