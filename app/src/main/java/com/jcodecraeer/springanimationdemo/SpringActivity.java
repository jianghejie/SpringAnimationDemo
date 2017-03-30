package com.jcodecraeer.springanimationdemo;

import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

public class SpringActivity extends AppCompatActivity {

    private SeekBar damping, stiffness;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring);

        //初始化生硬度，设置为弱弹性
        stiffness = (SeekBar) findViewById(R.id.stiffness);
        stiffness.setMax((int)SpringForce.STIFFNESS_HIGH);
        stiffness.setProgress((int)SpringForce.STIFFNESS_LOW);

        //初始化阻尼值，设置为小阻尼
        damping = (SeekBar) findViewById(R.id.damping);
        damping.setProgress((int)(SpringForce.DAMPING_RATIO_HIGH_BOUNCY * 100));

        final View landscape = findViewById(R.id.landscape);

        final SpringAnimation animX = new SpringAnimation(landscape, SpringAnimation.SCALE_X, 0.5f);
        final SpringAnimation animY = new SpringAnimation(landscape, SpringAnimation.SCALE_Y, 0.5f);



        findViewById(R.id.root_view).setOnTouchListener(new View.OnTouchListener() {
            @Override public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        animX.getSpring().setStiffness(getStiffness());
                        animX.getSpring().setDampingRatio(getDamping());
                        animX.getSpring().setFinalPosition(0.5f);

                        animY.getSpring().setStiffness(getStiffness());
                        animY.getSpring().setDampingRatio(getDamping());
                        animY.getSpring().setFinalPosition(0.5f);

                        animX.start();
                        animY.start();

                        return true;

                    case MotionEvent.ACTION_MOVE:

                        return true;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
//                        可以要可以不要
//                        animX.cancel();
//                        animY.cancel();

                        animX.getSpring().setFinalPosition(1);
                        animY.getSpring().setFinalPosition(1);

                        animX.start();
                        animY.start();

                        return true;
                }
                return false;
            }
        });
    }
    private float getStiffness() {
        return Math.max(stiffness.getProgress(), 1f);
    }
    private float getDamping() {
        return damping.getProgress() / 100f;
    }
}
