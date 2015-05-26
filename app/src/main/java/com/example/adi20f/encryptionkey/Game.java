package com.example.adi20f.encryptionkey;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.*;

public class Game extends ActionBarActivity implements OnClickListener {
    Button mButton;
    EditText mEdit;
    TextView correct;
    TextView question;
    int total;
    boolean answer;
    Handler handler = new Handler();

    public Game() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mButton = (Button) findViewById(R.id.button_submit);
        mButton.setOnClickListener(this);
        mEdit = (EditText) findViewById(R.id.answer);
        correct = (TextView) findViewById(R.id.correct);
        question = (TextView) findViewById(R.id.question);
        total = 0;
        answer = true;
        concentration();


    }

    public void concentration() {
        mEdit.setText("");
        correct.setText("");
        Random rand = new Random();
        String north = "North";
        int northNum = 1;
        String east = "East";
        int eastNum = 2;
        String south = "South";
        int southNum = 3;
        String west = "West";
        int westNum = 4;
        int offset = rand.nextInt(4) + 1;
        int direction = rand.nextInt(4) + 1;

        int counter = 0;

        if (direction == 1) {
            question.setText(north + " " + offset);
            total = northNum + offset;
        } else if (direction == 2) {
            question.setText(east + " " + offset);
            total = eastNum + offset;
        } else if (direction == 3) {
            question.setText(south + " " + offset);
            total = southNum + offset;
        } else {
            question.setText(west + " " + offset);
            total = westNum + offset;
        }
        total = total % 4;


    }

    public void onClick(View v) {
        String answer = mEdit.getText().toString();
        if ((answer.equals("north") && total == 1) || (answer.equals("east") && total == 2) || (answer.equals("south") && total == 3) || (answer.equals("west") && total == 0)) {
            correct.setText("Congratulation you beat the game!");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 5000);

        } else {
            correct.setText("Oops! try again in 5 seconds");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    concentration();
                }
            }, 5000);
        }
    }

}
