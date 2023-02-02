package lk.ijse.dep.service;

import static java.lang.Integer.max;
import static java.lang.Integer.min;


public class AiPlayer extends Player {
    public AiPlayer(Board board) {
        super(board);
    }

    @Override
    public void movePiece(int col) {

        //Random Numbers generate call

       /* do{
            col=(int)((Math.random() * (6-0))+0);
        }while (!board.isLegalMove(col));

        board.updateMove(col,Piece.GREEN);
        board.getBoardUI().update(col,false);

        Winner winner = board.findWinner();

        if(board.findWinner().getWinningPiece()==Piece.GREEN){
            board.getBoardUI().notifyWinner(winner);
        } else if (!board.ExistLegalMoves()) {
         board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }*/


        //==============================================================


        //Minimax algorithm call


       /*miniMax(2, true);

       board.updateMove(col,Piece.GREEN);
        board.getBoardUI().update(col,false);

        Winner winner = board.findWinner();

        if(board.findWinner().getWinningPiece()==Piece.GREEN){
            board.getBoardUI().notifyWinner(winner);
        } else if (!board.ExistLegalMoves()) {
            board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }*/

        //===============================================================


        //My Ai Method call

        col = colFind();

        board.updateMove(col, Piece.GREEN);
        board.getBoardUI().update(col, false);

        Winner winner = board.findWinner();

        if (board.findWinner().getWinningPiece() == Piece.GREEN) {
            board.getBoardUI().notifyWinner(winner);
        } else if (!board.ExistLegalMoves()) {
            board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        }

    }



    //==============================================================


    //MiniMax method create

   /* int miniMax(int depth, boolean maximizingPlayer) {

        Piece[][] p = board.getPieces();


        if (depth == 0 || !board.ExistLegalMoves()) {

            board.updateMove(0, Piece.GREEN);
            board.getBoardUI().update(0, false);

            Winner winner = board.findWinner();

            if (board.findWinner().getWinningPiece() == Piece.GREEN) {
                board.getBoardUI().notifyWinner(winner);
            } else if (!board.ExistLegalMoves()) {
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
            }

        }

        if (maximizingPlayer) {

            int maxEval = -1000000000;
            int heu;

            for (int i = 0; i < p.length; i++) {
                if (p[i][board.findNextAvailableSpot(i)] == Piece.EMPTY) {
                    heu = miniMax(depth - 1, false);
                    maxEval = max(maxEval, heu);
                }
            }

            return maxEval;

        } else {

            int minEval = +1000000000;
            int heu;

            for (int i = 0; i < p.length; i++) {

                if (p[i][board.findNextAvailableSpot(i)] == Piece.EMPTY) {
                    heu = miniMax(depth - 1, true);
                    minEval = min(minEval, heu);
                }

            }

            return minEval;

        }*/


        //=====================================================================


        //My AI method create


   public int colFind() {

        Piece[][] p = board.getPieces();
        int col;

        boolean sw = false;

        for (col = 0; col < 6; col++) {

            if (p[col][0] == p[col][1] && p[col][1] == p[col][2] && p[col][0] == Piece.GREEN){
                if(p[col][3] == Piece.EMPTY){
                    sw = true;
                    break;
                }else{
                    break;
                }
            }else if(p[col][1] == p[col][2] && p[col][2] == p[col][3] && p[col][1] == Piece.GREEN){
                if(p[col][4] == Piece.EMPTY){
                    sw = true;
                    break;
                }else{
                    break;
                }
            }






            if (p[col][0] == p[col][1] && p[col][1] == p[col][2] && p[col][0] == Piece.BLUE){
                if(p[col][3] == Piece.EMPTY){
                    sw = true;
                    break;
                }else{
                    break;
                }
            }else if(p[col][1] == p[col][2] && p[col][2] == p[col][3] && p[col][1] == Piece.BLUE){
                if(p[col][4] == Piece.EMPTY){
                    sw = true;
                    break;
                }else{
                    break;
                }
            }

        }





        if(sw == false){

            do{
                col=(int)((Math.random() * (6-0))+0);
            }while (!board.isLegalMove(col));

            boolean w = false;

            for(int row = 0; row < 5; row++){

                if(p[0][row] == p[1][row] && p[1][row] == p[2][row] && p[0][row] == Piece.GREEN){
                    if(row == 0){
                        if(p[3][row] == Piece.EMPTY){
                            col = 3;
                            w = true;
                            break;
                        }
                    }else{
                        if(p[3][row] == Piece.EMPTY && p[3][row-1] != Piece.EMPTY){
                            col = 3;
                            w = true;
                            break;
                        }
                    }
                }


                if(p[1][row] == p[2][row] && p[2][row] == p[3][row] && p[1][row] == Piece.GREEN){
                    if(row == 0){
                        if(p[4][row] == Piece.EMPTY){
                            col = 4;
                            w = true;
                            break;
                        }
                    }else{
                        if(p[4][row] == Piece.EMPTY && p[4][row-1] != Piece.EMPTY){
                            col = 4;
                            w = true;
                            break;
                        }
                    }
                }


                if(p[2][row] == p[3][row] && p[3][row] == p[4][row] && p[2][row] == Piece.GREEN){
                    if(row == 0){
                        if(p[5][row] == Piece.EMPTY){
                            col = 5;
                            w = true;
                            break;
                        }
                    }else{
                        if(p[5][row] == Piece.EMPTY && p[5][row-1] != Piece.EMPTY){
                            col = 5;
                            w = true;
                            break;
                        }
                    }
                }





                if(p[1][row] == p[2][row] && p[2][row] == p[3][row] && p[1][row] == Piece.GREEN){
                    if(row == 0){
                        if(p[0][row] == Piece.EMPTY){
                            col = 0;
                            w = true;
                            break;
                        }
                    }else{
                        if(p[0][row] == Piece.EMPTY && p[0][row-1] != Piece.EMPTY){
                            col = 0;
                            w = true;
                            break;
                        }
                    }
                }

                if(p[2][row] == p[3][row] && p[3][row] == p[4][row] && p[2][row] == Piece.GREEN){
                    if(row == 0){
                        if(p[1][row] == Piece.EMPTY){
                            col = 1;
                            w = true;
                            break;
                        }
                    }else{
                        if(p[1][row] == Piece.EMPTY && p[1][row-1] != Piece.EMPTY){
                            col = 1;
                            w = true;
                            break;
                        }
                    }
                }

                if(p[3][row] == p[4][row] && p[4][row] == p[5][row] && p[3][row] == Piece.GREEN){
                    if(row == 0){
                        if(p[2][row] == Piece.EMPTY){
                            col = 2;
                            w = true;
                            break;
                        }
                    }else{
                        if(p[2][row] == Piece.EMPTY && p[2][row-1] != Piece.EMPTY){
                            col = 2;
                            w = true;
                            break;
                        }
                    }
                }









                if(p[0][row] == p[1][row] && p[1][row] == p[2][row] && p[0][row] == Piece.BLUE){
                    if(row == 0){
                        if(p[3][row] == Piece.EMPTY){
                            col = 3;
                            w = true;
                            break;
                        }
                    }else{
                        if(p[3][row] == Piece.EMPTY && p[3][row-1] != Piece.EMPTY){
                            col = 3;
                            w = true;
                            break;
                        }
                    }
                }


                if(p[1][row] == p[2][row] && p[2][row] == p[3][row] && p[1][row] == Piece.BLUE){
                    if(row == 0){
                        if(p[4][row] == Piece.EMPTY){
                            col = 4;
                            w = true;
                            break;
                        }
                    }else{
                        if(p[4][row] == Piece.EMPTY && p[4][row-1] != Piece.EMPTY){
                            col = 4;
                            w = true;
                            break;
                        }
                    }
                }


                if(p[2][row] == p[3][row] && p[3][row] == p[4][row] && p[2][row] == Piece.BLUE){
                    if(row == 0){
                        if(p[5][row] == Piece.EMPTY){
                            col = 5;
                            w = true;
                            break;
                        }
                    }else{
                        if(p[5][row] == Piece.EMPTY && p[5][row-1] != Piece.EMPTY){
                            col = 5;
                            w = true;
                            break;
                        }
                    }
                }






                if(p[1][row] == p[2][row] && p[2][row] == p[3][row] && p[1][row] == Piece.BLUE){
                    if(row == 0){
                        if(p[0][row] == Piece.EMPTY){
                            col = 0;
                            w = true;
                            break;
                        }
                    }else{
                        if(p[0][row] == Piece.EMPTY && p[0][row-1] != Piece.EMPTY){
                            col = 0;
                            w = true;
                            break;
                        }
                    }
                }

                if(p[2][row] == p[3][row] && p[3][row] == p[4][row] && p[2][row] == Piece.BLUE){
                    if(row == 0){
                        if(p[1][row] == Piece.EMPTY){
                            col = 1;
                            w = true;
                            break;
                        }
                    }else{
                        if(p[1][row] == Piece.EMPTY && p[1][row-1] != Piece.EMPTY){
                            col = 1;
                            w = true;
                            break;
                        }
                    }
                }

                if(p[3][row] == p[4][row] && p[4][row] == p[5][row] && p[3][row] == Piece.BLUE){
                    if(row == 0){
                        if(p[2][row] == Piece.EMPTY){
                            col = 2;
                            w = true;
                            break;
                        }
                    }else{
                        if(p[2][row] == Piece.EMPTY && p[2][row-1] != Piece.EMPTY){
                            col = 2;
                            w = true;
                            break;
                        }
                    }
                }




            }

            if(w == false){
                do{
                    col=(int)((Math.random() * (6-0))+0);
                }while (!board.isLegalMove(col));
            }


        }



        return (col);

    }

    }


