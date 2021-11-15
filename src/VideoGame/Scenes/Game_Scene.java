package VideoGame.Scenes;

import VideoGame.Elementy.Basket;
import VideoGame.Elementy.BrokenEgg;
import VideoGame.Elementy.Eggs;
import VideoGame.Elementy.Woolf;
import VideoGame.Main;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Random;

public class Game_Scene extends GeneralScene{

private static final String BACKGROUND_IMAGE = "images/tree.png";
private static final String WOLFR = "images/wilk22.png";
    private static final String WOLFL = "images/wilk21.png";
    private static final String WOLFC = "images/wilk321.png";
    private static final String WOLFRD = "images/wilk23.png";
    private static final String WOLFLD = "images/wilk24.png";







private Image background;

    private Image wolfR;
    private Image wolfL;
    private Image wolfC;
    private Image wolfRD;
    private Image wolfLD;

    private Woolf wilk;
    private Basket basket;
    private Eggs jajca=null;
    private Eggs jajca1=null;
    private Eggs jajca2=null;
    private Eggs jajca3=null;
    private BrokenEgg brokenEgg;

    public static int points =0;
    public static float zmiennaLevel=  8.0f;
    private int lives = 5;


    public Game_Scene(){

        super();
        try{
            background=new Image(Files.newInputStream((Paths.get(BACKGROUND_IMAGE))));
            wolfR = new Image(Files.newInputStream((Paths.get(WOLFR))));
            wolfL = new Image(Files.newInputStream((Paths.get(WOLFL))));
            wolfRD = new Image(Files.newInputStream((Paths.get(WOLFRD))));
            wolfLD = new Image(Files.newInputStream((Paths.get(WOLFLD))));

            wolfC = new Image(Files.newInputStream((Paths.get(WOLFC))));


        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw() {


        reset();
        activeKeys.clear();





            new AnimationTimer() {
                @Override
                public void handle(long currentNanoTime) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
                    gc.drawImage(background,0,0);
                    wilk=new Woolf();
                    basket =new Basket(80,80);
                    brokenEgg=new BrokenEgg();

                  if(jajca!=null)
                       jajca.draw(gc);

                  if(jajca1!=null)
                        jajca1.draw(gc);
                    if(jajca2!=null)
                        jajca2.draw(gc);
                    if(jajca3!=null)
                        jajca3.draw(gc);

                    showStatus();


                    if (activeKeys.contains(KeyCode.ESCAPE)) {
                        this.stop();
                        Main.setScene(Main.START_SCENE);
                    } else if (activeKeys.contains(KeyCode.ENTER)) {
                        this.stop();
                        Main.setScene(Main.GAME_OVER_SCENE);

                    }



                    else if(activeKeys.contains(KeyCode.A)){

                       wilk.move1(gc);
                       basket.moveLeftUp(gc);

                    }
                      else
                      if(activeKeys.contains(KeyCode.D)){

                        wilk.move3(gc);
                          basket.moveRightUp(gc);

                    }else
                     if(activeKeys.contains(KeyCode.Y)){

                        wilk.move2(gc);
                         basket.moveLeftDown(gc);

                    }else
                    if(activeKeys.contains(KeyCode.C)){

                        wilk.move4(gc);
                        basket.moveRightDown(gc);

                    }else {  wilk.move0(gc);
                    basket.moveCenter(gc);}



                        int q = 0;
                        int w = 0;

                   if(zmiennaLevel<=0){
                     zmiennaLevel=1;
                                   }
                        Random z=new Random();
                        int zmienna= z.nextInt((int) zmiennaLevel);

                       Random r = new Random();
                        int zrodlo = r.nextInt(4);

                        switch (zrodlo-zmienna) {
                            case 0:
                                q = 0;
                                w = 50;

                                if (jajca == null) {
                                    jajca = new Eggs();
                                    jajca.moveTo(q, w);
                                } else {
                                    jajca.moveRight();

                                }
                                if (jajca.kolizja(basket)) {
                                    points=points+1;
                                    zmiennaLevel=  (int)(zmiennaLevel-0.2f);
                                    jajca = null;
                                    System.out.println("0");
                                } else if (jajca.getY() > 250) {
                                    lives--;
                                    brokenEgg.schowBrokenEggLeft(gc);
                                    jajca=null;
                                }
                                break;

                            case 1:
                                q = 800;
                                w = 170;
                                if (jajca1 == null) {
                                    jajca1 = new Eggs();
                                    jajca1.moveTo(q, w);
                                } else {
                                    jajca1.moveLeft();

                                }
                                if (jajca1.kolizja(basket)) {
                                    points=points+1;
                                    zmiennaLevel=  (int)(zmiennaLevel-0.2f);
                                    jajca1 = null;
                                    System.out.println("1");
                                } else if (jajca1.getY() > 380) {
                                    lives--;
                                    for(int i=0;i<40;i++){
                                        brokenEgg.schowBrokenEggLeft(gc);}
                                    jajca1 = null;
                                }
                                break;
                            case 2:
                                q = 800;
                                w = 50;
                                if (jajca2 == null) {
                                    jajca2 = new Eggs();
                                    jajca2.moveTo(q, w);
                                } else {
                                    jajca2.moveLeft();

                                }
                                if (jajca2.kolizja(basket)) {
                                    points=points+1;
                                    zmiennaLevel=  (int)(zmiennaLevel-0.2f);
                                    jajca2 = null;
                                    System.out.println("2");
                                } else if (jajca2.getY() > 250) {
                                    lives--;
                                    for(int i=0;i<40;i++){
                                        brokenEgg.schowBrokenEggLeft(gc);}

                                    jajca2 = null;
                                }
                                break;

                            case 3:
                                q = 0;
                                w = 170;
                                if (jajca3 == null) {
                                    jajca3 = new Eggs();
                                    jajca3.moveTo(q, w);
                                } else {
                                    jajca3.moveRight();

                                }
                                if (jajca3.kolizja(basket)) {
                                    points=points+1;
                                    zmiennaLevel=  (int)(zmiennaLevel-0.2f);
                                    jajca3 = null;
                                    System.out.println("3");
                                } else if (jajca3.getY() > 380) {
                                    lives--;
                                    for(int i=0;i<40;i++){
                                    brokenEgg.schowBrokenEggLeft(gc);}
                                    jajca3 = null;

                                }
                                break;
                            default:
                                break;
                        }

                        if (lives==0) {
                            this.stop();
                            Main.setScene(Main.START_SCENE);
                        }





                    }
            }.start();


            }

private void reset(){
        lives=5;
        points=0;
}
private void showStatus(){

        Font myFont = Font.font("Arial", FontWeight.EXTRA_BOLD,25);
        gc.setFont((myFont));
        gc.setFill(Color.ORANGE);
        gc.fillText(" Wynik : "+ points,650,30);

        gc.setFill(Color.YELLOW);
        gc.fillText(" Zycia : "+ lives,40,30);
}

    }