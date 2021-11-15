package VideoGame.Scenes;

import VideoGame.Main;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GameOver_Scene extends GeneralScene{
    private static final String BACKGROUND_IMAGE = "images/HallofFame.jpg";
    private Image background;

    public GameOver_Scene(){
        super();
        try{
            background=new Image(Files.newInputStream((Paths.get(BACKGROUND_IMAGE))));
        }catch(Exception e){
            e.printStackTrace();
        }


        gameOverMessage();

    }

    private void gameOverMessage(){

        Font myFont = Font.font("Arial", FontWeight.EXTRA_BOLD,50);
        gc.setFont(myFont);
        gc.setFill(Color.RED);
        gc.fillText(" GAME OVER", 230,200);

        myFont = Font.font("Arial",FontWeight.BOLD,30);
        gc.setFont(myFont);
        gc.setFill(Color.ORANGE);
        gc.fillText(" Twoj Wynik : "+ Game_Scene.points, 300,250);
        gc.setFill(Color.WHITE);
        gc.fillText(" Nacisnij  SPACEBAR  aby  powrocic  na  START ", 50,400);



    }

    public void draw(){


        activeKeys.clear();

            new AnimationTimer() {
                @Override
                public void handle(long currentNanoTime){
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
gc.drawImage(background,0,0);
            gameOverMessage();
            if (activeKeys.contains(KeyCode.SPACE)) {
                this.stop();
                Main.setScene(Main.GAME_OVER_SCENE);
            }

        } }.start();
    }
}
