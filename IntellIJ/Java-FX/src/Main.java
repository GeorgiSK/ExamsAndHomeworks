import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Windows on 4/4/2016.
 */
public class Main extends Application{
    Button button;
    Stage window;
    //Scene scene1, scene2;

    public void start(Stage primaryStage) throws Exception {
        //primaryStage.setTitle("Title!");
        //button = new Button();
        //button.setText("Click Me!");
        //button.setOnAction(e -> System.out.println("ASD"));
        //StackPane layout = new StackPane();
        //layout.getChildren().add(button);
        //Scene scene = new Scene(layout, 300, 250);
        //primaryStage.setScene(scene);
        //primaryStage.show();
        //------------------------------------------------------------------------
        //window = primaryStage;
        //Label labelOne = new Label("Scene One");
        //Button buttonOne = new Button("Go to Scene Two");
        //buttonOne.setOnAction(e -> window.setScene(scene2));
        //VBox layoutOne = new VBox(20);
        //layoutOne.getChildren().addAll(labelOne, buttonOne);
        //scene1 = new Scene(layoutOne, 200, 200);
        //Button buttonTwo = new Button("Go to Scene One");
        //buttonTwo.setOnAction(e -> window.setScene(scene1));
        //StackPane layoutTwo = new StackPane();
        //layoutTwo.getChildren().add(buttonTwo);
        //scene2 = new Scene(layoutTwo, 600, 300);
        //window.setScene(scene1);
        //window.setTitle("A Title");
        //window.show();

        window = primaryStage;
        window.setTitle("Title");

        button = new Button("Click Here");
        button.setOnAction(e -> AlertBox.display("Titleeee", "This happened.."));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 200, 250);
        window.setScene(scene);
        window.show();



    }

    public static void main(String[] args) {
        launch(args);
    }

}
