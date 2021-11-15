package VideoGame.Elementy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.nio.file.Files;
import java.nio.file.Paths;

public class BrokenEgg {


    Image brokenEgg;




    public BrokenEgg(){


        try {
            brokenEgg = new Image(Files.newInputStream(Paths.get("images/brokenEgg.png")));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void schowBrokenEggLeft(GraphicsContext gc){

        gc.drawImage(brokenEgg,200,400);

    }

    public void schowBrokenEggRight(GraphicsContext gc){


        gc.drawImage(brokenEgg,500,400);


    }





}