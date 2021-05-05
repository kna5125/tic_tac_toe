package com.example.tic_tac_toe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class GameBoard extends View {

    public final int boardColor;
    public final int XColor;
    public final int OColor;
    public final Paint paint = new Paint();
    private final Logic game;
    public int cellSize = getWidth()/3;

    public GameBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        game = new Logic();
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.GameBoard, 0, 0);

        try{
            boardColor = array.getInteger(R.styleable.GameBoard_boardColor, 0);
            XColor = array.getInteger(R.styleable.GameBoard_XColor, 0);
            OColor = array.getInteger(R.styleable.GameBoard_OColor, 0);

        }finally{
            array.recycle();
        }
    }

    @Override
    protected void onMeasure(int width, int height)
    {
        //board size
        super.onMeasure(width, height);
        int dimensions = Math.min(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(dimensions, dimensions);
        cellSize = dimensions/3;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        drawBoard(canvas);
        drawPiece(canvas);


    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float x = event.getX();
        float y = event.getY();

        int action = event.getAction();

        if (action == MotionEvent.ACTION_DOWN)
        {
            int col = (int) Math.ceil(x/cellSize);
            int row = (int) Math.ceil(y/cellSize);
            if(game.updateBoard(row, col))
            {
                invalidate();

                if(game.getPlayer() % 2 == 0)
                {
                    game.setPlayer(game.getPlayer()-1);
                }
                else
                {
                    game.setPlayer(game.getPlayer()+1);
                }
            }
            return true;
        }
        return false;
    }

    private void drawBoard(Canvas canvas)
    {
        paint.setColor(boardColor);
        paint.setStrokeWidth(16);

        for (int x = 1; x<3; x++)
        {
            canvas.drawLine(cellSize*x, 0, cellSize*x, canvas.getWidth(), paint);
        }
        for (int y=1; y<3; y++)
        {
            canvas.drawLine(0, cellSize*y, canvas.getWidth(), cellSize*y, paint);
        }
    }

    private void drawPiece(Canvas canvas)
    {
        for (int i=0; i<3; i++)
        {
            for(int n = 0; n<3; n++)
            {
                if (game.getBoard()[i][n] != 0)
                {
                    if (game.getBoard()[i][n] == 1)
                    {
                        drawXs(canvas, i, n);
                    }
                    else
                    {
                        drawOs(canvas, i, n);
                    }
                }
            }
        }
    }

    private void drawXs(Canvas canvas, int row, int col)
    {
        paint.setColor(XColor);
        canvas.drawLine((float)((col+1)*cellSize - cellSize*0.1), (float)(row*cellSize + cellSize*0.1), (float)(col*cellSize + cellSize*0.1), (float)((row+1)*cellSize - cellSize*0.1), paint);
        canvas.drawLine((float)(col*cellSize + cellSize*0.1), (float)(row*cellSize + cellSize*0.1), (float)((col+1)*cellSize - cellSize*0.1), (float)((row+1)*cellSize - cellSize*0.1), paint);

    }
    private void drawOs(Canvas canvas, int row, int col)
    {
        paint.setColor(OColor);
        canvas.drawOval((float)(col*cellSize + cellSize*0.1), (float)(row*cellSize + cellSize*0.1), (float)((col*cellSize+cellSize) - cellSize*0.1), (float)((row*cellSize+cellSize) - cellSize*0.1), paint);


    }
}
