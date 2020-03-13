package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Active PAlyer 0:red 1:green 2:empty
    int gamestate[]={2,2,2,2,2,2,2,2,2};
    int activePlayer =0;
    int winningState[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int winned=0;//someone winned:1 else 1
    boolean gameActive=true;

    public void dropIn(View view)
    {



            ImageView counter = (ImageView) view;
            int tappedCounter = Integer.parseInt(counter.getTag().toString());
            if(gameActive && gamestate[tappedCounter]==2)
            {
                counter.setTranslationY(-1500);
                gamestate[tappedCounter] = activePlayer;
                if (activePlayer == 0) {
                    counter.setImageResource(R.drawable.red);
                    counter.animate().translationYBy(1500).rotation(3600).setDuration(450);
                    activePlayer = 1;

                } else {
                    counter.setImageResource(R.drawable.green);
                    counter.animate().translationYBy(1500).rotation(3600).setDuration(450);
                    activePlayer = 0;
                }
                for (int winningStates[] : winningState) {
                    if (gamestate[winningStates[0]] == gamestate[winningStates[1]] && gamestate[winningStates[1]] == gamestate[winningStates[2]] && gamestate[winningStates[0]] != 2 && winned != 1) {
                        String winner = "";
                        gameActive = false;
                        if (gamestate[winningStates[0]] == 0) {
                            winner = "Red";
                            winned = 1;
                        } else {
                            winner = "Green";
                            winned = 1;
                        }
                        //Toast.makeText(this, winner + " has won", Toast.LENGTH_SHORT).show();
                        TextView winnerTextView =(TextView) findViewById(R.id.winnerTextView);
                        Button playAgainButton =(Button)findViewById(R.id.playAgain);
                        winnerTextView.setText(winner + " has won");
                        playAgainButton.setVisibility(view.VISIBLE);
                        winnerTextView.setVisibility(view.VISIBLE);


                    }
                }
            }

    }
    public void playAgain(View view)
    {
        TextView winnerTextView =(TextView) findViewById(R.id.winnerTextView);
        Button playAgainButton =(Button)findViewById(R.id.playAgain);
        playAgainButton.setVisibility(view.INVISIBLE);
        winnerTextView.setVisibility(view.INVISIBLE);

//        GridLayout grids=(GridLayout) findViewById(R.id.grids);
        GridLayout grids=(GridLayout)findViewById(R.id.grids);
        //ImageView counter = (ImageView) view;
        for(int j=0;j<grids.getChildCount();j++)
        {
            ImageView counter=(ImageView)grids.getChildAt(j);
            counter.setImageDrawable(null);
        }

        for(int i=0;i<gamestate.length;i++)
        {
            gamestate[i]=2;
        }
        activePlayer =0;
        winned=0;//someone winned:1 else 1
        gameActive=true;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
