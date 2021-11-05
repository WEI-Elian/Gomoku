package gomoku.BasicClass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class Board implements Serializable {

    private String player1;
    private String player2;
    private int[][] chessboard=new int[16][16];
    private ArrayList<Step> steps=new ArrayList<>();

    private String boardname;
  /*  private ArrayList<Step> ordersteps=new ArrayList<>();
    private Stack<Step> reversesteps=new Stack<>();*/


    public Board(String player1,String player2,int[][] chessboard,String boardname,ArrayList<Step> steps){
        this.player1=player1;
        this.player2=player2;
        this.chessboard=chessboard;
        this.boardname=boardname;
        this.steps=steps;

    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(Step step) {
        this.steps.add(step);
    }



    public String getBoardname() {
        return boardname;
    }

    public void setBoardname(String boardname) {
        this.boardname = boardname;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public int[][] getChessboard() {
        return chessboard;
    }

    public void setChessboard(int[][] chessboard) {
        this.chessboard = chessboard;
    }


}
