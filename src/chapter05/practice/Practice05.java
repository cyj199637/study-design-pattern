package chapter05.practice;

import javax.swing.*;
import java.awt.*;

public class Practice05 {
    public static void main(String[] args) {
        new Running();
    }
}

class Running extends JFrame {
    private Field05 field;

    public Running() {
        super("Running");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        field = new Field05();

        add(field, BorderLayout.CENTER);

        setSize(500, 500);
        setVisible(true);

        Thread th = new Thread(field);
        th.start();
    }
}

class Field05 extends JPanel implements Runnable {
    private JLabel lbl;
    private String[] walkingImage = {"walk1.gif", "walk2.git"};

    public Field05() {
        setLayout(new BorderLayout());
        lbl = new JLabel();
        lbl.setIcon(new ImageIcon("./src/walk1.gif"));
        add(lbl, BorderLayout.CENTER);
    }

    public void run() {
        while (true) {
            String[] path = walkingImage;
            for (int i = 0; i < path.length; i++) {
                lbl.setIcon(new ImageIcon("./src/" + path[i]));
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
