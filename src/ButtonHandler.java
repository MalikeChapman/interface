import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler extends JButton implements ActionListener {
    GUI jframe;

    public ButtonHandler(GUI jframe) {
        this.jframe = jframe;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonOptions = e.getActionCommand();
        if (buttonOptions.equalsIgnoreCase("0"))
        {
            if(!operations(jframe.textArea.results.getText())){
                jframe.textArea.results.append("0");
            }
            else {
                jframe.textArea.results.selectAll();
                jframe.textArea.results.replaceSelection("0");
            }


        }
        else if (buttonOptions.equalsIgnoreCase("1")) {
            if(!operations(jframe.textArea.results.getText())){
                jframe.textArea.results.append("1");
            }
            else {
                jframe.textArea.results.selectAll();
                jframe.textArea.results.replaceSelection("1");
            }


        }
        else if (buttonOptions.equalsIgnoreCase("2")) {

            if(!operations(jframe.textArea.results.getText())){
                jframe.textArea.results.append("2");
            }
            else {
                jframe.textArea.results.selectAll();
                jframe.textArea.results.replaceSelection("2");
            }

        }
        else if (buttonOptions.equalsIgnoreCase("3")) {
            if(!operations(jframe.textArea.results.getText())){
                jframe.textArea.results.append("3");
            }
            else {
                jframe.textArea.results.selectAll();
                jframe.textArea.results.replaceSelection("3");
            }
        }
        else if (buttonOptions.equalsIgnoreCase("4")) {
            if(!operations(jframe.textArea.results.getText())){
                jframe.textArea.results.append("4");
            }
            else {
                jframe.textArea.results.selectAll();
                jframe.textArea.results.replaceSelection("4");
            }
        }
        else if (buttonOptions.equalsIgnoreCase("5")) {
            if(!operations(jframe.textArea.results.getText())){
                jframe.textArea.results.append("5");
            }
            else {
                jframe.textArea.results.selectAll();
                jframe.textArea.results.replaceSelection("5");
            }
        } else if (buttonOptions.equalsIgnoreCase("6")) {
            if(!operations(jframe.textArea.results.getText())){
                jframe.textArea.results.append("6");
            }
            else {
                jframe.textArea.results.selectAll();
                jframe.textArea.results.replaceSelection("6");
            }

        }
        else if (buttonOptions.equalsIgnoreCase("7")) {
            if(!operations(jframe.textArea.results.getText())){
                jframe.textArea.results.append("7");
            }
            else {
                jframe.textArea.results.selectAll();
                jframe.textArea.results.replaceSelection("7");
            }

        } else if (buttonOptions.equalsIgnoreCase("8")) {
            if(!operations(jframe.textArea.results.getText())){
                jframe.textArea.results.append("8");
            }
            else {
                jframe.textArea.results.selectAll();
                jframe.textArea.results.replaceSelection("8");
            }

        } else if (buttonOptions.equalsIgnoreCase("9")) {
            if(!operations(jframe.textArea.results.getText())){
                jframe.textArea.results.append("9");
            }
            else {
                jframe.textArea.results.selectAll();
                jframe.textArea.results.replaceSelection("9");
            }

        }
    }

    public boolean operations(String operationPerformed){
        String[] operations = new String[] {"+", "/", "-", "*"};
        boolean flag = false;
        for (int i = 0; i < operations.length; i++){
            if (operationPerformed.equalsIgnoreCase(operations[i])) {
                flag = true;
                break;
            }
            else
            {
                flag = false;

            }
        }
        return flag;
    }
}
