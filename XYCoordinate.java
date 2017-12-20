package dm550.tictactoe;

public class XYCoordinate implements Coordinate {

    /**
     * variables specifying horizontal position on the board
     */
    private int x;

    /**
     * variable specifying vertical positoin on the board
     */
    private int y;

    /**
     * constructor creating a Coordinate from x and y values
     */
    public XYCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public boolean checkBoundaries(int xSize, int ySize) {
        // TODO
        if (this.x < 0 || this.y < 0 || this.x > xSize || this.y > ySize) { // Checks if the xy-coordinates are below 0 or above the size of the board,
            // to ensure the coordinate is within the set boundary
            return false; // returns false if above statement is true
        } else return true;
    }

    @Override
    public Coordinate shift(int dx, int dy) {
        // TODO
            int x = this.x + dx;
            int y = this.y + dy;
            return new XYCoordinate(x,y);


    }

}
