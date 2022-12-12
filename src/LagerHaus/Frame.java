package LagerHaus;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame(String title){
        super(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 300;
        int frameHeight = 300;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    }
}
