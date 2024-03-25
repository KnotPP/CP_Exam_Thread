package logic;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MenuPane extends HBox {
    private Button endButton;
    private Text scoreText;
    private int score = 0;

    public MenuPane(){
        endButton = new Button("End Game");
        scoreText = new Text();
        scoreText.setFont(Font.font( 16));
        setScoreText(score);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(6));
        setSpacing(300);
        this.getChildren().addAll(scoreText,endButton);
        endButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                endButton.setDisable(true);
                Main.isGameEnd=true;
            }
        });
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setScoreText(int score) {
        scoreText.setText("Score: " + String.valueOf(score));
    }
}
