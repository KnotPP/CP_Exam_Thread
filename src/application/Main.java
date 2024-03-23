package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public String title = "";
    public static int width = 600;
    public static int height = 400;
    public static Pane pane = new Pane();
    static String backgroundPic = ClassLoader.getSystemResource("image/SpaceBackground.png").toString();
    private static final Image background = new Image(backgroundPic);
    @Override
    public void start(Stage stage){
        setup();
        VBox root = new VBox();
        HBox controlTab = new HBox();
        controlTab.setAlignment(Pos.CENTER);
        root.getChildren().addAll(controlTab, pane);
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.show();
        drawBackground();
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
