package lk.ijse.dep.service;


public class BoardImpl implements Board {
    private Piece[][] pieces;
    private BoardUI boardUI;
    public BoardImpl(BoardUI boardUI){
        this.boardUI=boardUI;
        pieces=new Piece[NUM_OF_COLS][NUM_OF_ROWS];

        for (int i=0; i< pieces.length; i++){
            for (int j=0; j<pieces[i].length; j++){
                pieces[i][j]=Piece.EMPTY;
            }
        }
    }

    @Override
    public Piece[][] getPieces(){
        return (pieces);
    }


    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {

        boolean sw = false;
        int i = 0;

        for(i = 0; i < NUM_OF_ROWS; i++) {
            if(pieces[col][i] == Piece.EMPTY){
                sw = true;
                break;
            }
        }

        if(sw == true){
            return(i);
        }else{
            return(-1);
        }

    }

    @Override
    public boolean isLegalMove(int col) {

        boolean sw = false;

        int c = findNextAvailableSpot(col);

        if(c != (-1)) sw = true;

        return(sw);

    }

    @Override
    public boolean ExistLegalMoves() {

        boolean sw = false;

        for(int i = 0; i < NUM_OF_ROWS; i++){
            for(int j = 0; j < NUM_OF_COLS; j++){
                if(pieces[j][i] == Piece.EMPTY){
                    sw = true;
                    break;
                }
            }
        }

        return(sw);

    }

    @Override
    public void updateMove(int col, Piece move) {
        pieces[col][findNextAvailableSpot(col)] = move;
    }

    @Override
    public Winner findWinner() {

        Piece winningPiece = Piece.EMPTY;

        int col1=0;
        int col2=0;
        int row1=0;
        int row2=0;

        for(int i = 0; i < pieces.length; i++){
            if(findNextAvailableSpot(i) == 4 || findNextAvailableSpot(i) == -1){
                if(pieces[i][0] == pieces[i][1] && pieces[i][1] == pieces[i][2] && pieces[i][2] == pieces[i][3]){
                    winningPiece = pieces[i][0];
                    col1=i;
                    col2=i;
                    row1=0;
                    row2=3;

                } else if (pieces[i][1] == pieces[i][2] && pieces[i][2] == pieces[i][3] && pieces[i][3] == pieces[i][4]) {
                    winningPiece=pieces[i][1];
                    col1=i;
                    col2=i;
                    row1=1;
                    row2=4;

                }
            }
        }

        for(int i = 0; i< pieces[i].length; i++){
            if(findAvailability(i) == 4 || findAvailability(i) == 5 || findAvailability(i) == -1){
                if(pieces[0][i] == pieces[1][i] && pieces[1][i] == pieces[2][i] && pieces[2][i] == pieces[3][i]){
                    winningPiece = pieces[0][i];
                    col1=0;
                    col2=3;
                    row1=i;
                    row2=i;
                } else if (pieces[1][i] == pieces[2][i] && pieces[2][i] == pieces[3][i] && pieces[3][i] == pieces[4][i]) {
                    winningPiece=pieces[1][i];
                    col1=1;
                    col2=4;
                    row1=i;
                    row2=i;
                } else if (pieces[2][i] == pieces[3][i] && pieces[3][i] == pieces[4][i] && pieces[4][i] == pieces[5][i]) {
                    winningPiece=pieces[2][i];
                    col1=2;
                    col2=5;
                    row1=i;
                    row2=i;
                }
            }
        }

        Winner winner;

        if(winningPiece == Piece.EMPTY){
            winner= new Winner(winningPiece);
        }else {
            winner= new Winner(col1, col2, row1, row2 ,winningPiece);
        }

        return winner;
    }

    private int findAvailability(int row) {
        int count = 6;
        for(int i = 0; i<pieces.length; i++){
            if(pieces[i][row] == Piece.EMPTY){
                count--;
            }
        }
        if(count == 6){
            count = -1;
        }
        return count;

    }




    @Override
    public void updateMove(int col, int row, Piece move) {
        pieces[col][row] = move;
    }



}



