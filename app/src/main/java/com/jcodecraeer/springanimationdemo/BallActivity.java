package com.jcodecraeer.springanimationdemo;

import android.content.Intent;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BallActivity extends AppCompatActivity {

    private Button buttonBounce ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball);
        buttonBounce = (Button)findViewById(R.id.bounce);
        final View ball = findViewById(R.id.ball);



        SpringForce springForce = new SpringForce(0)
                .setDampingRatio(0.05f)
                .setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        final SpringAnimation anim = new SpringAnimation(ball ,SpringAnimation.TRANSLATION_Y).setSpring(springForce);

        buttonBounce.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                anim.cancel();
                anim.setStartValue(-700);
                anim.start();
            }
         });

    }
}
