package calculator.calculator_ios;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;

public class CalculatorController {
    @FXML
    private Button button_AC;

    @FXML
    private Button button_idk;

    @FXML
    private Button button_percent;

    @FXML
    private Button button_0;

    @FXML
    private Button button_1;

    @FXML
    private Button button_2;

    @FXML
    private Button button_3;

    @FXML
    private Button button_4;

    @FXML
    private Button button_5;

    @FXML
    private Button button_6;

    @FXML
    private Button button_7;

    @FXML
    private Button button_8;

    @FXML
    private Button button_9;

    @FXML
    private Button button_dot;

    @FXML
    private Button button_plus;

    @FXML
    private Button button_minus;

    @FXML
    private Button button_multiply;

    @FXML
    private Button button_division;

    @FXML
    private Button button_equal;

    @FXML
    private Label output;

    private long number1;
    private String operator = "";
    private boolean start = true;

    @FXML
    private void processNumPad(ActionEvent event){

        if(start){
            output.setText("");
            start = false;
        }
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);

        if(true){
            System.out.println(value);
        }
    }

    @FXML
    private void processOperator(ActionEvent event){

        String value = ((Button)event.getSource()).getText();

        if(!value.equals("=")){
            if(!operator.isEmpty()){
                return;
            }
            operator = value;
            number1 = Long.parseLong(output.getText());
            output.setText("");
        }else{
            if(operator.isEmpty()){
                return;
            }
            if(output.getText().isEmpty()){
                output.setText("Error");
                operator = "";
                start = true;
            }
            output.setText(calculate(number1, Long.parseLong(output.getText()), operator));
            operator = "";
            start = true;
        }
        if(true){
            System.out.println(value);
        }

    }

    private String calculate(long number1, long number2, String op){

        switch (op){

            case "+":
                return String.valueOf(number1 + number2);
            case "-":
                return String.valueOf(number1 - number2);
            case "×":
                return String.valueOf(number1 * number2);
            case "÷":
                if(number2 == 0){
                    return "Error";
                }
                return String.valueOf(number1 / number2);
        }
        return "Error";
    }

    @FXML
    private void initialize() {
        List<Button> buttons_grey = List.of(button_AC, button_idk, button_percent);

        for (Button button : buttons_grey) {
            button.setOnMousePressed(event -> button.setStyle("-fx-background-color: #8C8C8C; -fx-background-radius: 30;"));
            button.setOnMouseReleased(event -> button.setStyle("-fx-background-color: #B7B7B7; -fx-background-radius: 30;"));
        }

        List<Button> buttons_black = List.of(button_0,button_1, button_2, button_3, button_4, button_5,button_6,button_7,button_8,button_9,button_dot);

        for(Button button : buttons_black){
            button.setOnMousePressed(event -> button.setStyle("-fx-background-color: #4E535A; -fx-background-radius: 30;"));
            button.setOnMouseReleased(event -> button.setStyle("-fx-background-color: #686D76; -fx-background-radius: 30;"));
        }

        List<Button> buttons_orange = List.of(button_equal, button_division, button_multiply, button_minus, button_plus);

        for(Button button : buttons_orange){
            button.setOnMousePressed(event -> button.setStyle("-fx-background-color: #FCCB5A; -fx-background-radius: 30;"));
            button.setOnMouseReleased(event -> button.setStyle("-fx-background-color: #FAB12F; -fx-background-radius: 30;"));
        }

    }
}