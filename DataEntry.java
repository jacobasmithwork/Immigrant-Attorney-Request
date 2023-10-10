import java.awt.*;
import javax.swing.*;

public class DataEntry{
    
    public DataEntry(){
        //init gui
        JFrame mainFrame = new JFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));

        mainFrame.setTitle("Welcome");
        mainFrame.setSize(500, 600);
        mainFrame.setMinimumSize(new Dimension(300, 400));
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        //handle gui
        new DataEntry();
    }
}