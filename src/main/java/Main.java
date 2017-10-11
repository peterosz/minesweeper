public class Main {

    public static void main(String[] args) {
        Board board = null;
        board = board.getBoardInstance();
        board.generate(10,10);
        System.out.println(board.toString());
        board.populate();
        System.out.print(board.toString());
    }
}
