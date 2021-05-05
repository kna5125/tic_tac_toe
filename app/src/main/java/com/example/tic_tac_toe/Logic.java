package com.example.tic_tac_toe;

public class Logic {
    private int [][] board;
    private int player = 1;
    Logic()
    {
       board = new int [3][3];
       for (int i=0; i<3; i++)
       {
           for(int n = 0; n<3; n++)
           {
               board[i][n] = 0;
           }
       }
    }

    public boolean updateBoard(int row, int col)
    {
        if (board[row-1][col-1] == 0)
        {
            board[row-1][col-1] = player;
            return true;
        }
        else
        {
            return false;
        }
    }

    public int [][] getBoard()
    {
        return board;
    }

    public void setPlayer(int player)
    {
        this.player = player;
    }

    public int getPlayer()
    {
        return player;
    }
}
