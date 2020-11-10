package ChessPackage.Pieces;

import ChessPackage.Board;
import ChessPackage.Square;

public class Bishop extends Piece {
    
    public Bishop (char color) {
        super(color);
        this.name = "Bishop";
    }
    
    /**
     * legalMove method for the Bishop class
     * Bishops move diagonally. A Bishop move is legal if
     * Math.abs( (difference in file) / (difference in rank) ) == 1
     * @param board the Board the game is played on
     * @param startSquare the Square the Bishop is on
     * @param endSquare the Square the Bishop tries to move to
     * @return true if the move from startSquare to endSquare is legal, false otherwise
     */
    public boolean legalMove(Board board, Square startSquare, Square endSquare) {
        // Disallow 'moving' to the start square or to a square with a friendly piece
        if (startSquare.equals(endSquare) ||
            (endSquare.getPiece() != null && this.color == endSquare.getPiece().getColor()))
            return false;
        int startFile = startSquare.getFile();
        int startRank = startSquare.getRank();
        int endFile = endSquare.getFile();
        int endRank = endSquare.getRank();
        // Check if move is a proper diagonal move
        if ( Math.abs( (startFile - endFile) / (startRank - endRank) ) != 1 )
            return false;
        // Moving right and up
        if (endFile > startFile && endRank > startRank)
            return checkForObstructions(board, endFile, startFile, startRank);
        // Moving right and down
        if (endFile > startFile && startRank > endRank)
            return checkForObstructions(board, endFile, startFile, endRank);
        // Moving left and down
        if (startFile > endFile && startRank > endRank)
            return checkForObstructions(board, startFile, endFile, endRank);
        // Moving left and up
        if (startFile > endFile && endRank > startRank)
            return checkForObstructions(board, startFile, endFile, startRank);
        return false;
    }
    /**
     * Convenience method, gets the squares indicated by the Strings,
     * then calls legalMove(Board, Square, Square)
     * @param board the Board the game is played on
     * @param startSquare String representation of the Square the Bishop is on
     * @param endSquare String representation of the Square the Bishop tries to move to
     */
    public boolean legalMove(Board board, String startSquare, String endSquare) {
        return this.legalMove(board, board.getSquare(startSquare), board.getSquare(endSquare));
    }

    /**
     * Method to check if there are any pieces in the way. Checks squares
     * starting at the lowest numerical file and rank values in the proposed
     * move, then moves towards the highest numerical file and rank values
     * @param board the Board the game is played on
     * @param highFile value used to terminate the for-loop. Comparing lowFile
     * and highFile vs lowRank and highRank makes technically makes no difference.
     * In this implementation checking files was chosen
     * @param lowFile the moves file with the lowest numerical value
     * @param lowRank the moves rank with the lowest numerical value
     * @return true if there are no pieces obstructing the move, false otherwise
     */
    public boolean checkForObstructions(Board board, int highFile, int lowFile, int lowRank) {
        for(int file = lowFile, rank = lowRank; file < highFile; file++, rank++) {
            if(board.getSquare(file, rank).getPiece() != null) {
                return false;
            }
        }
        return true;
    }
}

