import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdvCalculator extends Application {

    private TextField textField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("KiBty Calculator");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(gridPane, 275, 300);
        primaryStage.setScene(scene);

        textField = new TextField();
        textField.setEditable(false);
        textField.setPrefHeight(30);
        gridPane.add(textField, 0, 0, 4, 1);

        Button btnClear = new Button("C");
        btnClear.setPrefSize(60, 30);
        btnClear.setOnAction(new ClearButtonHandler());
        gridPane.add(btnClear, 0, 1);

        Button btnSin = new Button("sin");
        btnSin.setPrefSize(60, 30);
        btnSin.setOnAction(new SinButtonHandler());
        gridPane.add(btnSin, 1, 1);

        Button btnCos = new Button("cos");
        btnCos.setPrefSize(60, 30);
        btnCos.setOnAction(new CosButtonHandler());
        gridPane.add(btnCos, 2, 1);

        Button btnTan = new Button("tan");
        btnTan.setPrefSize(60, 30);
        btnTan.setOnAction(new TanButtonHandler());
        gridPane.add(btnTan, 3, 1);

        Button btn7 = new Button("7");
        btn7.setPrefSize(60, 30);
        btn7.setOnAction(new NumberButtonHandler("7"));
        gridPane.add(btn7, 0, 2);

        Button btn8 = new Button("8");
        btn8.setPrefSize(60, 30);
        btn8.setOnAction(new NumberButtonHandler("8"));
        gridPane.add(btn8, 1, 2);

        Button btn9 = new Button("9");
        btn9.setPrefSize(60, 30);
        btn9.setOnAction(new NumberButtonHandler("9"));
        gridPane.add(btn9, 2, 2);

        Button btnDivide = new Button("/");
        btnDivide.setPrefSize(60, 30);
        btnDivide.setOnAction(new OperatorButtonHandler("/"));
        gridPane.add(btnDivide, 3, 2);

        Button btn4 = new Button("4");
        btn4.setPrefSize(60, 30);
        btn4.setOnAction(new NumberButtonHandler("4"));
        gridPane.add(btn4, 0, 3);

        Button btn5 = new Button("5");
        btn5.setPrefSize(60, 30);
        btn5.setOnAction(new NumberButtonHandler("5"));
        gridPane.add(btn5, 1, 3);

        Button btn6 = new Button("6");
        btn6.setPrefSize(60, 30);
        btn6.setOnAction(new NumberButtonHandler("6"));
        gridPane.add(btn6, 2, 3);

        Button btnMultiply = new Button("*");
        btnMultiply.setPrefSize(60, 30);
        btnMultiply.setOnAction(new OperatorButtonHandler("*"));
        gridPane.add(btnMultiply, 3, 3);

        Button btn1 = new Button("1");
        btn1.setPrefSize(60, 30);
        btn1.setOnAction(new NumberButtonHandler("1"));
        gridPane.add(btn1, 0, 4);

        Button btn2 = new Button("2");
        btn2.setPrefSize(60, 30);
        btn2.setOnAction(new NumberButtonHandler("2"));
        gridPane.add(btn2, 1, 4);

        Button btn3 = new Button("3");
        btn3.setPrefSize(60, 30);
        btn3.setOnAction(new NumberButtonHandler("3"));
        gridPane.add(btn3, 2, 4);

        Button btnSubtract = new Button("-");
        btnSubtract.setPrefSize(60, 30);
        btnSubtract.setOnAction(new OperatorButtonHandler("-"));
        gridPane.add(btnSubtract, 3, 4);

        Button btn0 = new Button("0");
        btn0.setPrefSize(60, 30);
        btn0.setOnAction(new NumberButtonHandler("0"));
        gridPane.add(btn0, 0, 5);

        Button btnDecimal = new Button(".");
        btnDecimal.setPrefSize(60, 30);
        btnDecimal.setOnAction(new NumberButtonHandler("."));
        gridPane.add(btnDecimal, 1, 5);

        Button btnEquals = new Button("=");
        btnEquals.setPrefSize(60, 30);
        btnEquals.setOnAction(new EqualsButtonHandler());
        gridPane.add(btnEquals, 2, 5);

        Button btnAdd = new Button("+");
        btnAdd.setPrefSize(60, 30);
        btnAdd.setOnAction(new OperatorButtonHandler("+"));
        gridPane.add(btnAdd, 3, 5);

        primaryStage.show();
    }

    private class NumberButtonHandler implements EventHandler<ActionEvent> {

        private String number;

        public NumberButtonHandler(String number) {
            this.number = number;
        }

        @Override
        public void handle(ActionEvent event) {
            textField.setText(textField.getText() + number);
        }
    }

    private class OperatorButtonHandler implements EventHandler<ActionEvent> {

        private String operator;

        public OperatorButtonHandler(String operator) {
            this.operator = operator;
        }

        @Override
        public void handle(ActionEvent event) {
            textField.setText(textField.getText() + " " + operator + " ");
        }
    }

    private class EqualsButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String expression = textField.getText();
            String[] parts = expression.split(" ");
            double result = Double.parseDouble(parts[0]);

            for (int i = 1; i < parts.length; i += 2) {
                String operator = parts[i];
                double operand = Double.parseDouble(parts[i + 1]);

                switch (operator) {
                    case "+":
                        result += operand;
                        break;
                    case "-":
                        result -= operand;
                        break;
                    case "*":
                        result *= operand;
                        break;
                    case "/":
                        if (operand != 0) {
                            result /= operand;
                        }
                        break;
                }
            }

            textField.setText(Double.toString(result));
        }
    }

    private class ClearButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            textField.setText("");
        }
    }

    private class SinButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            double number = Double.parseDouble(textField.getText());
            double result = Math.sin(Math.toRadians(number));
            textField.setText(String.format("%.1f", result));
        }
    }

    private class CosButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            double number = Double.parseDouble(textField.getText());
            double result = Math.cos(Math.toRadians(number));
            textField.setText(String.format("%.1f", result));
        }
    }

    private class TanButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            double number = Double.parseDouble(textField.getText());
            double result = Math.tan(Math.toRadians(number));
            textField.setText(String.format("%.1f", result));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}