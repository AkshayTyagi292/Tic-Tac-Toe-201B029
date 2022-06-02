package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int ic=-1;
    int player=1;
    int[][]winners={{0,1,2},{3,4,5},{6,7,8}};
    int []gameState={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view){

        ImageView v = (ImageView) view;
        int tag = Integer.parseInt(v.getTag().toString());
        ic=gameState[tag];
        if(isWinner==false&&ic==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                gameState[tag] = player;
                Toast.makeText(this, tag + "" + "Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero);
                gameState[tag] = player;
                Toast.makeText(this, tag + "" + "Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int i = 0; i < winners.length; i++) {
                if (gameState[winners[i][0]] == gameState[winners[i][1]] && gameState[winners[i][1]] == gameState[winners[i][2]] && gameState[winners[i][0]] > -1) {
                    Toast.makeText(this, "Winner is" + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                }
            }
        }
    }
    public void  reset(View view) {
        GridLayout gridLayout=findViewById(R.id.grid);
        int total=gridLayout.getChildCount();
        for(int i=0;i<total;i++){
            ImageView v=(ImageView)gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner=false;
        ic=-1;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=-1;

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}