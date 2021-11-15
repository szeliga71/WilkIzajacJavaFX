package VideoGame.Elementy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Frame {
    protected int width,height;
    protected int x,y;
    protected int frameX,frameY;
    protected Image jajaImage;


    public Frame(int width, int height){
        this.width=width;
        this.height=height;
    }





    public void moveTo(int x,int y){
        this.x=x;
        this.y=y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void draw(GraphicsContext gc) {
        gc.drawImage(jajaImage,frameX, frameY, width, height, x, y, width, height);
    }

    public boolean kolizja(Frame frame){

                return(y==frame.y &&x==frame.x);
    }
}
