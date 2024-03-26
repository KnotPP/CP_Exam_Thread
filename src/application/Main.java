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
import logic.*;
import javafx.scene.input.KeyCode;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.animation.KeyFrame;

import java.util.ArrayList;

public class Main extends Application {
    public String title = "";
    public static int width = 600;
    public static int height = 400;
    public static Pane pane = new Pane();
    public static UFO UFO =new UFO();
    static String backgroundPic = ClassLoader.getSystemResource("image/SpaceBackground.png").toString();
    private static final Image background = new Image(backgroundPic);
    public static MenuPane menuPane = new MenuPane();
    public static boolean isGameEnd=false;
    public static ArrayList<Item> items = new ArrayList<Item>();
    @Override
    public void start(Stage stage){
        setup();
        menuPane = new MenuPane();
        VBox root = new VBox();
        root.getChildren().addAll(menuPane, pane);
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.show();
        stage.getScene().setOnKeyPressed(e -> {
            if(!isGameEnd) {
                if (e.getCode() == KeyCode.A) {
                    UFO.move(-1);
                }
                else if(e.getCode() == KeyCode.D) {
                    UFO.move(1);
                }
            }
        });
        drawBackground();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(4), event -> {
            items.add(new Star());
        }));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
            items.add(new Rock());
        }));
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.play();

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

    public static void drawItem(Drawable d) {
        ImageView im = d.getImageView();
        pane.getChildren().removeAll(im);
        im.relocate((double)(d.getX()), (double)(d.getY()));
        pane.getChildren().add(im);
    }
}
