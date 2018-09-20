/*
@author Vitaly Gorshkov
@version alpha_0.1
 */
import javax.swing.*;
import java.io.IOException;

public class Sokoban extends JFrame {
    final String TITLE_OF_PROGRAM = "Sokoban WS edition";
    final int START_LOCATION = 200;
    final int WINDOW_WIGTH = 660;
    final int WINDOW_HEIGHT = 685;

    public static void main(String[] args) throws IOException {
        new Sokoban();
    }

    Sokoban() throws IOException {
        setName(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIGTH, WINDOW_HEIGHT);
        add(new GameLogic());
        setVisible(true);
    }
}
