import javax.swing.*;
import java.awt.*;

public class Hero {
    public static Image manU;
    public static Image manD;
    public static Image manL;
    public static Image manR;
    public static Image man;
    public static int heroX;
    public static int heroY;
    public static char cHero = '\u0073';

    public Hero(int x, int y){
        heroX = x;
        heroY = y;
        imageLoad();
        man = manU;
    }

    public void imageLoad(){
        ImageIcon imageManU = new ImageIcon("img/ManU.png");
        manU = imageManU.getImage();
        ImageIcon imageManD = new ImageIcon("img/ManD.png");
        manD = imageManD.getImage();
        ImageIcon imageManL = new ImageIcon("img/ManL.png");
        manL = imageManL.getImage();
        ImageIcon imageManR = new ImageIcon("img/ManR.png");
        manR = imageManR.getImage();
        ImageIcon imageWall = new ImageIcon("img/Wall.png");
    }
}
