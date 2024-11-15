module calculator.calculator_ios {
    requires javafx.controls;
    requires javafx.fxml;


    opens calculator.calculator_ios to javafx.fxml;
    exports calculator.calculator_ios;
}