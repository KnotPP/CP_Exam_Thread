package logic;
import application.Main;
import javafx.application.Platform;
import javafx.scene.image.ImageView;
import java.util.Random;
public class UFO implements Drawable{
    private double x;
    private double y;
    public ImageView imageView;

    public UFO() {
        String ufo = ClassLoader.getSystemResource("image/UFO.png").toString();
        imageView = new ImageView(ufo);
        imageView.setFitWidth(120);
        imageView.setFitHeight(40);

        setX(200);
        setY(600);
        initUFO();
    }
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

    public void move(int dir) {
        if(dir==1) {
            setX(getX()+20);
        }
        else {
            setX(getX()-20);
        }
            if(getX()<=0)setX(0);
            if(getX()>=380)setX(380);
    }

    public ImageView getImageView() {
        return imageView;
    }
    public void setImageView(ImageView im) {
        imageView = im;
    }

    protected void initUFO() {
		/*====================FILL CODE============================
		Add something on the code below to make new paddle appear while application
		can be responded*/
        Thread thread = new Thread(){
            @Override
            public void run() {
                updateUFO();
            }
        };
        thread.start();

        /*========================================================*/
    }
    protected void updateUFO() {
        UFO x = this;
        try {
            while(!Main.isGameEnd) {
                /*===================!DO NOT CHANGE THIS LINE!===========*/
                Thread.sleep(50);
                /*========================================================*/
				/*====================FILL CODE============================
				There is JavaFX commands inside the code below
				Add something to the code below to make JavaFX commands can
				function in the thread
				*/

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Main.drawItem(x);

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
