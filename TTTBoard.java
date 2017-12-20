package dm550.tictactoe;

/**
 * represents a tic tac toe board of a given size
 */
public class TTTBoard {

    /**
     * 2-dimensional array representing the board
     * coordinates are counted from top-left (0,0) to bottom-right (size-1, size-1)
     * board[x][y] == 0   signifies free at position (x,y)
     * board[x][y] == i   for i > 0 signifies that Player i made a move on (x,y)
     */
    private int[][] board;

    /**
     * size of the (quadratic) board
     */
    private int size;

    /**
     * constructor for creating a copy of the board
     * not needed in Part 1 - can be viewed as an example
     */
    public TTTBoard(TTTBoard original) {
        this.size = original.size;
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                this.board[y][x] = original.board[y][x];
            }
        }
    }

    /**
     * constructor for creating an empty board for a given number of players
     */
    public TTTBoard(int numPlayers) {
        this.size = numPlayers + 1;
        this.board = new int[this.getSize()][this.getSize()];
    }

    /**
     * checks whether the board is free at the given position
     */
    public boolean isFree(Coordinate c) {
        // TODO
        if (!c.checkBoundaries(this.getSize() - 1, this.getSize() - 1)) {
            throw new IllegalArgumentException("Enter a new coordinate");
        }
        return (this.board[c.getY()][c.getX()] == 0);
    }


    /**
     * returns the players that made a move on (x,y) or 0 if the positon is free
     */
    public int getPlayer(Coordinate c) {
        // TODo
        if (isFree(c)) {
            return 0;
        } else return this.board[c.getY()][c.getX()];
    }

    /**
     * record that a given player made a move at the given position
     * checks that the given positions is on the board
     * checks that the player number is valid
     */
    public void addMove(Coordinate c, int currentPlayer) {
        // TODO
        if (!c.checkBoundaries(this.getSize(), this.getSize()) || currentPlayer >= this.getSize()) {
            throw new IllegalArgumentException("this coordinate sucks!");

        }
        this.board[c.getY()][c.getX()] = currentPlayer;
    }

    /**
     * returns true if, and only if, there are no more free positions on the board
     */
    public boolean checkFull() {
        // TODO
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                if (this.board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * returns 0 if no player has won (yet)
     * otherwise returns the number of the player that has three in a row
     */
    public int checkWinning() {
        //todo

        for (int i = 0; i <= this.getSize() - 1; i++) {
            int returnvalue1 = checkSequence(new XYCoordinate(0, i), 1, 0);
            int returnvalue2 = checkSequence(new XYCoordinate(i, 0), 0, 1);
            int returnvalue3 = checkSequence(new XYCoordinate(0, i), 1, 1);
            int returnvalue4 = checkSequence(new XYCoordinate(i, 0), 1, 1);
            int returnvalue5 = checkSequence(new XYCoordinate(0, i), 1, -1);
            int returnvalue6 = checkSequence(new XYCoordinate(i, this.getSize() - 1), 1, -1);
            if (returnvalue1 > 0) {
                return returnvalue1;
            }

            if (returnvalue2 > 0) {
                return returnvalue2;
            }
            if (returnvalue3 > 0) {
                return returnvalue3;
            }
            if (returnvalue4 > 0) {
                return returnvalue4;
            }
            if (returnvalue5 > 0) {
                return returnvalue5;
            }
            if (returnvalue6 > 0) {
                return returnvalue6;
            }
        }

        return 0;
    }

    /**
     * internal helper function checking one row, column, or diagonal
     */
    private int checkSequence(Coordinate start, int dx, int dy) {
        //todo
        int x = start.getX();
        int y = start.getY();
        int x2 = x + dx + dx;
        int y2 = y + dy + dy;
        if ((x < 0) || (x > this.size-1)) return 0;
        if ((y < 0) || (y > this.size-1)) return 0;
        if ((x2 < 0) || (x2 > this.size-1)) return 0;
        if ((y2 < 0) || (y2 > this.size-1)) return 0; //Makes sure the checkwinning can't
        //return any harmful values
        if (this.board[x][y] == this.board[x + dx][y + dy] &&
                this.board[x][y] == this.board[x2][y2]) {
            return this.board[x][y]; //compares the start coordinate with the input values from
            //check winning and returns the value if it's found to be true.
        } return 0;
    }

    /**
     * /** getter for size of the board
     */
    public int getSize() {
        return this.size;
    }

    /**
     * pretty printing of the board
     * usefule for debugging purposes
     */

    public String toString() {
        String result = "";
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                result += this.board[y][x] + " ";
            }
            result += "\n";
        }
        return result;
    }
}