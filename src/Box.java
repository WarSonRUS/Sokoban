import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Box {
    public static Image box;
    public static char cBox = '\u0062';

    public static ArrayList<Integer> listX = new ArrayList<>();
    public static ArrayList<Integer> listY = new ArrayList<>();

    public Box(int x, int y){
        listX.add(x);
        listY.add(y);
        imageLoad();
    }

    public void imageLoad(){
        ImageIcon imageBox = new ImageIcon("img/Box.png");
        box = imageBox.getImage();
    }

    public static void move(){
        for (int i = 0; i <= GameLogic.boxNum - 1; i++) {
            if(GameLogic.spawnX - 1 == listX.get(i) && GameLogic.spawnY == listY.get(i)){
                if(GameLogic.left){
                    listX.set(i, listX.get(i) - 1);
                }
            }
            if(GameLogic.spawnX + 1 == listX.get(i) && GameLogic.spawnY == listY.get(i)){
                if(GameLogic.right){
                    listX.set(i, listX.get(i) + 1);
                }
            }
            if(GameLogic.spawnX == listX.get(i) && GameLogic.spawnY - 1 == listY.get(i)){
                if(GameLogic.up){
                    listY.set(i, listY.get(i) - 1);
                }
            }
            if(GameLogic.spawnX == listX.get(i) && GameLogic.spawnY + 1 == listY.get(i)){
                if(GameLogic.down){
                    listY.set(i, listY.get(i) + 1);
                }
            }
        }
    }
}
