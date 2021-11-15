package VideoGame.Elementy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


import java.nio.file.Files;
import java.nio.file.Paths;

public class Woolf {

    Image imageLeft;

    Image imageRight;

    Image imageCenter;

    Image jajo;


    public Woolf(){


        try {
            imageLeft = new Image(Files.newInputStream(Paths.get("images/wilkLeft321.png")));

            imageRight= new Image(Files.newInputStream(Paths.get("images/wilkRight321.png")));

            imageCenter= new Image(Files.newInputStream(Paths.get("images/wilkLeft321.png")));

            jajo= new Image(Files.newInputStream(Paths.get("images/jajo.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void move0(GraphicsContext gc){

       gc.drawImage(imageCenter,350,220);

    }

    public void move1(GraphicsContext gc){


        gc.drawImage(imageLeft,350,220);


    }
    public void move2(GraphicsContext gc){


        gc.drawImage(imageLeft,350,220);


    }   public void move3(GraphicsContext gc){


        gc.drawImage(imageRight,350,220);


    }
  public void move4(GraphicsContext gc){


    gc.drawImage(imageRight,350,220);


}




}
