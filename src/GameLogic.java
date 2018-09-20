import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GameLogic extends JPanel implements ActionListener {
    private final int SIZE_LEVLE = 640;
    private final int SIZE_CALL = 32;
    private int x = 0;
    private int y = 0;
    static int spawnX = 0;
    static int spawnY = 0;
    static int boxNum = 0;
    private char[][] gameLevel = new char[SIZE_LEVLE/SIZE_CALL][SIZE_LEVLE/SIZE_CALL];
    private Image wall;
    private Timer timer;
    static boolean left = false;
    static boolean right = false;
    static boolean up = false;
    static boolean down = false;

    Hero hero;

    public GameLogic() throws IOException {
        setBackground(Color.GRAY);
        imageLoad();
        levelLoad();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }

    public void imageLoad(){
        ImageIcon imageWall = new ImageIcon("img/Wall.png");
        wall = imageWall.getImage();
    }


    public void levelLoad() throws IOException {
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(new File("level/Test.txt")));
        int c;
        for (y = 0; y < 20; y++) {
            for (x = 0; x < 20; x++) {
                c = reader.read();
                if ((char)c == Hero.cHero){
                    hero = new Hero(x, y);
                    spawnX = hero.heroX;
                    spawnY = hero.heroY;
                }
                if ((char)c == Box.cBox){
                    new Box(x, y);
                    boxNum += 1;
                }
                gameLevel[x][y] = (char)c;
            }
        }
        reader.close();
    }

    public void initGame(){
        timer = new Timer(125, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (y = 0; y < 20; y++) {
            for (x = 0; x < 20; x++) {
                if (gameLevel[x][y] == '\u0040'){
                    g.drawImage(wall, x * SIZE_CALL, y * SIZE_CALL, this);
                }

            }
        }

        g.drawImage(hero.man, spawnX * SIZE_CALL, spawnY * SIZE_CALL, this);

        for (int i = 0; i < boxNum; i++) {
            g.drawImage(Box.box, Box.listX.get(i) * SIZE_CALL, Box.listY.get(i) * SIZE_CALL, this);
        }
    }

    public void move(){

        if(left && gameLevel[spawnX - 1][spawnY] != '\u0040'){
            Box.move();
            spawnX -= 1;
            left = false;
        }

        if(right && gameLevel[spawnX + 1][spawnY] != '\u0040'){
            Box.move();
            spawnX += 1;
            right = false;
        }

        if(up && gameLevel[spawnX][spawnY - 1] != '\u0040'){
            Box.move();
            spawnY -= 1;
            up = false;
        }

        if(down && gameLevel[spawnX][spawnY + 1] != '\u0040'){
            Box.move();
            spawnY += 1;
            down = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT){
                left = true;
                right = false;
                up = false;
                down = false;
                hero.man = hero.manL;
            }
            if(key == KeyEvent.VK_RIGHT){
                right = true;
                left = false;
                up = false;
                down = false;
                hero.man = hero.manR;
            }
            if(key == KeyEvent.VK_UP){
                up = true;
                left = false;
                right = false;
                down = false;
                hero.man = hero.manU;
            }
            if(key == KeyEvent.VK_DOWN){
                down = true;
                left = false;
                right = false;
                up = false;
                hero.man = hero.manD;
            }
        }
    }
}
