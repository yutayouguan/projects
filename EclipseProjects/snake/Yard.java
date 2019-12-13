
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Yard extends Frame {
    private static final long serialVersionUID = 1L;
    PaintThread paintThread = new PaintThread();
    private boolean gameOver = false;
    public static final int ROWS = 30;
    public static final int COLS = 30;
    public static final int BLOCK_SIZE = 15;
    private Font fontGameOver = new Font("宋体", Font.BOLD, 50);
    private int score = 0;
    private long beginTime = 0;
    Snake s = new Snake(this);
    Egg e = new Egg();
    Image offScreenImage = null;

    public void launch() {
        this.setLocation(90, 100);
        this.setSize(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
        this.addKeyListener(new KeyMonitor());
        new Thread(paintThread).start();
    }

    public static void main(String[] args) {
        Yard y = new Yard();
        y.beginTime = System.currentTimeMillis();
        y.launch();
    }

    public void stop() {
        gameOver = true;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
        g.setColor(Color.DARK_GRAY);
        for (int i = 1; i < ROWS; i++) {
            g.drawLine(0, BLOCK_SIZE * i, COLS * BLOCK_SIZE, BLOCK_SIZE * i);
        }
        for (int i = 1; i < COLS; i++) {
            g.drawLine(BLOCK_SIZE * i, 0, BLOCK_SIZE * i, BLOCK_SIZE * ROWS);
        }
        g.setColor(Color.YELLOW);
        g.drawString("使用说明：使用方向键控制方向，F1--停止，F2--停止后恢复，F5--重新开始", 40, 60);
        g.drawString("目前分数:" + score, 20, 80);
        g.drawString("加分规则：每吃一个加5分，加油！", 40, 100);
        g.drawString("已经使用的时间：" + (System.currentTimeMillis() - beginTime) / 1000, 40, 120);
        if (gameOver) {
            g.setFont(fontGameOver);
            g.drawString("game over!", 90, 170);
            g.drawString("在玩一次，请按F5", 10, 250);
            g.drawString(" ", 200, 230);
            paintThread.pause();
        }
        if (score > 100) {
            g.drawString("好棒！！！", 90, 170);
            g.drawString("你已经超过" + score + ",继续加油", 10, 230);
        }
        g.setColor(c);
        s.eat(e);
        e.draw(g);
        s.draw(g);
    }

    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    private class PaintThread implements Runnable {
        private boolean running = true;
        private boolean pause = false;

        public void run() {
            while (running) {
                if (pause)
                    continue;
                else
                    repaint();

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void pause() {
            this.pause = true;
        }

        public void reStart() {
            this.pause = false;
            s = new Snake(Yard.this);
            gameOver = false;
            score = 0;
        }
    }

    private class KeyMonitor extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_F5) {
                paintThread.reStart();
            } else if (key == KeyEvent.VK_F1) {
                paintThread.pause = true;
            } else if (key == KeyEvent.VK_F2) {
                paintThread.pause = false;
            }
            s.keyPressed(e);
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
