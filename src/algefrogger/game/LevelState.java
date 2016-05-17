package algefrogger.game;

//All IEntity's
public class LevelState {

    //@formatter:off
    /* 
     * LevelState uses (x,y) coordinates to place objects.
     * (0,0)     is the pixel in the upper-left corner.
     * (520,480) is the pixel in the lower-right corner.
     * 
     *  _ _ _ _ _ _ _ _ _ _ _ _ _ 
     * |3 | | | 8 | | | 4 | | | 2|
     * |= = = =   = = = =   = =  |
     * | e e   e e   e e   e e   | - 2 long e-turtle
     * |=   = = = = =   = = = =  | - 5 long log (ln148)
     * |  = = =   = = =   = = =  | - 3 long log (ln20)     
     * |p p   p p p   p p p   p p| - 3 long pi-turtles
     * |                         | - plain row
     * |------------7------3-----| - car lane
     * |---2---4--------6--------| - car lane
     * |---------5---------1-----| - car lane
     * |----3-----4-----8--------| - car lane
     * |_ _ _ _ _ _ X _ _ _ _ _ _| - starting row
     */
    //@formatter:on

    public LevelState() {
        // put cars and things in place
    }
}
