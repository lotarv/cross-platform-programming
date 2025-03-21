package GraphicsIntro;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class GraphIntro extends Frame {
    GraphIntro(String s){
        super(s);
        setBounds(0,0,500,300);
        setVisible(true);
    }
    public void paint(Graphics g){
        Dimension d = getSize(); 
        int dx = d.width / 20, dy = d.height / 20; 
        int myWidth = 250, myHeight = 250; 
        g.drawLine(0, 0, myWidth, myHeight); 
        g.drawLine(0, 0, d.width, d.height); 
        setBackground(Color.blue); 
        setForeground(Color.red); 
    }

    public static void main(String[] args){
        Frame graph = new GraphIntro("Drawing");
        graph.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });

        graph.repaint();
        
    }
}
