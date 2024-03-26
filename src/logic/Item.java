package logic;

import application.Main;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import java.util.Random;
public abstract class Item implements Drawable{
    private double x;
    private double y;
    public double speedX;
    public double speedY;
    public boolean isItemOut = false ;
    String star = ClassLoader.getSystemResource("image/Star.png").toString();
    public ImageView imageView = new ImageView(star);
    public Item() {}
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public abstract void move();
    public ImageView getImageView() {
        return imageView;
    }
    public void setImageView(ImageView im) {
        imageView = im;
    }

    protected void initItem() {
		/*====================FILL CODE============================
		Add something on the code below to make new item appear while application
		can be responded*/
        Thread thread = new Thread(() -> {
            updateItem();
        });
        thread.start();

        /*========================================================*/
    }

    protected void updateItem() {
        Item x = this;
        try {
            while(!Main.isGameEnd && !isItemOut) {
                /*===================!DO NOT CHANGE THIS LINE!===========*/
                Thread.sleep(50);
                /*========================================================*/
				/*====================FILL CODE============================
				There is JavaFX commands inside the code below
				Add something to the code below to make JavaFX commands can
				function in the thread
				*/

                this.move();

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Main.drawItem(x);
                        Main.menuPane.setScoreText(Main.menuPane.getScore());
                    }
                });
                /*========================================================*/
            }
            if(isItemOut) {
				/*====================FILL CODE============================
				There is JavaFX commands inside the code below
				Add something to the code below to make JavaFX commands can
				function in the thread
				*/
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Main.pane.getChildren().remove(imageView);
                    }
                });

                /*========================================================*/
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
