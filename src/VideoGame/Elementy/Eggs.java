package VideoGame.Elementy;

import javafx.scene.image.Image;


import java.nio.file.Files;
import java.nio.file.Paths;

public class Eggs extends RolingEggs {


    private static final String IMAGE_PATH = "images/jajaco.png";
    public static int EGG_STATE = 2;
    public static final int EGG_WIDTH = 80;
    public static final int EGG_HEIGHT = 80;


    public Eggs() {
        super(EGG_WIDTH, EGG_HEIGHT);
        try {
            jajaImage = new Image(Files.newInputStream(Paths.get(IMAGE_PATH)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        frameRightCoordinates = new int[]{0, 80, 160, 240, 320, 400, 480, 560, 640};

        frameLeftCoordinates=new int[]{640,560,480,400,320,240,160,80,0};



    }

    public void moveRight() {


            this.x=this.x+2;
            y=y+2;

           twistRight();
           updateFrameCoordinatesRight();

        }
    public void moveLeft() {

        this.x=this.x-2;
        y=y+2;
        twistLeft();
        updateFrameCoordinatesLeft();

    }

    }





