import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// public class Main {                 //4.1
//     public static void main(String[] args) {
//         JFrame f = new JFrame();
//         JLabel lab = new JLabel("Я метка 1");
//         f.setSize(300,200);
//         f.add(lab);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }


// public class Main {                 //4.1
//     public static void main(String[] args) {
//         JFrame f = new JFrame();
//         JPanel p = new JPanel();
//         p.add(new JLabel("Метка 1"));
//         p.add(new JLabel("Метка 2"));
//         p.add(new JLabel("Метка 3"));
//         p.add(new JLabel("Метка 4"));
//         p.add(new JButton("Кнопка 1"));
//         f.add(p);
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }


// public class Main {            //4.2
//     public static void main (String[] args) {
//         JFrame f = new JFrame();
//         JPanel p = new JPanel();
//         for (int i = 1; i <= 9; i++) {
//             p.add(new JButton("Кнопка " + i));
//         }
//         f.add(p);
//         f.setSize(300,200);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.setVisible(true);
//     }
// }


public class CountdownButton {  //4
    public static void main(String[] args) {
        //Создание окна
        JFrame frame = new JFrame("Countdown Button");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        //Инициализация кнопки с текстом 10

        JButton button = new JButton("10");
        panel.add(button);
        frame.add(panel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Получаем текущий текст кнопки
                String text = button.getText();
                int number = Integer.parseInt(text);

                if (number > 1) {
                    number--;
                    button.setText(String.valueOf(number));
                } else {
                    System.exit(0);
                }
            }
        });

        frame.setVisible(true);

    }
}