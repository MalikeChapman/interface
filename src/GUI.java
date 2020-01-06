import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    protected static GUI calcFrame;
    CalcButtons buttons = new CalcButtons();
    CalcButtons textArea = new CalcButtons();


    public GUI() {
        setLocation(400, 400);
        setSize(400, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttons.addCalcButtons(this);
        textArea.addTextField(this);
        ButtonHandler bh = new ButtonHandler(this);
        buttons.addActionListener(bh);
        setVisible(true);
    }


}