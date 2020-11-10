import ChessPackage.*;
import ChessPackage.Pieces.*;
public class App {
    public static void main(String[] args) throws Exception {
        Board b = new Board();
        // The following four statements are equivalent, all check if a rook move from a1 to a8 is allowed
        System.out.println("Rook moves from a1 to a8:");
        System.out.println(b.getSquare(0, 0).getPiece().legalMove(b, b.getSquare(0, 0), b.getSquare(7, 0)));
        System.out.println(b.getSquare("a1").getPiece().legalMove(b, b.getSquare("a1"), b.getSquare("a8")));
        System.out.println(b.getPiece(0, 0).legalMove(b, "a1", "a8"));
        System.out.println(b.getPiece("a1").legalMove(b, "a1", "a8"));
        
        System.out.println("Queen moves:");
        Piece p = b.getSquare("d1").getPiece();
        System.out.println(p);
        System.out.println(p.legalMove(b, b.getSquare("d1"), b.getSquare("e2")));
        System.out.println(p.legalMove(b, "d1", "e2"));
        
        System.out.println("Pawn moves:");
        System.out.println(b.getPiece("e2").legalMove(b, "e2", "e4"));
        System.out.println(b.getPiece("e2").legalMove(b, "e2", "e3"));
        System.out.println(b.getPiece("e2").legalMove(b, "e2", "e1"));
        System.out.println(b.getPiece("e7").legalMove(b, "e7", "e5"));
        System.out.println(b.getPiece("e7").legalMove(b, "e7", "e8"));

        // System.out.println(b.getPiece("e1").legalMove(b, "e2", "e1"));
        // System.out.println(b.getPiece("f3"));

        // for (int i = 0; i < 8; i++) {
        //     System.out.println(b.getSquare(i, 0));
        // }
        // for (int i = 1; i < 9; i++) {
        //     System.out.println(b.getSquare(Character.toString(i+64)+8));
        // }
    }
}