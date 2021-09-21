package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.awt.*;

public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Calculator");
        TextField no1 = new TextField();
        TextField no2 = new TextField();
        ListView operations = new ListView();
        operations.getItems().addAll("+", "-", "*", "/");
        operations.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        operations.setMaxHeight(100);

        Button calculate = new Button("Calculate");
        Label result = new Label();
        no1.setMaxWidth(150);
        no2.setMaxWidth(150);

        VBox vBox =new VBox();
        vBox.getChildren().addAll(operations, no1, no2, calculate, result);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(20,20,20,20));

        Scene scene1 = new Scene(vBox, 500, 500);
        primaryStage.setScene(scene1);

        calculate.setOnAction(event -> {
            ObservableList<String> selectedValues = operations.getSelectionModel().getSelectedItems();
            Integer value1 = Integer.parseInt(no1.getText());
            Integer value2 = Integer.parseInt(no2.getText());
            Integer theResult=0;
            String text ="";
            for (String op: selectedValues) {
                switch (op) {
                    case "+":
                        theResult = value1 + value2;
                        text += theResult.toString();break;
                    case "-":
                        theResult = value1 - value2;
                        text += "\n" + theResult.toString();break;
                    case "*":
                        theResult = value1 * value2;
                        text += "\n" + theResult.toString();break;
                    case "/":
                        theResult = value1 / value2;
                        text += "\n" + theResult.toString();break;
                }
            }
            result.setText(text);

        });
        primaryStage.show();


    }
}
