import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class OperationHandler extends ArrayList<String> implements ActionListener {
    GUI jframe;
    float number1;
    float number2;
    float answer;
    String operation;
    ArrayList<String> numbers = new ArrayList<>();
    ArrayList<String> removeList = new ArrayList<String>(List.of("f"));
    //ArrayList<String> operations = new ArrayList<>();
    String[] operationOrder = new String[]{"*", "/", "+", "-"};

    public OperationHandler(GUI jframe) {
        this.jframe = jframe;
    }

    public void actionPerformed(ActionEvent e) {
        String operationPerformed = e.getActionCommand();

        if (operationPerformed.equalsIgnoreCase("+")) {
            numbers.add(jframe.textArea.results.getText());
            numbers.add("+");
            jframe.textArea.results.selectAll();
            jframe.textArea.results.replaceSelection("+");
            //replace text with a plus sign then add a check to see if text has any characters

        } else if (operationPerformed.equalsIgnoreCase("-")) {
            numbers.add(jframe.textArea.results.getText());
            numbers.add("-");
            jframe.textArea.results.selectAll();
            jframe.textArea.results.replaceSelection("-");
        } else if (operationPerformed.equalsIgnoreCase("/")) {
            numbers.add(jframe.textArea.results.getText());
            numbers.add("/");
            jframe.textArea.results.selectAll();
            jframe.textArea.results.replaceSelection("/");

        } else if (operationPerformed.equalsIgnoreCase("*")) {
            operation = "*";
            numbers.add(jframe.textArea.results.getText());
            numbers.add("*");
            jframe.textArea.results.selectAll();
            jframe.textArea.results.replaceSelection("*");

        } else if (operationPerformed.equalsIgnoreCase(".")) {
            jframe.textArea.results.setText(jframe.textArea.results.getText() + ".");
        } else if (operationPerformed.equalsIgnoreCase("MC")) {
            jframe.textArea.results.setText("");
            numbers.clear();
            operation = "";

        } else if (operationPerformed.equalsIgnoreCase("ans")) {
            numbers.add(jframe.textArea.results.getText());
            int mdcount = 0;
            int ascount = 0;
            ListIterator f = numbers.listIterator();
            while (numbers.contains("*") || numbers.contains("/"))
            {
                mdcount++;
                if (numbers.get(mdcount).equalsIgnoreCase("*") || numbers.get(mdcount).equalsIgnoreCase("/")){
                    if(numbers.get(mdcount).equalsIgnoreCase("*")){
                       answer = Float.parseFloat(numbers.get(mdcount - 1)) * Float.parseFloat(numbers.get(mdcount + 1));
                        numbers.set(mdcount, "f");
                        numbers.set(mdcount - 1, "f");
                        numbers.set(mdcount + 1, Float.toString(answer));
                        numbers.removeAll(removeList);

                    }
                    else if (numbers.get(mdcount).equalsIgnoreCase("/")){
                        answer = Float.parseFloat(numbers.get(mdcount - 1)) / Float.parseFloat(numbers.get(mdcount + 1));
                        numbers.set(mdcount, "f");
                        numbers.set(mdcount - 1, "f");
                        numbers.set(mdcount + 1, Float.toString(answer));
                        numbers.removeAll(removeList);
                    }
                }

            }
            for (int i = 0; i < numbers.size(); i++)
            {
                System.out.println(numbers.get(i));
            }
            while (numbers.contains("+") || numbers.contains("-"))
            {

                if (f.hasNext()) {
                    if (numbers.contains("+")) {
                        int index = numbers.indexOf("+");
                        answer = Float.parseFloat(numbers.get(index - 1)) + Float.parseFloat(numbers.get(index + 1));
                        numbers.set(index, "f");
                        numbers.set(index - 1, "f");
                        numbers.set(index + 1, Float.toString(answer));
                        numbers.removeAll(removeList);

                    } else if (numbers.contains("-")){
                        int index = numbers.indexOf("-");
                        for (int i = 0; i < numbers.size(); i++){
                            System.out.println(numbers.get(i));
                        }
                        answer = Float.parseFloat(numbers.get(index - 1)) - Float.parseFloat(numbers.get(index + 1));
                        numbers.set(index, "f");
                        numbers.set(index - 1, "f");
                       numbers.set(index + 1, Float.toString(answer));
                        numbers.removeAll(removeList);
                    }
                }

            }
            jframe.textArea.results.setText("");

            for (int i = 0; i < numbers.size(); i++){
                jframe.textArea.results.append(Float.toString(answer));
            }

        }
    }
    public float add ( float number1, float number2){
        return number1 + number2;

    }
    public float subtract ( float number1, float number2){
        return number1 - number2;
    }
    public String toString () {
        return number1 + " " + operation + " " + number2 + " =\n";
    }
    public float multiply ( float number1, float number2){
        return number1 * number2;
    }
    public float divide ( float number1, float number2){
        return number1 / number2;
    }


}

