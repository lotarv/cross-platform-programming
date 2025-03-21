import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingApp extends JFrame {
    private ArrayList<Color> lineColors = new ArrayList<>();
    private Color currentColor = Color.BLACK;
    private ArrayList<ArrayList<Point>> lines = new ArrayList<>();
    private ArrayList<Point> currentLine; // Текущая линия
    private JPanel canvas;

    public DrawingApp() {
        setTitle("Painter");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Панель для выбора цвета
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        
        String[] colorsRus = {"Черный", "Красный", "Зеленый", "Синий"};
        String[] colorsEng = {"Black", "Red", "Green", "Blue"};
        for (int i = 0; i < colorsEng.length; i++) {
            JButton button = new JButton(colorsRus[i]);
            button.addActionListener(new ColorButtonListener(colorsEng[i]));
            buttonPanel.add(button);
        }

        //Кнопка для очистки холста

        JButton clearButton = new JButton("Очистить");

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lines.clear();
                lineColors.clear();
                canvas.repaint();
            }
        });

        buttonPanel.add(clearButton);

        //Создание холста
        canvas = new DrawingCanvas();
        canvas.setBackground(Color.WHITE);

        //Обработка событий мыши
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentLine = new ArrayList<>();
                currentLine.add(e.getPoint());   
                lines.add(currentLine);          
                lineColors.add(currentColor);    
            }
        });

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentLine != null) {
                    currentLine.add(e.getPoint()); // Добавляем точку в текущую линию
                    canvas.repaint(); // Перерисовываем холст
                }
            }
        });

        // Компоновка окна
        add(buttonPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

    }

    public class ColorButtonListener implements ActionListener{
        private String colorName;
    
        public ColorButtonListener(String colorName) {
            this.colorName = colorName;
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (colorName) {
                case "Black": currentColor = Color.BLACK; break;
                case "Red": currentColor = Color.RED; break;
                case "Green": currentColor = Color.GREEN; break;
                case "Blue": currentColor = Color.BLUE; break;
            }
        }
    }

    public class DrawingCanvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for (int i = 0; i < lines.size(); i++) {
                ArrayList<Point> line = lines.get(i);  // Берем линию
                Color color = lineColors.get(i);       // Берем её цвет
                g2d.setColor(color);                   // Устанавливаем цвет для этой линии
                for (int j = 0; j < line.size() - 1; j++) {
                    Point p1 = line.get(j);
                    Point p2 = line.get(j + 1);
                    g2d.drawLine(p1.x, p1.y, p2.x, p2.y); // Рисуем сегменты линии
                }
            }

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawingApp app = new DrawingApp();
            app.setVisible(true);
        });
    }
}