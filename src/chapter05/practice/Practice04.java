package chapter05.practice;

import javax.swing.*;
import java.awt.*;

public class Practice04 {
    public static final int INIT_LOCATION[] = {50, 100, 150};
    public static void main(String[] args) {
        Ball[] balls = new Ball[3];
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball(INIT_LOCATION[i], INIT_LOCATION[i]);
            balls[i].setDirectionStrategy(new HorizonalMoveStrategy());
            balls[i].setDrawStrategy(new RedDrawStrategy());

            balls[i].start();
        }
        new BallFrame(balls);
    }
}

class BallFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;

    private Field field;

    public BallFrame(Ball[] balls) {
        super("Balls");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout((new BorderLayout()));

        field = new Field(balls);
        Thread th = new Thread(field);
        th.start();

        add(field, BorderLayout.CENTER);
        setVisible(true);
    }
}

class Field extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;

    private Ball[] balls;

    public Field(Ball[] balls) {
        this.balls = balls;
        setLayout(new FlowLayout());
    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, BallFrame.WIDTH, BallFrame.HEIGHT);
        for (int i = 0; i < balls.length; i++) {
            g.setColor(balls[i].getColor());
            g.fillOval(balls[i].getX(), balls[i].getY(), Ball.SIZE, Ball.SIZE);
        }
    }

    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Ball extends Thread {
    public static final int SIZE = 20;
    public static final int INTERVAL = 10;

    private int x, y;
    private int xInterval, yInterval;
    private DirectionStrategy directionStrategy;
    private DrawStrategy drawStrategy;
    private Color color;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.xInterval = this.yInterval = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXInterval() {
        return xInterval;
    }

    public int getYInterval() {
        return yInterval;
    }

    public Color getColor() {
        return color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setIntervals(int xInterval, int yInterval) {
        this.xInterval = xInterval;
        this.yInterval = yInterval;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setDirectionStrategy(DirectionStrategy directionStrategy) {
        this.directionStrategy = directionStrategy;
    }

    public void setDrawStrategy(DrawStrategy drawStrategy) {
        this.drawStrategy = drawStrategy;
    }

    public void draw() {
        drawStrategy.draw(this);
    }

    public void move() {
        directionStrategy.move(this);
    }

    public void run() {
        draw();
        move();
    }
}

abstract class DirectionStrategy {
    public abstract void move(Ball ball);
}

class HorizonalMoveStrategy extends DirectionStrategy {
    @Override
    public void move(Ball ball) {
        ball.setIntervals(Ball.INTERVAL, 0);
        while (true) {
            ball.setX(ball.getX() + ball.getXInterval());
            if ((ball.getX() < 0 && ball.getXInterval() < 0) ||
            ball.getX() + Ball.SIZE > BallFrame.WIDTH - 15 && ball.getXInterval() > 0) {
                ball.setIntervals(-ball.getXInterval(), 0);
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class VerticalMoveStrategy extends DirectionStrategy {
    @Override
    public void move(Ball ball) {
        ball.setIntervals(0, Ball.INTERVAL);
        while (true) {
            ball.setY(ball.getY() + ball.getYInterval());
            if ((ball.getY() < 0 && ball.getYInterval() < 0) ||
                    ball.getY() + Ball.SIZE > BallFrame.HEIGHT - 15 && ball.getYInterval() > 0) {
                ball.setIntervals(0, -ball.getYInterval());
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class DiagonalMoveStrategy extends DirectionStrategy {
    @Override
    public void move(Ball ball) {
        ball.setIntervals(Ball.INTERVAL, Ball.INTERVAL);
        while (true) {
            ball.setX(ball.getX() + ball.getXInterval());
            ball.setY(ball.getY() + ball.getYInterval());
            if ((ball.getX() < 0 && ball.getXInterval() < 0) ||
                    ball.getX() + Ball.SIZE > BallFrame.WIDTH - 15 && ball.getXInterval() > 0) {
                ball.setIntervals(-ball.getXInterval(), 0);
            }
            if ((ball.getY() < 0 && ball.getYInterval() < 0) ||
                    ball.getY() + Ball.SIZE > BallFrame.HEIGHT - 15 && ball.getYInterval() > 0) {
                ball.setIntervals(0, -ball.getYInterval());
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

abstract class DrawStrategy {
    public abstract void draw(Ball ball);
}

class RedDrawStrategy extends DrawStrategy {
    @Override
    public void draw(Ball ball) {
        ball.setColor(Color.RED);
    }
}

class BlueDrawStrategy extends DrawStrategy {
    @Override
    public void draw(Ball ball) {
        ball.setColor(Color.BLUE);
    }
}