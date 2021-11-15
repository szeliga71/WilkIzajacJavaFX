package VideoGame.Scenes;

import VideoGame.Main;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.nio.file.Files;
import java.nio.file.Paths;

public class StartScene extends GeneralScene {
    private static final String BACKGROUND_IMAGE = "images/wilkIzajac.jpg";
    private Image background;

    public StartScene() {
        super();
        try{
            background=new Image(Files.newInputStream((Paths.get(BACKGROUND_IMAGE))));
        }catch(Exception e){
            e.printStackTrace();
        }


        welcomeMessage();

    }

    private void welcomeMessage() {




       Font myFont = Font.font("Arial", FontWeight.BOLD, 20);
        gc.setFont(myFont);
        gc.setFill(Color.YELLOW);
        gc.fillText(" PRESS SPACEBAR TO PLAY ", 300, 200);


    }

    public void draw() {

        activeKeys.clear();

            new AnimationTimer()
            {
                @Override
                public void handle(long currentNanoTime) {

                    gc.setFill(Color.BLACK);
                    gc.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

                    gc.drawImage(background,0,0);


                    welcomeMessage();

                    if (activeKeys.contains(KeyCode.SPACE)) {
                        this.stop();
                        Main.setScene(Main.GAME_SCENES);
                    } else if (activeKeys.contains(KeyCode.ESCAPE)) {
                        this.stop();
                        Main.exit();
                    }


                } }.start();
        }





    }



