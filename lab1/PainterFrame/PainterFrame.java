package PainterFrame;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PainterFrame extends Frame {
    PainterFrame(String s){
        super(s);
    }
    public void paint(Graphics g) {
        g.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 30));
        g.drawString("Hello, XXI century world!", 20, 100);
    }

    public static void main(String[] args) {
        Frame frame = new PainterFrame("Painter frame");
        frame.setSize(1024,1024);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
    }
}
