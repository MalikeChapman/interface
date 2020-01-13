import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.*;

public class OperationHandler extends JButton implements ActionListener {
    GUI jframe;
    float number1;
    float number2;
    float answer;
    String operation;
    String display = "";
    ArrayList<String> numbers = new ArrayList<>();
    ArrayList<String> removeList = new ArrayList<>(List.of("f"));

    public OperationHandler(GUI jframe) {
        this.jframe = jframe;
    }

    public void actionPerformed(ActionEvent e) {
        String operationPerformed = e.getActionCommand();

        if (operationPerformed.equalsIgnoreCase("+")) {
           jframe.textArea.results.append(" + ");
            //replace text with a plus sign then add a check to see if text has any characters

        } else if (operationPerformed.equalsIgnoreCase("-")) {
            jframe.textArea.results.append(" - ");
        } else if (operationPerformed.equalsIgnoreCase("/")) {
           jframe.textArea.results.append(" / ");

        } else if (operationPerformed.equalsIgnoreCase("*")) {
            jframe.textArea.results.append(" * ");

        } else if (operationPerformed.equalsIgnoreCase(".")) {
            jframe.textArea.results.append(".");
        } else if (operationPerformed.equalsIgnoreCase("MC")) {
            jframe.textArea.results.setText("");
            numbers.clear();
            operation = "";

        } else if (operationPerformed.equalsIgnoreCase("back")){
            try {
                removeOneText();
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }


        }

        else if (operationPerformed.equalsIgnoreCase("ans")) {
            operation = jframe.textArea.results.getText() + " =";
            display = operation;
            jframe.textArea.results.setText(display);
            numbers.addAll(convertEquation());
            ListIterator f = numbers.listIterator();
            while (numbers.contains("*") || numbers.contains("/"))
            {

                if (f.hasNext()) {
                    if (numbers.contains("*") && numbers.contains("/")) {
                        int mindex = numbers.indexOf("*");
                        int dindex = numbers.indexOf("/");
                        if (mindex < dindex) {
                            answer = Float.parseFloat(numbers.get(mindex - 1)) * Float.parseFloat(numbers.get(mindex + 1));
                            numbers.set(mindex, "f");
                            numbers.set(mindex - 1, "f");
                            numbers.set(mindex + 1, Float.toString(answer));
                            numbers.removeAll(removeList);
                        }
                        else {
                            answer = Float.parseFloat(numbers.get(dindex - 1)) / Float.parseFloat(numbers.get(dindex + 1));
                            numbers.set(dindex, "f");
                            numbers.set(dindex - 1, "f");
                            numbers.set(dindex + 1, Float.toString(answer));
                            numbers.removeAll(removeList);
                        }

                    } else if (numbers.contains("/")){
                        int index = numbers.indexOf("/");
                        for (int i = 0; i < numbers.size(); i++){
                            System.out.println(numbers.get(i));
                        }
                        answer = Float.parseFloat(numbers.get(index - 1)) / Float.parseFloat(numbers.get(index + 1));
                        numbers.set(index, "f");
                        numbers.set(index - 1, "f");
                        numbers.set(index + 1, Float.toString(answer));
                        numbers.removeAll(removeList);
                    }
                    else if (numbers.contains("*")){
                        int index = numbers.indexOf("*");
                        for (int i = 0; i < numbers.size(); i++){
                            System.out.println(numbers.get(i));
                        }
                        answer = Float.parseFloat(numbers.get(index - 1)) * Float.parseFloat(numbers.get(index + 1));
                        numbers.set(index, "f");
                        numbers.set(index - 1, "f");
                        numbers.set(index + 1, Float.toString(answer));
                        numbers.removeAll(removeList);

                    }
                }

            }

            while (numbers.contains("+") || numbers.contains("-"))
            {

                if (f.hasNext()) {
                    if (numbers.contains("+") && numbers.contains("-")) {
                        int aindex = numbers.indexOf("+");
                        int sindex = numbers.indexOf("-");
                        if (aindex < sindex) {
                            answer = Float.parseFloat(numbers.get(aindex - 1)) + Float.parseFloat(numbers.get(aindex + 1));
                            numbers.set(aindex, "f");
                            numbers.set(aindex - 1, "f");
                            numbers.set(aindex + 1, Float.toString(answer));
                            numbers.removeAll(removeList);
                        }
                        else{
                            answer = Float.parseFloat(numbers.get(sindex - 1)) - Float.parseFloat(numbers.get(sindex + 1));
                            numbers.set(sindex, "f");
                            numbers.set(sindex - 1, "f");
                            numbers.set(sindex + 1, Float.toString(answer));
                            numbers.removeAll(removeList);

                        }

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
                    else if (numbers.contains("+")){
                        int index = numbers.indexOf("+");
                        for (int i = 0; i < numbers.size(); i++){
                            System.out.println(numbers.get(i));
                        }
                        answer = Float.parseFloat(numbers.get(index - 1)) + Float.parseFloat(numbers.get(index + 1));
                        numbers.set(index, "f");
                        numbers.set(index - 1, "f");
                        numbers.set(index + 1, Float.toString(answer));
                        numbers.removeAll(removeList);
                    }
                }

            }

            for (int i = 0; i < numbers.size(); i++){
                jframe.textArea.results.append("\n" + answer);
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

    public void removeOneText() throws BadLocationException {
        Document textArea = jframe.textArea.results.getDocument();
       textArea.remove(textArea.getLength() - 1
               , 1);
    }

    public ArrayList convertEquation(){
        String test;
        ArrayList<String> merger = new ArrayList<>();
        char[] equation = operation.toCharArray();
        for (int i = 0; i < equation.length; i++){
            if (equation[i] == '+'){
                    test = operation.substring(0, operation.indexOf("+"));
                    merger.add(test);
                    merger.add(Character.toString(equation[i]));
                operation = operation.substring(operation.indexOf("+") + 1);
                System.out.println(operation);
            }
            else if (equation[i] == '='){
                test = operation.substring(0, operation.indexOf("="));
                merger.add(test);
            }
            else if (equation[i] == '*'){
                test = operation.substring(0, operation.indexOf("*"));
                merger.add(test);
                merger.add(Character.toString(equation[i]));
                operation = operation.substring(operation.indexOf("*") + 1);
            }
            else if (equation[i] == '/'){
                test = operation.substring(0, operation.indexOf("/"));
                merger.add(test);
                merger.add(Character.toString(equation[i]));
                operation = operation.substring(operation.indexOf("/") + 1);
            }
            else if (equation[i] == '-'){
                test = operation.substring(0, operation.indexOf("-"));
                merger.add(test);
                merger.add(Character.toString(equation[i]));
                operation = operation.substring(operation.indexOf("-") + 1);
            }


        }
        for (int i = 0; i < merger.size(); i++){
            System.out.println(merger.get(i));

        }
        return merger;


    }

    public boolean operatorCheck(char element){
        char[] operators = new char[] {'+', '-', '*', '/'};
        boolean flag = false;
        for (int i = 0; i < operators.length; i++){
            flag = operators[i] == element;
        }
        return flag;
    }


}

