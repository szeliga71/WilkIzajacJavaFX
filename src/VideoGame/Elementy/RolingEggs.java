package VideoGame.Elementy;



public class RolingEggs extends Frame {


    protected int currentFrameRight;
    protected int currentFrameLeft;


    protected int[]frameRightCoordinates=new int [9];
    protected int[]frameLeftCoordinates=new int [9];

    public RolingEggs(int width, int height) {
        super(width, height);


        currentFrameRight=0;
        currentFrameLeft= 640;
        }


    public void twistRight(){


                currentFrameRight=((currentFrameRight+1)%frameRightCoordinates.length);
            }
    public void twistLeft(){


        currentFrameLeft=((currentFrameLeft+1)%frameLeftCoordinates.length);
    }




    public void updateFrameCoordinatesRight(){

        frameX=frameRightCoordinates[currentFrameRight];

    }
    public void updateFrameCoordinatesLeft(){

        frameX=frameLeftCoordinates[currentFrameLeft];


    }
}



