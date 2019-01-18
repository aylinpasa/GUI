import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;

import java.io.*;


public class GradeSystem extends Application {

    @Override
    public void start(Stage primaryStage){

        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        Button btInstructor = new Button("Instructor");
        Button btStudent = new Button("Student");
        InsHandlerClass handler1= new InsHandlerClass();
        btInstructor.setOnAction(handler1);
        StuHandlerClass handler2= new StuHandlerClass();
        btStudent.setOnAction(handler2);
        pane.getChildren().addAll(btInstructor,btStudent);


        Scene scene= new Scene(pane);
        primaryStage.setTitle("Choose ");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

class InsHandlerClass implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {


        Stage stage = new Stage();
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);


        TextField tfCourseID = new TextField();
        TextField tfStudentID = new TextField();
        TextField tfFirstName = new TextField();
        TextField tfLastName = new TextField();
        TextField tfGrade = new TextField();

        pane.add(new Label("Course ID "), 0, 0);
        pane.add(tfCourseID, 1, 0);
        pane.add(new Label("Student ID"), 0, 1);
        pane.add(tfStudentID, 1, 1);
        pane.add(new Label("First name: "), 0, 2);
        pane.add(tfFirstName, 1, 2);
        pane.add(new Label("Last name: "), 0, 3);
        pane.add(tfLastName, 1, 3);
        pane.add(new Label("Grade: "), 0, 4);
        pane.add(tfGrade, 1, 4);
        Button btadd = new Button("Add name");
        pane.add(btadd, 1, 5);
        Button btclear = new Button("Clear");
        pane.add(btclear, 1, 5);
        //pane.add(new TextField(),0,6);
        GridPane.setHalignment(btadd, HPos.LEFT);
        GridPane.setHalignment(btclear, HPos.RIGHT);


        btclear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ev) {
                tfCourseID.clear();
                tfFirstName.clear();
                tfStudentID.clear();
                tfLastName.clear();
                tfGrade.clear();
            }
        });

        btadd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                try (BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt", true))) {
                    bw.write(tfCourseID.getText()+ " ");
                    // bw.newLine();
                    bw.write(tfStudentID.getText()+ " ");
                    //bw.newLine();
                    bw.write(tfFirstName.getText()+ " ");
                    // bw.newLine();
                    bw.write(tfLastName.getText()+ " ");
                    // bw.newLine();
                    bw.write(tfGrade.getText()+ " ");
                    bw.newLine();
                } catch (IOException ev) {
                    ev.printStackTrace();
                }

            }});

        Scene scene = new Scene(pane);
        stage.setTitle("Instructor");
        stage.setScene(scene);
        stage.show();

    }
}

class StuHandlerClass implements  EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e){

        Stage stage1= new Stage();
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5,12.5,13.5,14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        ChoiceBox choiceBox = new ChoiceBox();

        choiceBox.getItems().add("Course 1");
        choiceBox.getItems().add("Course 2");
        choiceBox.getItems().add("Course 3");

        HBox hbox = new HBox(choiceBox);


        choiceBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                ListView listView = new ListView();

                listView.getItems().add("");
                listView.getItems().add("Item 2");
                listView.getItems().add("Item 3");

                HBox hbox = new HBox(listView);

                Scene scene = new Scene(hbox, 300, 120);
                stage1.setScene(scene);
                stage1.show();

            } });

        Scene scene = new Scene(hbox, 400, 300);
        stage1.setScene(scene);
        stage1.show();

    }
}

