package VideoGame;

import VideoGame.Scenes.GameOver_Scene;
import VideoGame.Scenes.Game_Scene;
import VideoGame.Scenes.GeneralScene;
import VideoGame.Scenes.StartScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int TOTAL_SCENES =3;
    public static  final int START_SCENE= 0;
    public static final int GAME_SCENES =1;
    public static  final int GAME_OVER_SCENE= 2;

    public static GeneralScene[]scenes=new GeneralScene[TOTAL_SCENES];

    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception{
        this.stage=stage;

        scenes[0]= new StartScene();
        scenes[1]=new Game_Scene();
        scenes[2]=new GameOver_Scene();

        stage.setTitle(" Nu  PAGODI !!!!");
        setScene(START_SCENE);
        stage.show();

    }

    public static void setScene(int numScene){
        stage.setScene(scenes[numScene]);
        scenes[numScene].draw();
    }

    public static void exit(){

        stage.hide();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
