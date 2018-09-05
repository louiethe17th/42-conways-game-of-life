package com.example.tyler.conwaysgameoflife;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {



    private GameOfLifeView gameOfLifeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        gameOfLifeView = (GameOfLifeView) findViewById(R.id.game_of_life);
    }

    @Override
    protected void onResume(){
        super.onResume();
        gameOfLifeView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameOfLifeView.stop();
    }

    @OnClick(R.id.reset)
    public void resetWorld(){
        gameOfLifeView.initWorld();
    }

    @OnClick(R.id.stop)
    public void stop(){
        gameOfLifeView.stop();
    }

    @OnClick(R.id.start)
    public void start(){
        gameOfLifeView.start();
    }

    @OnClick(R.id.speedDown)
    public void speedDown() {
        if (GameOfLifeView.speed >= 1000){
            Context context = getApplicationContext();
            CharSequence text = "Slowest speed";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            GameOfLifeView.speed = GameOfLifeView.speed + 50;
        }
    }

    @OnClick(R.id.speedUp)
    public void speedUp() {

        if (GameOfLifeView.speed <= 50){
            Context context = getApplicationContext();
            CharSequence text = "Max speed";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            GameOfLifeView.speed = GameOfLifeView.speed - 50;
        }
    }
}
