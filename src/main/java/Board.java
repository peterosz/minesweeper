import java.util.Random;

public class Board {

    static Board instance = null;
    static char[][] board = null;

    private Board(){}

    public static Board getBoardInstance(){
        if (instance == null){
            instance = new Board();
        }
        return instance;
    }

    public char[][] getBoard(){
        return board;
    }

    public void generate(int x, int y){
        Random random = new Random();
        board = new char[x][y];
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                int chance = random.nextInt(101);
                if (chance < 30){
                    board[i][j] = '*';
                }
                else {
                    board[i][j] = '.';
                }
            }
        }
    }

    public void populate(char[][] board){
    }

    @Override
    public String toString() {
        String printableBoard = "";
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++) {
                    printableBoard += board[i][j] + " ";
                }
            printableBoard += "\n";
            }
        return printableBoard;
    }
}
