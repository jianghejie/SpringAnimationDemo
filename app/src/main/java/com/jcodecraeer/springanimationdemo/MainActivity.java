package com.jcodecraeer.springanimationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonSpring ;
    private Button buttonRebound ;
    private Button buttonBall ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSpring = (Button)findViewById(R.id.spring);
        buttonRebound = (Button)findViewById(R.id.rebound);
        buttonBall = (Button)findViewById(R.id.ball);

        buttonSpring.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,SpringActivity.class);
                startActivity(intent);
            }
        });

        buttonRebound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ReboundActivity.class);
                startActivity(intent);
            }
        });

        buttonBall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,BallActivity.class);
                startActivity(intent);
            }
        });
    }

}
