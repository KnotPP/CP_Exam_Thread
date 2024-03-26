package logic;

import application.Main;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;

public class Star extends Item{

    Random rand = new Random();
    public Star() {
        super();
        setX(rand.nextInt(20,440));
        setY(10);
        String star = ClassLoader.getSystemResource("image/Star.png").toString();
        imageView = new ImageView(star);


        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        initItem();
    }

    @Override
    public void move() {
        setX(getX()+speedX);
        setY(getY()+speedY);
        if(getX()<=0||getX()>=460) {
            speedX*=-1;
        }
        if(getY()<=0) {
            speedY*=-1;
        }

        double ufoX = Main.UFO.getX();
        if(getY()>=600) {
            if(getX()>=ufoX && getX()<=ufoX+120) {
                int scoreNow = Main.menuPane.getScore() +10;
                Main.menuPane.setScoreText(scoreNow);
                imageView.setImage(null);

            }
        }
    }
}
