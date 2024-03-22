import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
