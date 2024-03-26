package logic;

import application.Main;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Rock extends Item{
    Random rand = new Random();
    public Rock() {
        super();
        setX(rand.nextInt(20,440));
        setY(10);
        speedX = rand.nextInt(2,5) ;
        speedY = rand.nextInt(2,5) ;
        String rock = ClassLoader.getSystemResource("image/Rock.png").toString();
        imageView = new ImageView(rock);

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
        if(getY()>=585) {
            if(getX()>=ufoX && getX()<=ufoX+120) {
                int scoreNow = Main.menuPane.getScore()-10;
                if(scoreNow < 0){
                    Main.isGameEnd = true;
                }else{
                    Main.menuPane.setScore(scoreNow);
                    isItemOut = true;
                }
            } else if (getY() >= 620) {
                isItemOut = true;
            }
        }
    }
}
