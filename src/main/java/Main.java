public class Main {

    public static void main(String[] args) {
        Board board = null;
        board = board.getBoardInstance();
        board.generate(4,4);
        System.out.println(board.toString());
    }
}
