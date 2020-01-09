import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler extends JButton implements ActionListener {
    GUI jframe;
    String test = "";

    public ButtonHandler(GUI jframe) {
        this.jframe = jframe;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonOptions = e.getActionCommand();
        if (buttonOptions.equalsIgnoreCase("0"))
        {
            if(!operations(jframe.textArea.results.getText()) || decimalCheck(jframe.textArea.results.getText())){
                jframe.textArea.results.append("0");
                test += "0";
            }
            else {
                test = test + jframe.textArea.results.getText() + " " + "0";
                jframe.textArea.results.append(test);
                //jframe.textArea.results.selectAll();
                //jframe.textArea.results.replaceSelection("0");
            }


        }
        else if (buttonOptions.equalsIgnoreCase("1")) {
            if(!operations(jframe.textArea.results.getText()) || decimalCheck(jframe.textArea.results.getText())){
                jframe.textArea.results.append("1");
                test +="1";
            }
            else {
                test = test + jframe.textArea.results.getText() + " " + "1";
                jframe.textArea.results.append(test);
                //jframe.textArea.results.selectAll();
                //jframe.textArea.results.replaceSelection("1");

            }


        }
        else if (buttonOptions.equalsIgnoreCase("2")) {

            if(!operations(jframe.textArea.results.getText()) || decimalCheck(jframe.textArea.results.getText())){
                jframe.textArea.results.append("2");
                test += "2";
            }
            else {
                test = test + jframe.textArea.results.getText() + " " + "2";
                jframe.textArea.results.append(test);
                //jframe.textArea.results.selectAll();
                //jframe.textArea.results.replaceSelection("2");


            }

        }
        else if (buttonOptions.equalsIgnoreCase("3")) {
            if(!operations(jframe.textArea.results.getText()) || decimalCheck(jframe.textArea.results.getText())){
                jframe.textArea.results.append("3");
                test += "3";

            }
            else {
                test = test + jframe.textArea.results.getText() + " " + "3";
                jframe.textArea.results.append(test);
                //jframe.textArea.results.selectAll();
                //jframe.textArea.results.replaceSelection("3");


            }
        }
        else if (buttonOptions.equalsIgnoreCase("4")) {
            if(!operations(jframe.textArea.results.getText()) || decimalCheck(jframe.textArea.results.getText())){
                jframe.textArea.results.append("4");
                test +="4";
            }
            else {
                test = test + jframe.textArea.results.getText() + " " + "4";
                jframe.textArea.results.append(test);
                //jframe.textArea.results.selectAll();
                //jframe.textArea.results.replaceSelection("4");

            }
        }
        else if (buttonOptions.equalsIgnoreCase("5")) {
            if(!operations(jframe.textArea.results.getText()) || decimalCheck(jframe.textArea.results.getText())){
                jframe.textArea.results.append("5");
                test +="5";

            }
            else {
                test = test + jframe.textArea.results.getText() + " " + "5";
                jframe.textArea.results.append(test);
                //jframe.textArea.results.selectAll();
                //jframe.textArea.results.replaceSelection("5");

            }
        } else if (buttonOptions.equalsIgnoreCase("6")) {
            if(!operations(jframe.textArea.results.getText()) || decimalCheck(jframe.textArea.results.getText())){
                jframe.textArea.results.append("6");
                test +="6";


            }
            else {
                test = test + jframe.textArea.results.getText() + " " + "6";
                jframe.textArea.results.append(test);
                //jframe.textArea.results.selectAll();
                //jframe.textArea.results.replaceSelection("6");

            }

        }
        else if (buttonOptions.equalsIgnoreCase("7")) {
            if(!operations(jframe.textArea.results.getText()) || decimalCheck(jframe.textArea.results.getText())){
                jframe.textArea.results.append("7");
                test +="7";

            }
            else {
                test = test + jframe.textArea.results.getText() + " " + "7";
                jframe.textArea.results.append(test);
                //jframe.textArea.results.selectAll();
                //jframe.textArea.results.replaceSelection("7");
            }

        } else if (buttonOptions.equalsIgnoreCase("8")) {
            if(!operations(jframe.textArea.results.getText()) || decimalCheck(jframe.textArea.results.getText())){
                jframe.textArea.results.append("8");
                test +="8";

            }
            else {
                test = test + jframe.textArea.results.getText() + " " + "8";
                jframe.textArea.results.append(test);
                //jframe.textArea.results.selectAll();
                //jframe.textArea.results.replaceSelection("8");
            }

        } else if (buttonOptions.equalsIgnoreCase("9")) {
            if(!operations(jframe.textArea.results.getText()) || decimalCheck(jframe.textArea.results.getText())){
                jframe.textArea.results.append("9");
                test +="9";

            }
            else {
                test = test + jframe.textArea.results.getText() + " " + "9";
                jframe.textArea.results.append(test);
                //jframe.textArea.results.selectAll();
                //jframe.textArea.results.replaceSelection("9");
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

    public boolean decimalCheck(String operationPerformed){
        boolean flag = false;
        char[] characterCheck = operationPerformed.toCharArray();
        for (int i = 0; i < operationPerformed.length(); i++){
            if (characterCheck[i] == '.'){
                flag = true;
            }
            else{
                flag = false;
            }
        }
        return flag;
    }
}
