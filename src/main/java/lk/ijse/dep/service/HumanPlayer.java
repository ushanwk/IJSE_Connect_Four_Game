package lk.ijse.dep.service;

import lk.ijse.dep.service.Board;
import lk.ijse.dep.service.Player;

import static lk.ijse.dep.service.Board.NUM_OF_ROWS;
import static lk.ijse.dep.service.Piece.BLUE;

public class HumanPlayer extends Player {
    public HumanPlayer(Board board) {
        super(board);
    }

    @Override
    public void movePiece(int col) {

        if (board.isLegalMove(col)) {

            board.updateMove(col, BLUE);
            board.getBoardUI().update(col, true);

            Winner winner = board.findWinner();

            if(board.findWinner().getWinningPiece()==Piece.BLUE){
                board.getBoardUI().notifyWinner(winner);
            } else if (!board.ExistLegalMoves()) {
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
            }

        }

    }

}

