package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.MenuPane;

public class Main extends Application {
    public String title = "";
    public static int width = 600;
    public static int height = 400;
    public static Pane pane = new Pane();
    static String backgroundPic = ClassLoader.getSystemResource("image/SpaceBackground.png").toString();
    private static final Image background = new Image(backgroundPic);
    private static MenuPane menuPane;
    public static boolean isGameEnd=false;
    @Override
    public void start(Stage stage){
        setup();
        menuPane = new MenuPane();
        VBox root = new VBox();
        root.getChildren().addAll(menuPane, pane);
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.show();
        drawBackground();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    void setup() {
        title = "Star Catcher";
        width = 500;
        height = 700;
    }

    void drawBackground() {
        ImageView backgroundImgView = new ImageView(background);
        backgroundImgView.setFitHeight(700);
        backgroundImgView.setFitWidth(500);
        pane.getChildren().add(backgroundImgView);
    }

}
