package com.example.android79;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create the board squares
        ImageView[][] boardSquares = new ImageView[8][8];
        GridLayout gridLayout = findViewById(R.id.grid_layout);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                ImageView square = new ImageView(this);
                boardSquares[row][col] = square;
                // set the attributes of the square ImageView
                // such as the size, background color, padding, etc.
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(row, 1f);
                params.columnSpec = GridLayout.spec(col, 1f);
                gridLayout.addView(square, params);
            }
        }
        // update the board squares colors based on the game state
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    boardSquares[row][col].setBackgroundColor(getResources().getColor(R.color.light_square_color));
                } else {
                    boardSquares[row][col].setBackgroundColor(getResources().getColor(R.color.dark_square_color));
                }
            }
        }

        // TODO: load the initial pieces images

        // update the board and pieces images based on the game state
        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                Piece piece = game.getPieceAt(row, col);
                if (piece != null)
                {
                    int imageResource = getImageResourceForPiece(piece);
                    boardSquares[row][col].setImageResource(imageResource);
                }
                else
                {
                    boardSquares[row][col].setImageResource(imageResource);
                }
            }
        }
    }
}