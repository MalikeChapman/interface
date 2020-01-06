import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileMenuHandler implements ActionListener {
    JFrame jf;
    public FileMenuHandler(JFrame jf){
        this.jf = jf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String menuItems = e.getActionCommand();
        if (menuItems.equalsIgnoreCase("Start"))
        {
            GUI calculator = new GUI();
        }
    }
}
