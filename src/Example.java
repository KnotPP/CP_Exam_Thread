import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class Example extends Application{
    @Override
    public void start(Stage PrimaryStage){
        Button btn = new Button("Hello");
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root,300,250);
        PrimaryStage.setTitle("Example");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
