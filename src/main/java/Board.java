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

    public void generate(int x, int y){
        Random random = new Random();
        board = new char[x][y];
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                int chance = random.nextInt(101);
                if (chance < 30){ //30% chance to add a bomb
                    board[i][j] = '*';
                }
                else {
                    board[i][j] = '.';
                }
            }
        }
    }

    public void populate(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == '.'){
                    board[i][j] = bombsNearby(i, j);
                }
            }
        }
    }

    private char bombsNearby(int x, int y){
        int count = 0;
        int[] combinationsX = new int[]{x - 1, x, x + 1};
        int[] combinationsY = new int[]{y - 1, y, y + 1};

        for (int comboX: combinationsX){
            for (int comboY: combinationsY){
                try{
                    char temp = board[comboX][comboY];
                    if (temp == '*') count++;
                } catch (ArrayIndexOutOfBoundsException e){}
            }
        }

        char result = (char) (count + '0');
        return result;
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
