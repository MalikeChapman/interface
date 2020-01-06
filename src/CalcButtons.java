import javax.swing.*;
import java.awt.*;

public class CalcButtons extends JButton {
    protected JButton button;
    protected JTextArea results;


    public void addCalcButtons(GUI frame){

        JPanel center = new JPanel(new GridLayout(4,4));
        JPanel east = new JPanel((new GridLayout(2,1)));
        ButtonHandler bh = new ButtonHandler(frame);
        OperationHandler oh = new OperationHandler(frame);
        String[] symbols = new String[]{"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "ans", "+" };
        String[] memory = new String[]{"MC", "back",};
        for (int i = 0; i < symbols.length; i++){
            center.add(button = new JButton(symbols[i]));
            if (symbols[i].equalsIgnoreCase("/") || symbols[i].equalsIgnoreCase("-") || symbols[i].equalsIgnoreCase("*") || symbols[i].equalsIgnoreCase(".") || symbols[i].equalsIgnoreCase("ans") || symbols[i].equalsIgnoreCase("+"))
                button.addActionListener(oh);
            else
            button.addActionListener(bh);
        }
        for (int i = 0; i < memory.length; i++){
            east.add(button = new JButton((memory[i])));
            if (memory[i].equalsIgnoreCase("MC") || memory[i].equalsIgnoreCase("back")){
                button.addActionListener(oh);
            }
        }
        frame.add(center, BorderLayout.CENTER);
        frame.add(east, BorderLayout.EAST);
    }
    public void addTextField(JFrame frame){
        JPanel north = new JPanel(new BorderLayout());
        results = new JTextArea();
        results.setPreferredSize(new Dimension(400, 50));
        results.setEditable(false);
        results.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        north.add(results);
        frame.add(north, BorderLayout.PAGE_START);
    }

    public JTextArea getResults() {
        return results;
    }
}
