package VideoGame.Elementy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.nio.file.Files;
import java.nio.file.Paths;







public class Basket extends Frame {

    private static final String IMAGE_PATH = "images/basket1.png";

    protected Image basketImage;
    public static final int BASKET_WIDTH = 80;
    public static final int BASKET_HEIGHT = 80;
    int a;



    public Basket(int width, int height) {
        super(BASKET_WIDTH,BASKET_HEIGHT);
        this.width = width;
        this.height = height;

        try {
            basketImage = new Image(Files.newInputStream(Paths.get(IMAGE_PATH)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        this.x=x;
        this.y=y;
    }




    public void moveLeftUp(GraphicsContext gc){

x=x+174;
        y=y+224;

        gc.drawImage(basketImage,170,200);


    }
    public void moveLeftDown(GraphicsContext gc){
        x=x+186;
y=y+356;
        gc.drawImage(basketImage,190,350);

    }
    public void moveRightUp(GraphicsContext gc){
        x=x+650;
        y=y+200;
        gc.drawImage(basketImage,650,200);

    }
    public void moveRightDown(GraphicsContext gc){
        x=x+660;
        y=y+310;
        gc.drawImage(basketImage,630,350);

    }
    public void moveCenter(GraphicsContext gc){


        gc.drawImage(basketImage,380,300);}


    }
