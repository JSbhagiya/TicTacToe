package com.example.android.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button[][] buttons= new Button[3][3];
    boolean Player1=true;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Array of buttons to store the reference of all the buttons


        Button newgame= (Button)findViewById(R.id.buttonnewgame);

        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();




            }
        });

        Toast.makeText(this,"Player 1 turn",Toast.LENGTH_SHORT).show();




        int i,j;
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                String id= "Button"+i+j;
                int buttonid= getResources().getIdentifier(id,"id",getPackageName());
                buttons[i][j]=(Button)findViewById(buttonid);
                buttons[i][j].setOnClickListener(this);
            }
        }

    }

    @Override
    public void onClick(View v) {
        if(!((Button) v).getText().toString().equals(""))
        {
            Toast.makeText(this,"Try another box",Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            if(Player1)
            {
                ((Button)v).setText("X");

            }
            else
            {
                ((Button)v).setText("0");

            }
        }
        Log.v("Main Activity",((Button) v).getText().toString());
        count++;
        if(win())
        {
            if(Player1)
            {
                Toast.makeText(this,"Player 1 wins",Toast.LENGTH_SHORT).show();
                reset();
            }
            else
            {
                Toast.makeText(this,"Player 2 wins",Toast.LENGTH_SHORT).show();
                reset();
            }
        }

        else if(count==9)
        {
            Toast.makeText(this,"OOPS!! It is a draw",Toast.LENGTH_SHORT).show();
            reset();
        }
        else
        {
            Player1=!Player1;
            if(Player1)
            {
                Toast.makeText(this,"Player 1 turn",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,"Player 2 turn",Toast.LENGTH_SHORT).show();
            }
        }


    }

    boolean win()
    {
        String values[][]= new String[3][3];

        int i,j;
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                values[i][j]= buttons[i][j].getText().toString();
            }
        }

        for(i=0;i<3;i++)
        {
            if(values[i][0]==values[i][1]&& values[i][0]==values[i][2] && !values[i][0].equals(""))
            {
                return true;
            }
        }
        for(i=0;i<3;i++)
        {
            if(values[0][i]==values[1][i]&& values[0][i]==values[2][i] && !values[0][i].equals(""))
            {
                return true;
            }
        }
        if(values[0][0]==values[1][1]&& values[0][0]==values[2][2] && !values[0][0].equals(""))
        {
            return true;
        }

        if(values[0][2]==values[1][1]&& values[0][2]==values[2][0] && !values[0][2].equals(""))
        {
            return true;
        }
        return false;


    }



    void reset()
    {
        count=0;
        Player1=true;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                buttons[i][j].setText("");
            }
        }
        Toast.makeText(getApplicationContext(),"New Game",Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"Player 1 turn",Toast.LENGTH_SHORT).show();
    }
}



